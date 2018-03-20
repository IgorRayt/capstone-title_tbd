package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class JobHours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;
    private String description;
    private Integer hours;
    private Integer overTime;
    private Integer doubleTime;

    @JsonIgnore
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Job job;

    @JsonIgnore
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public Integer getDoubleTime() {
        return doubleTime;
    }

    public void setDoubleTime(Integer doubleTime) {
        this.doubleTime = doubleTime;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
