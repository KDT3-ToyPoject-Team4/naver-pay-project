package org.toyproject.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB에 임시 데이터 삽입하기
 */
public class InsertData {
    private ConnectionPoolMgr connectionPoolMgr;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public static void main(String[] args) {

    }

    /*public void inserUserData(){
        int result = 0;
        try{
            conn = connectionPoolMgr.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO user_info (user_id,user_pw,user_name,user_ph,user_addr) VALUES (?,?,?,?,?)");
            for(int i=0; i<10; i++){
                pstmt.setString(1,"testID"+i);
                pstmt.setString(2,"password"+i);
                pstmt.setString(3,"tester"+i);
                pstmt.setString(4,();
                pstmt.setString(5,);
            }
            result = pstmt.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn,pstmt);
        }
    }*/

    public void insertProductData() {
        try{
            conn = connectionPoolMgr.getConnection();
            String query = "INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_AMOUNT,COMPANY_ID,SUPPLY_POINT) VALUES(?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            for (int i=0; i<50; i++){
                pstmt.setString(1,"product_"+i);
                int price = (int) (Math.random() * 100000);
                pstmt.setString(2,String.valueOf(price));
                int amount = (int) (Math.random() * 100);
                pstmt.setString(3,String.valueOf(amount));
                int companyID = (int) (Math.random() * 10) + 1;
                pstmt.setString(4,String.valueOf(companyID));
                int supplyPoint = (int) (Math.random() * 1000);
                pstmt.setString(5,String.valueOf(supplyPoint));
                pstmt.addBatch();
                pstmt.clearParameters();
            }
            pstmt.executeBatch();
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn,pstmt);
        }

    }

    public void insertPaymentData(){
        try{
            String[] paymentMethod = {"카드 간편 결제","계좌 이체","무통장 입금","휴대폰 결제","문화상품권"};
            conn = connectionPoolMgr.getConnection();
            String query = "INSERT INTO PAYMENT (PAYMENT_METHOD,USER_SERIAL_NUM) VALUES(?,?)";
            pstmt = conn.prepareStatement(query);
            for (int i=0; i<20; i++){
                pstmt.setString(1,paymentMethod[i]);
                int usedPoint = (int) (Math.random() * 100)+1;
                pstmt.setString(2,String.valueOf(usedPoint));
                pstmt.addBatch();
                pstmt.clearParameters();
            }
            pstmt.executeBatch();
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn,pstmt);
        }
    }

    public void insertOrderData(){
        try{
            conn = connectionPoolMgr.getConnection();
            String query = "INSERT INTO order_info (order_product_id,order_payment_id,user_serial_num,order_date,used_point,order_money,order_quantitiy)" +
                    "values (?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);


        }catch (SQLException e){

        }catch (Exception e){

        }finally {
            connectionPoolMgr.freeConnection(conn,pstmt);
        }
    }
}
