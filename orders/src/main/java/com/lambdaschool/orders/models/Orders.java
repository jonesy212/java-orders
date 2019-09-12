package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders
{
    //define how the table/entity will work

    //base columns that will go into the table

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //GeneratedValue replaces maxId

    //PRIMARY KEY
    private long ordnum;

    //make sure your name is unique
    //an annotation to enforce in the
    //table database
    private double ordamount;
    private double advanceamount;
    private String orddescriptions;

    @OneToMany
    @JoinColumn(name = "custcode",
                nullable = false)
    @JsonIgnoreProperties("orders")
    private Customers customer;

    //cascade ties together the customer and order
    //orphan removal will remove a customer item
    //that is not assigned to a order
    //it will be removed
    //it is mapped by order

//generate constructors
    //DO NOT bring in the LIST
    //we will deal with that later

//default constructor
    public Orders()
    {

    }

    public Orders(double ordamount, double advanceamount, String orddescriptions)
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orddescriptions = orddescriptions;
    }

    public long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount()
    {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    public String getOrddescriptions()
    {
        return orddescriptions;
    }

    public void setOrddescriptions(String orddescriptions)
    {
        this.orddescriptions = orddescriptions;
    }

    public Customers getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customers customer)
    {
        this.customer = customer;
    }
}