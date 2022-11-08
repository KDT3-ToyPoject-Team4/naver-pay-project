package org.toyproject.DTO;

public class ProductDTO {
    private Long productId;
    private String productName;
    private Long productPrice;
    private int productAmount;
    private int supplyPoint;
    private Long companyId;

    public ProductDTO(String productName, Long productPrice, int productAmount, int supplyPoint, Long companyId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.supplyPoint = supplyPoint;
        this.companyId = companyId;
    }

    public Long getProductId() {
        return productId;
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

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public int getSupplyPoint() {
        return supplyPoint;
    }

    public void setSupplyPoint(int supplyPoint) {
        this.supplyPoint = supplyPoint;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
