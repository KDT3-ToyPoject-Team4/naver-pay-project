package org.toyproject.DTO;

public class OrderInfoDTO {
    private Long orderId;
    private Long orderProductId;
    private Long orderCompanyId;
    private Long userSerialNum;
    private Long orderPayment;
    private String orderDate;

    public OrderInfoDTO(Long orderId, Long orderProductId, Long orderCompanyId, Long userSerialNum, Long orderPayment) {
        this.orderId = orderId;
        this.orderProductId = orderProductId;
        this.orderCompanyId = orderCompanyId;
        this.userSerialNum = userSerialNum;
        this.orderPayment = orderPayment;
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Long getOrderCompanyId() {
        return orderCompanyId;
    }

    public void setOrderCompanyId(Long orderCompanyId) {
        this.orderCompanyId = orderCompanyId;
    }

    public Long getUserSerialNum() {
        return userSerialNum;
    }

    public void setUserSerialNum(Long userSerialNum) {
        this.userSerialNum = userSerialNum;
    }

    public Long getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(Long orderPayment) {
        this.orderPayment = orderPayment;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
