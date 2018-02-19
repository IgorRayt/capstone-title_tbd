package hello.model;

import javax.persistence.*;
import java.util.*;
import java.sql.Date;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateOpened;
    private Date dateClosed;
    private String description;
    private Boolean available;
    private Long customerID;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<EmployeeAssignment> employeeAssignments = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Set<EmployeeAssignment> getEmployeeAssignments() {
        return employeeAssignments;
    }

    public void setEmployeeAssignments(Set<EmployeeAssignment> employeeAssignments) {
        this.employeeAssignments = employeeAssignments;
    }

    public Job merge(Job jobToMerge) {
        jobToMerge.setId(this.getId());
        return jobToMerge;
    }
}
