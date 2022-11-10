package org.toyproject.DTO;

public class ShoppingDetailDTO {
    private Long orderId;
    private String orderDate;
    private int usedPoint;
    private int orderMoney;
    private String userName;
    private String userTel;
    private String userAddr;
    private String companyName;
    private String companyTel;
    private String companyStore;
    private String paymentMethod;
    private int productPrice;
    private int supplyPoint;

    public ShoppingDetailDTO(Long orderId, String orderDate, int usedPoint, int orderMoney, String userName, String userTel, String userAddr,
                             String companyName, String companyTel, String companyStore, String paymentMethod, int productPrice, int supplyPoint) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.usedPoint = usedPoint;
        this.orderMoney = orderMoney;
        this.userName = userName;
        this.userTel = userTel;
        this.userAddr = userAddr;
        this.companyName = companyName;
        this.companyTel = companyTel;
        this.companyStore = companyStore;
        this.paymentMethod = paymentMethod;
        this.productPrice = productPrice;
        this.supplyPoint = supplyPoint;
    }

    public ShoppingDetailDTO(Long orderId, String orderDate, int usedPoint, int orderMoney,
                             String userName, String userTel, String userAddr, String companyName,
                             String companyTel, String companyStore, String paymentMethod) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.usedPoint = usedPoint;
        this.orderMoney = orderMoney;
        this.userName = userName;
        this.userTel = userTel;
        this.userAddr = userAddr;
        this.companyName = companyName;
        this.companyTel = companyTel;
        this.companyStore = companyStore;
        this.paymentMethod = paymentMethod;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getUsedPoint() {
        return usedPoint;
    }

    public void setUsedPoint(int usedPoint) {
        this.usedPoint = usedPoint;
    }

    public int getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(int orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getCompanyStore() {
        return companyStore;
    }

    public void setCompanyStore(String companyStore) {
        this.companyStore = companyStore;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "ShoppingDetailDTO{" +
                "orderId=" + orderId +
                ", orderDate='" + orderDate + '\'' +
                ", usedPoint=" + usedPoint +
                ", orderMoney=" + orderMoney +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyTel='" + companyTel + '\'' +
                ", companyStore='" + companyStore + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", productPrice=" + productPrice +
                ", supplyPoint=" + supplyPoint +
                '}';
    }
}
