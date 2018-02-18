package hello.model;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Employee extends Person {
    private Date birthDate;
    private String address;
    private String city;
    private String socialInsuranceNumber;
    private Date payrollStartDate;
    private String phoneNumber;
    private String postalCode;
    private Long employmentID;
    private Long emergencyContactID;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber) {
        this.socialInsuranceNumber = socialInsuranceNumber;
    }

    public Date getPayrollStartDate() {
        return payrollStartDate;
    }

    public void setPayrollStartDate(Date payrollStartDate) {
        this.payrollStartDate = payrollStartDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getEmploymentID() {
        return employmentID;
    }

    public void setEmploymentID(Long employmentID) {
        this.employmentID = employmentID;
    }

    public Long getEmergencyContactID() {
        return emergencyContactID;
    }

    public void setEmergencyContactID(Long emergencyContactID) {
        this.emergencyContactID = emergencyContactID;
    }
}
