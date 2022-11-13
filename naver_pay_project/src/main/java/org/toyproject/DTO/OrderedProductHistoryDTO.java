package org.toyproject.DTO;

import java.util.Date;

public class OrderedProductHistoryDTO {

    /*User_info*/
    private String userId;
    private String userName;
    private int userPoint;

    /*Product*/
    private String productName;
    private Long productPrice;

    /*Company*/
    private String companyName;
    private String company_tel;

    /*Order_info*/
    private Long orderId;
    private Date orderDate;



    public OrderedProductHistoryDTO(){}

    /*-------------------------Constructor-------------------------*/
    public OrderedProductHistoryDTO(String userId, String userName, int userPoint, String productName, Long productPrice, String companyName, String company_tel, Long orderId, Date orderDate) {
        this.userId = userId;
        this.userName = userName;
        this.userPoint = userPoint;
        this.productName = productName;
        this.productPrice = productPrice;
        this.companyName = companyName;
        this.company_tel = company_tel;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    /*-------------------------Getter and Setter-------------------------*/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompany_tel() {
        return company_tel;
    }

    public void setCompany_tel(String company_tel) {
        this.company_tel = company_tel;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
