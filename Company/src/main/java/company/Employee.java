/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

/**
 *
 * @author laste
 */
//The Employee Class encapsulate all workers within a restaurant
public abstract class Employee implements BreakTime {

    private double hours; //The amount of hours worked, a double since employees wont work exact hours sometimes
    //private double wage; //The wage of an employee
    private String fName; // First name
    private String lName; // Last name
    private int id; // Employee ID
    private double breakTime;  // Total time spent on break. This time will be dudcted from total hours worked in week.

    //public Employee(){ //default constructor
    //    this.hours = 0;
    //    this.wage = 7.25;
    //}

    public Employee(String fName, String lName, int id, double hours){
        this.fName = fName;
        this.lName = lName;
        this.id = id;
        this.hours = hours;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getId() {
        return id;
    }

    //getter and setter methods for all employee variables
    public double getHours() {
        return hours;
    }

    //public double getWage() {
    //    return wage;
    //}

    public void setHours(double hours) {
        this.hours = hours;
    }
    //SetWage(wage) method will cause an exception if employee wage is set below legal limits - UNIMPLEMENTED
    //minimum tipped employee wage - 2.13$
    //standard minimum wage - 7.25$
    //public void setWage(double wage) {
    //    this.wage = wage;
    //}
    
    // Keeps a running total of all breaks spent in a week.
    // It should reset each week, but I don't plan for our simulation to run longer than 1 week.
    // So there is no need to reset the breakTime, just simply calcualte it. 
    public void setBreakTime(double breakTime)
    {
        this.breakTime += breakTime;
    }
    
    // Returns the total hours an employee has spent on break in a week
    public double getBreakTime()
    {
        return this.breakTime;
    }
    
     public abstract double calculatePay(); //All subclasses will have their own version of calculating pay
}
