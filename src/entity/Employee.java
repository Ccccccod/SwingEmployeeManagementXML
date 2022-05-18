/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author MR TU
 */
public class Employee {
    private String id;
    private String name;
    private String dob;
    private String address;
    private String email;
    private String phone;
    private String placeOfWork;

    public Employee() {
    }

    public Employee(String id, String name, String dob, String address, String email, String phone, String placeOfWork) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.placeOfWork = placeOfWork;
    }

    @XmlAttribute(name = "employee_no")
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "dob")
    public void setDob(String dob) {
        this.dob = dob;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement(name = "phone_no")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlElement(name = "place_of_work")
    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", email=" + email + ", phone=" + phone + ", placeOfWork=" + placeOfWork + '}';
    }
    
}
