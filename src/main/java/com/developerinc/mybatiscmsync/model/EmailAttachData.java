// EmailAttachData.java
package com.developerinc.mybatiscmsync.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "email_attach_data")
public class EmailAttachData implements Serializable {

    @Id
    private Long id;

    @Column(name = "activedate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MMM-yy")
    private Date activeDate;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String cellphone;
    private String homephone;
    private String homeptkit;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getHomeptkit() {
        return homeptkit;
    }

    public void setHomeptkit(String homeptkit) {
        this.homeptkit = homeptkit;
    }

    @Override
    public String toString() {
        return "EmailAttachData{" +
                "id=" + id +
                ", activeDate='" + activeDate + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", homephone='" + homephone + '\'' +
                ", homeptkit='" + homeptkit + '\'' +
                '}';
    }
}