package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name ="agents")
public class Agents
        //define how the table/entity will work
{
        //base columns that will go into the table

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //generateValue replaces maxId
    //PRIMARY KEY
    private long agentcode;
    //make sure your name is unique
    //annotation to enforce in the
    //table database
    @Column(unique = true,
            nullable = false)
    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    //connect list with the next line
    @OneToMany(mappedBy = "agent",
              cascade = CascadeType.ALL,
              orphanRemoval = true)
    //cascade ties together the agent and restaurant
    //orphan removal will remove a agent

    @JsonIgnoreProperties("agent")
    private List<Customers> customers = new ArrayList();

    //default constructor
    public Agents()
    {
        //KEEP empty
    }

    //main constructor


    public Agents(String agentname, String workingarea, double commission, String phone, String country)
    {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    public long getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(long agentcode)
    {
        this.agentcode = agentcode;
    }

    public String getName()
    {
        return agentname;
    }

    public void setName(String name)
    {
        this.agentname = name;
    }

    public String getWorkingArea()
    {
        return workingarea;
    }

    public void setWorkingArea(String workingArea)
    {
        this.workingarea = workingArea;
    }

    public double getCommission()
    {
        return commission;
    }

    public void setCommission(double commission)
    {
        this.commission = commission;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}
