package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name ="customers")

//entity creates
//database structure
//hibernation
// will help translate the database
//from backend to the java objects

public class Customers
    //define how the table/entity will work

{
    //base columns that will go into the table

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //replaces maxId

    //Primary Key
    private long custcode;
    //make sure your name is unique
    //an annotation to enforce in the
    //table database

    @Column(unique = true,
            nullable = false)
    private String custname;
    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double receiveamt;
    private double paymentamt;
    private String phone;

    //one toMany relationship
    //customers to orders

    //ASK WHY THIS PART WILL NOT CORRECT ITSELF
//    @OneToMany(mappedBy = "customer"),
//    cascade = CascadeType.All,
//    orphanRemoval = true)

    @OneToMany(mappedBy = "customer",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    //cascade ties together the orders and customers
    //orphan removal will remove an order item
    //that is not assigned to a customer
    //it is mapped by customer

    @JsonIgnoreProperties("customer")
    private List<Orders> orders = new ArrayList<>();

//generate constructor
    //DO NOT bring in the LIST
    //deal with that later


    public Customers()
    {
        //create default constructor
    }

    public Customers(String custname, String custcity, String workingarea, String custcountry, String grade, double openingamt, double receiveamt, double paymentamt, String phone)
    {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.paymentamt = paymentamt;
        this.phone = phone;
    }
    //create getters and setters


    public long getCustcode()
    {
        return custcode;
    }

    public void setCustcode(long custcode)
    {
        this.custcode = custcode;
    }

    public String getCustname()
    {
        return custname;
    }

    public void setCustname(String custname)
    {
        this.custname = custname;
    }

    public String getCustcity()
    {
        return custcity;
    }

    public void setCustcity(String custcity)
    {
        this.custcity = custcity;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public String getCustcountry()
    {
        return custcountry;
    }

    public void setCustcountry(String custcountry)
    {
        this.custcountry = custcountry;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public double getOpeningamt()
    {
        return openingamt;
    }

    public void setOpeningamt(double openingamt)
    {
        this.openingamt = openingamt;
    }

    public double getReceiveamt()
    {
        return receiveamt;
    }

    public void setReceiveamt(double receiveamt)
    {
        this.receiveamt = receiveamt;
    }

    public double getPaymentamt()
    {
        return paymentamt;
    }

    public void setPaymentamt(double paymentamt)
    {
        this.paymentamt = paymentamt;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public List<Orders> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Orders> orders)
    {
        this.orders = orders;
    }
}
