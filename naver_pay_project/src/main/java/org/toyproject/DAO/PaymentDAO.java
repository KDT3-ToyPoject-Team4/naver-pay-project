package org.toyproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.toyproject.DB.*;
import org.toyproject.DTO.PaymentDTO;
import org.toyproject.DTO.DetailedPaymentDTO;

public class PaymentDAO {

    private static PaymentDAO paymentDAO = null;
    private Connection conn=null;
    private PreparedStatement stmt=null;
    private ResultSet rs=null;


    //전체 결제정보 가져오기
    private static final String Payment_SELECT_ALL = "select * from Payments where userSerialNumber = ?";
    //해당 기간사이 결제정보 가져오기
    private static final String Payment_SEARCH_BETWEEN_DATES = "select * from Payments where userSerialNumber = ? && paymentDate >= ? && paymentDate <= ?";
    //결제정보 저장하기
    private static final String Payment_INSERT = "insert into Payments values(?,?,?,?,?,?,?,?,?,?,?)";
    //결제정보 지우기
    private static final String Payment_Delete = "delete Payments where paymentId = ?";
    private static final String DetailedPayment_SELECT = "select * from Payments where PAYMENT_ID = ?";

    PaymentDAO(){}

    public static PaymentDAO getInstance(){
        if (paymentDAO==null){
            paymentDAO=new PaymentDAO();
        }
        return paymentDAO;
    }


    public DetailedPaymentDTO DetailedPayment(Long paymentId){
        DetailedPaymentDTO newDetailedPaymentDTO = new DetailedPaymentDTO();
        try{
            conn=JDBCPaymentsMgr.getConnection();
            stmt=conn.prepareStatement(DetailedPayment_SELECT);
            stmt.setLong(1, paymentId);

            rs= stmt.executeQuery();

            if(rs.next()){
//                Long paymentId = rs.getLong("PAYMENT_ID"); //매개변수로 이미 있음.
                String productName = rs.getString("PRODUCT_NAME");
                int productPrice = rs.getInt("PRODUCT_PRICE");
                int productAmount = rs.getInt("PRODUCT_AMOUNT");
                String paymentMethod = rs.getString("PAYMENT_METHOD");
                Date paymentDate = rs.getDate("PAYMENT_DATE");
                String sellerName = rs.getString("SELLER_NAME");
                String seller_phone = rs.getString("SELLER_PHONE");
                Long userSerialNumber = rs.getLong("USER_SERIAL_NUMBER");
                int collectedPoints = rs.getInt("COLLECTED_POINTS");
                String URL = rs.getString("URL");
                newDetailedPaymentDTO = new DetailedPaymentDTO(paymentId, productName, productPrice, productAmount,
                        paymentMethod,paymentDate,sellerName,seller_phone,collectedPoints,URL);
            }

        } catch (SQLException e){
        e.printStackTrace();
    } finally {
        JDBCPaymentsMgr.close(stmt,conn);
    }
        return newDetailedPaymentDTO;
    }
    //모든 구매정보 조회
    public List<PaymentDTO> selectAll(){
        List<PaymentDTO> PaymentList = new LinkedList<>();
        try{
            conn=JDBCPaymentsMgr.getConnection();
            stmt=conn.prepareStatement(Payment_SELECT_ALL);

            rs= stmt.executeQuery();
            while (rs.next()){
                Long paymentId = rs.getLong("PAYMENT_ID");
                String productName = rs.getString("PRODUCT_NAME");
                int productPrice = rs.getInt("PRODUCT_PRICE");
                int productAmount = rs.getInt("PRODUCT_AMOUNT");
                String paymentMethod = rs.getString("PAYMENT_METHOD");
                Date paymentDate = rs.getDate("PAYMENT_DATE");
                String sellerName = rs.getString("SELLER_NAME");
                String seller_phone = rs.getString("SELLER_PHONE");
//                Long userSerialNumber = rs.getLong("USER_SERIAL_NUMBER");
                int collectedPoints = rs.getInt("COLLECTED_POINTS");
                String URL = rs.getString("URL");

                PaymentDTO newDetailedPaymentDTO = new PaymentDTO(paymentId,productName,productPrice,
                        productAmount,paymentMethod,paymentDate,sellerName,seller_phone,collectedPoints,URL);
                PaymentList.add(newDetailedPaymentDTO);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JDBCPaymentsMgr.close(stmt,conn);
        }
        return PaymentList;
    }

}
