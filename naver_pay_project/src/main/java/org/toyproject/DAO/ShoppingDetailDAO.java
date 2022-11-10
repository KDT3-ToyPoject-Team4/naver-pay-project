package org.toyproject.DAO;

import org.toyproject.DB.ConnectionPoolMgr;
import org.toyproject.DTO.ShoppingDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingDetailDAO {
    private static ShoppingDetailDAO shoppingDetailDAO = null;
    private ConnectionPoolMgr connectionPoolMgr;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    public ShoppingDetailDAO(){
        if(connectionPoolMgr == null){
            connectionPoolMgr = ConnectionPoolMgr.getInstance();
        }
    }

    public static ShoppingDetailDAO getInstance() {
        if (shoppingDetailDAO == null) {
            shoppingDetailDAO = new ShoppingDetailDAO();
        }
        return shoppingDetailDAO;
    }
    public static final String SHOPPING_SELECT_ALL = "SELECT U.user_name, U.user_ph, U.user_addr, O.order_id, O.order_date, O.used_point, O.order_money, " +
            "P.product_name, P.product_price, P.supply_point, C.company_name, C.company_tel, C.company_store, Pay.payment_method "+
            "FROM order_info O, user_info U, product P, company C, payment Pay "+
            "WHERE O.user_serial_num = U.user_serial_num and Pay.user_serial_num = U.user_serial_num and "+
            "O.order_product_id = P.product_id and P.company_id = C.company_id and "+
            "O.order_payment_id = Pay.payment_id and O.order_id = ? ";

    public ShoppingDetailDTO showShoppingDetail(Long orderId){
        ShoppingDetailDTO detailDTO = null;
        try{
            conn = connectionPoolMgr.getConnection();
            pstmt = conn.prepareStatement(SHOPPING_SELECT_ALL);
            pstmt.setLong(1, orderId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String uName = rs.getString("USER_NAME");
                String uPhoneNumber = rs.getString("USER_PH");
                String uAddress = rs.getString("USER_ADDR");
                int uPoint = rs.getInt("USED_POINT");
                Long oId = rs.getLong("ORDER_ID");
                String orderDate = rs.getString("ORDER_DATE");
                int orderMoney = rs.getInt("ORDER_MONEY");
                String productPrice = rs.getString("PRODUCT_PRICE");
                String supplyPoint = rs.getString("SUPPLY_POINT");
                String paymentMethod = rs.getString("payment_method");
                String companyName = rs.getString("COMPANY_NAME");
                String companyTel = rs.getString("COMPANY_TEL");
                String companyStore = rs.getString("COMPANY_STORE");
                detailDTO = new ShoppingDetailDTO(oId,orderDate,uPoint,orderMoney,
                        uName,uPhoneNumber,uAddress,companyName,companyTel,companyStore,paymentMethod);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            connectionPoolMgr.freeConnection(conn,pstmt);
        }
        return detailDTO;
    }

}
