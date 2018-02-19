package hello.model;

import javax.persistence.*;
import java.util.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    private EmergencyContact emergencyContact;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<EmployeeAssignment> employeeAssignments = new HashSet<>();

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

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public Set<EmployeeAssignment> getEmployeeAssignments() {
        return employeeAssignments;
    }

    public void setEmployeeAssignments(Set<EmployeeAssignment> employeeAssignments) {
        this.employeeAssignments = employeeAssignments;
    }

    public Employee merge(Employee employeeToMerge) {
        employeeToMerge.setId(this.getId());
        return employeeToMerge;
    }
}
