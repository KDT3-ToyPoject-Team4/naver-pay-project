package org.toyproject.Entity;

import java.util.Date;

public class WebCrawlingShoppingListEntity {
    //User
    private String userId;
    private String userPw;
    private String userName;
    private String userTel;
    private String userAddress;
    private String userPoint;
    //Company
    private String companyName;
    private String comPanyTel;
    private String companyStore;
    private long businessNumber;
    //Product
    private String productName;
    private long productPrice;
    private int supplyPoint;
    //Payment
    private String paymentMethod;
    //OrderInfo
    private String orderId;
    private Date orderDate;
    private int orderQuantity;
    private int usedPoint;
    private long orderMoney;
    private long orderTotalMoney;

    public WebCrawlingShoppingListEntity(){}

    public WebCrawlingShoppingListEntity(String userId, String userPw, String userName, String userTel, String userAddress, String userPoint, String companyName, String comPanyTel, String companyStore, long businessNumber, String productName, long productPrice, int supplyPoint, String paymentMethod, String orderId, Date orderDate, int orderQuantity, int usedPoint, long orderMoney, long orderTotalMoney) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userTel = userTel;
        this.userAddress = userAddress;
        this.userPoint = userPoint;
        this.companyName = companyName;
        this.comPanyTel = comPanyTel;
        this.companyStore = companyStore;
        this.businessNumber = businessNumber;
        this.productName = productName;
        this.productPrice = productPrice;
        this.supplyPoint = supplyPoint;
        this.paymentMethod = paymentMethod;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
        this.usedPoint = usedPoint;
        this.orderMoney = orderMoney;
        this.orderTotalMoney = orderTotalMoney;

        System.out.println("WebCrawlingShoppingListEntity{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPoint='" + userPoint + '\'' +
                ", companyName='" + companyName + '\'' +
                ", comPanyTel='" + comPanyTel + '\'' +
                ", companyStore='" + companyStore + '\'' +
                ", businessNumber=" + businessNumber +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", supplyPoint=" + supplyPoint +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", orderQuantity=" + orderQuantity +
                ", usedPoint=" + usedPoint +
                ", orderMoney=" + orderMoney +
                ", orderTotalMoney=" + orderTotalMoney +
                '}');

    }

    @Override
    public String toString() {
        return "WebCrawlingShoppingListEntity{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPoint='" + userPoint + '\'' +
                ", companyName='" + companyName + '\'' +
                ", comPanyTel='" + comPanyTel + '\'' +
                ", companyStore='" + companyStore + '\'' +
                ", businessNumber=" + businessNumber +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", supplyPoint=" + supplyPoint +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", orderQuantity=" + orderQuantity +
                ", usedPoint=" + usedPoint +
                ", orderMoney=" + orderMoney +
                ", orderTotalMoney=" + orderTotalMoney +
                '}';
    }
}
