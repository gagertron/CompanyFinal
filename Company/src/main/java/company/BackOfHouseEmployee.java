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
//The Back Of House Employee (BOH) class consists of employees who do not receive tips: Chefs and Busboys
        
// add tip cannot be negative
// input must be a number         


        
public abstract class BackOfHouseEmployee extends Employee {
    //VARIABLE - UNIMPLEMENTED
    private String membership;  // the rank of employee which determines pay grade
    private double wage;
    //MUST throw an exception if:
    //Wages are set lower than 7.25$ - UNIMPLEMENTED

    public BackOfHouseEmployee(String fName, String lName, int id, double hours, String membership){
        super(fName, lName, id, hours); // Passes this data to the super class's constructor (Employee).
        setMembership(membership);  // Set the membership level. Can only be 1 of 3 choices. 
        //setWage(wage);  // Set the wage level. Will vary depending on job type and memberhsip level.
    }

    public double calculatePay() {
    
            // Overtime calculation for wages
            if (getHours()>40)
                return 40 * getWage() + (40 - getHours()) * (getWage() * 1.5);
    /*
            // Wage calculation
            switch  getMembership()
                    case1 : if getMembership() == Gold && job == chef
                            getWage() == $25;
                    
                    case2 : if getMembership() == Gold && job == busboy
                            getWage() == $15;
                    
                    case3 : if getMembership() == Silver && job == chef
                            getWage() == $20;
                    
                    case4 : if getMembership() == Silver && job == busboy
                            getWage() == $10;
                    
                    case5 : if getMembership() == Bronze && job == chef
                            getWage() == $10;
                    
                    case6 : if getMembership() == Bronze && job == busboy 
                            getWage() == $7.25;
                    
                    
                    
      */     
    // I'm going to see 
    // If these changed were picked up in GitDesktop
    return 100.00;
    }
    
    public void setMembership(String membership)
    {
        this.membership = membership;
    }
            
    public String getMembership()   
    {
            return this.membership;
    }
    
    // A simple setter for the wage.
    // Not sure how it will work with polymorphism
    // Ideally I want subclasses of this class to use their overridden setWage functions during polymorphism.
   // public void setWage(double wage)
   // {
   //     this.wage = wage;
   // }
    
    public double getWage()
    {
        return this.wage;
    }
    
    //@Override
    //public double getMoney(){ //calculate for overtime (hours worked over 40 hrs are more). Overtime hours receive 50% more pay per hour
    //    if(getHours()>40)//Overtime
    //        return 40 * getWage() + (40 - getHours()) * (getWage() * 1.5);
    //    return getHours() * getWage();
    //}
}
