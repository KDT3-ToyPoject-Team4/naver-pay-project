package org.toyproject.Entity;

import java.util.Date;

public class OrderedProductHistoryEntity {

    /*User_info*/
    private String userId;
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



    public OrderedProductHistoryEntity(){}

    /*-------------------------Constructor-------------------------*/
    public OrderedProductHistoryEntity(String userId, int userPoint, String productName, Long productPrice, String companyName, String company_tel, Long orderId, Date orderDate) {
        this.userId = userId;
        this.userPoint = userPoint;
        this.productName = productName;
        this.productPrice = productPrice;
        this.companyName = companyName;
        this.company_tel = company_tel;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    /*-------------------------Getter-------------------------*/
    public String getUserId() {
        return userId;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public String getProductName() {
        return productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompany_tel() {
        return company_tel;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
