package hello.model;

import javax.persistence.Entity;

@Entity
public class Customer extends Person {
    private String cellPhoneNumber;
    private String workPhoneNumber;
    private String companyName;

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Customer merge(Customer customerToMerge) {
        customerToMerge.setId(this.getId());
        return customerToMerge;
    }
}
