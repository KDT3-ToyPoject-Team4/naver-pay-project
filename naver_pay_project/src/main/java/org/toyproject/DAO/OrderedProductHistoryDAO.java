package org.toyproject.DAO;

import org.toyproject.DB.JDBCMgr;
import org.toyproject.Entity.OrderedProductHistoryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderedProductHistoryDAO {

    private static OrderedProductHistoryDAO orderedProductHistoryDAO = null;
    private Connection conn=null;
    private PreparedStatement stmt=null;
    private ResultSet rs=null;

    //해당 과거제품주문 목록 가져오기  (OrderedProductHistoryEntity)
    private static final String Payment_SELECT_ORDEREDPRODUCTHISTORY =
            "SELECT A.user_id, A.user_point,\n" +
                    "       B.order_id, B. order_date\n" +
                    "       C.product_name, C.product_price,\n" +
                    "       D.company_name, D.company_tel,\n" +
                    "FROM\n" +
                    "(\n" +
                    "    (SELECT user_serial_num, user_id, user_point) A\n" +
                    "    FULL OUTER JOIN\n" +
                    "    (SELECT user_serial_num, order_product_id, order_company_id,\n" +
                    "    order_payment_id, order_id, order_date) B on A.user_serial_num = B.user_serial_num\n" +
                    "    FULL OUTER JOIN\n" +
                    "    (SELECT product_id, product_name, product_price) C on B.order_product_id = C.product_id\n" +
                    "    FULL OUTER JOIN\n" +
                    "    (SELECT company_id, company_name, company_tel) D on B.company_id = D.company_id)\n" +
                    ")\n" +
                    "WHERE user_id = ?\n" +
                    "ORDER BY order_date DESC";
    //해당 기간사이 결제정보 가져오기


    public OrderedProductHistoryDAO(){}
    public static OrderedProductHistoryDAO getInstance(){
        if (orderedProductHistoryDAO ==null){
            orderedProductHistoryDAO =new OrderedProductHistoryDAO();
        }
        return orderedProductHistoryDAO;
    }

    public List<OrderedProductHistoryEntity> getOrderedProductHistoryEntityWithUserId(String userId){
        List<OrderedProductHistoryEntity> OrderedProductHistoryEntities = new ArrayList<>();

        try{
            conn= JDBCMgr.getConnection();
            stmt=conn.prepareStatement(Payment_SELECT_ORDEREDPRODUCTHISTORY);
            stmt.setString(1, userId);
            rs=stmt.executeQuery();

            if (rs.next()){
                /*User_info*/
//                String userId="user_id";
                int userPoint = rs.getInt("user_point");

                /*Product*/
                String productName = rs.getString("product_name");
                Long productPrice = rs.getLong("product_price");

                /*Company*/
                String companyName = rs.getString("company_name");
                String company_tel = rs.getString("company_tel");

                /*Order_info*/
                Long orderId = rs.getLong("order_id");
                Date orderDate = rs.getDate("order_date");
                OrderedProductHistoryEntity theEntity = new OrderedProductHistoryEntity(
                                                            userId, userPoint, productName,productPrice,
                                                            companyName,company_tel,orderId,orderDate);
                OrderedProductHistoryEntities.add(theEntity);
                return OrderedProductHistoryEntities;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JDBCMgr.close(stmt,conn);
        }
        return null;
    }
}
