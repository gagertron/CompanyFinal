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
public abstract class Employee implements PayCalculator {

    private double hours; //The amount of hours worked, a double since employees wont work exact hours sometimes
    private double wage; //The wage of an employee
    //private String fName; // First name
    //private String lName; // Last name 

    //public Employee(){ //default constructor
    //    this.hours = 0;
    //    this.wage = 7.25;
    //}

    //public Employee(int hours, int wage){
    //    this.hours = hours;
    //    this.wage = wage;
    //}

    //getter and setter methods for all employee variables
    public double getHours() {
        return hours;
    }

    public double getWage() {
        return wage;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    //SetWage(wage) method will cause an exception if employee wage is set below legal limits - UNIMPLEMENTED
    //minimum tipped employee wage - 2.13$
    //standard minimum wage - 7.25$
    public void setWage(double wage) {
        this.wage = wage;
    }

    
    // public abstract double getMoney(); //All subclasses will have their own version of calculating pay
}
