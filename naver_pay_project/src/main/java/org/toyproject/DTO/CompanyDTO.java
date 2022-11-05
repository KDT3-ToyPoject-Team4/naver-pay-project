package org.toyproject.DTO;

public class CompanyDTO {
    private Long companyID;
    private String companyName;
    private String companyTel;
    private String companyStore;
    private int businessNumber;

    public CompanyDTO(String companyName, String companyTel, String companyStore, int businessNumber) {
        this.companyName = companyName;
        this.companyTel = companyTel;
        this.companyStore = companyStore;
        this.businessNumber = businessNumber;
    }

    public Long getCompanyID() {
        return companyID;
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

    public int getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(int businessNumber) {
        this.businessNumber = businessNumber;
    }
}
