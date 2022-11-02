package org.toyproject.DTO;

import java.util.Date;

public class DetailedPaymentDTO {
    private Long paymentId;
    private String productName;
    private int productPrice;
    private int productAmount;
    private String paymentMethod;
    private Date paymentDate;
    private String sellerName;
    private String seller_phone;
//    private Long userSerialNumber;
    private int collectedPoints;
    private String URL;

    public DetailedPaymentDTO(){}
    public DetailedPaymentDTO(Long paymentId, String productName, int productPrice, int productAmount, String paymentMethod, Date paymentDate, String sellerName, String seller_phone, int collectedPoints, String URL){
//    public PaymentDTO(Long paymentId, String productName, int productPrice, int productAmount, String paymentMethod, Date paymentDate, String sellerName, String seller_phone, Long userSerialNumber, int collectedPoints, String URL){
        this.paymentId=paymentId;
        this.productName=productName;
        this.productPrice=productPrice;
        this.productAmount=productAmount;
        this.paymentMethod=paymentMethod;
        this.paymentDate=paymentDate;
        this.sellerName=sellerName;
        this.seller_phone=seller_phone;
//        this.userSerialNumber=userSerialNumber;
        this.collectedPoints=collectedPoints;
        this.URL=URL;
    }



    public Long getPaymentId() {return paymentId;}
    public void setPaymentId(Long paymentId) {this.paymentId = paymentId;}
    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}
    public int getProductPrice() {return productPrice;}
    public void setProductPrice(int productPrice) {this.productPrice = productPrice;}
    public int getProductAmount() {return productAmount;}
    public void setProductAmount(int productAmount) {this.productAmount = productAmount;}
    public String getPaymentMethod() {return paymentMethod;}
    public void setPaymentMethod(String paymentMethod) {this.paymentMethod = paymentMethod;}
    public Date getPaymentDate() {return paymentDate;}
    public void setPaymentDate(Date paymentDate) {this.paymentDate = paymentDate;}
    public String getSellerName() {return sellerName;}
    public void setSellerName(String sellerName) {this.sellerName = sellerName;}
    public String getSeller_phone() {return seller_phone;}
    public void setSeller_phone(String seller_phone) {this.seller_phone = seller_phone;}
//    public Long getUserSerialNumber() {return userSerialNumber;}
//    public void setUserSerialNumber(Long userSerialNumber) {this.userSerialNumber = userSerialNumber;}
    public int getCollectedPoints() {return collectedPoints;}
    public void setCollectedPoints(int collectedPoints) {this.collectedPoints = collectedPoints;}
    public String getURL() {return URL;}
    public void setURL(String URL) {this.URL = URL;}

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentId=" + paymentId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productAmount=" + productAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", sellerName='" + sellerName + '\'' +
                ", seller_phone='" + seller_phone + '\'' +
//                ", userSerialNumber=" + userSerialNumber +
                ", collectedPoints=" + collectedPoints +
                ", URL='" + URL + '\'' +
                '}';
    }
}
