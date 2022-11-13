package org.toyproject.DAO;

import org.toyproject.DB.ConnectionPoolMgr;

import org.toyproject.entity.OrderedProductHistoryEntity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderedProductHistoryDAO {

    private static OrderedProductHistoryDAO orderedProductHistoryDAO = null;
    private ConnectionPoolMgr connectionPoolMgr;
    private Connection conn=null;
    private PreparedStatement stmt=null;
    private ResultSet rs=null;

    //해당 과거제품주문 목록 가져오기  (OrderedProductHistoryEntity)
    private static final String Payment_SELECT_ORDEREDPRODUCTHISTORY = "select U.user_name, U.user_id, U.user_point, O.order_id, O.order_date, P.product_name, P.product_price,\n" +
            "       C.company_name, C.company_tel\n" +
            "    from user_info U, payment Pay, order_info O, product P, company C\n" +
            "    where U.user_serial_num = O.user_serial_num and O.order_product_id = P.product_id and\n" +
            "          P.company_id = C.company_id and O.order_payment_id = Pay.payment_id and\n" +
            "          U.user_serial_num = Pay.user_serial_num and U.user_id = ?";
    /*private static final String Payment_SELECT_ORDEREDPRODUCTHISTORY =
            "SELECT A.user_id,\n" +
                    "       A.user_point,\n" +
                    "       C.order_id,\n" +
                    "       C.order_date,\n" +
                    "       D.product_name,\n" +
                    "       D.product_price,\n" +
                    "       E.company_name,\n" +
                    "       E.company_tel\n" +
                    "FROM USER_INFO A\n" +
                    "        LEFT OUTER JOIN\n" +
                    "    PAYMENT B on A.user_serial_num = B.user_serial_num\n" +
                    "        LEFT OUTER JOIN\n" +
                    "     order_info C on B.payment_id = C.order_payment_id\n" +
                    "        LEFT OUTER JOIN\n" +
                    "     Product D on C.order_product_id = D.product_id\n" +
                    "        LEFT OUTER JOIN\n" +
                    "     Company E on E.company_id = D.company_id\n" +
                    "\n" +
                    "WHERE user_id = ? ORDER BY order_date DESC;";*/



    //해당 기간사이 결제정보 가져오기
    public OrderedProductHistoryDAO(){
        if (connectionPoolMgr == null) {
            connectionPoolMgr = ConnectionPoolMgr.getInstance();
        }
    }
    public static OrderedProductHistoryDAO getInstance(){
        if (orderedProductHistoryDAO ==null){
            orderedProductHistoryDAO =new OrderedProductHistoryDAO();
        }
        return orderedProductHistoryDAO;
    }

    public List<OrderedProductHistoryEntity> getOrderedProductHistoryEntityWithUserId(String userId){
        List<OrderedProductHistoryEntity> OrderedProductHistoryEntities = new ArrayList<>();
        try{
            conn = connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(Payment_SELECT_ORDEREDPRODUCTHISTORY);
            stmt.setString(1, userId);
            rs = stmt.executeQuery();
            while (rs.next()){
                /*User_info*/
//                String userId="user_id";
                int userPoint = rs.getInt("user_point");
                String userName = rs.getString("user_name");

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
                        userId,userName, userPoint, productName,productPrice, companyName,company_tel, orderId, orderDate
                );
                OrderedProductHistoryEntities.add(theEntity);
            }
            return OrderedProductHistoryEntities;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            connectionPoolMgr.freeConnection(conn, stmt, rs);
        }
        return null;
    }
}
