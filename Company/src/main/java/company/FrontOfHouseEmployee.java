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
//The Front of House (FOH) employee class consists of employees who receive tips: waiters, delivery drivers, and bartenders
//The FOH class contains a table consisting of all the tips the employee received in a day
public abstract class FrontOfHouseEmployee extends Employee {

    private double[] tipTable;
    private double wage;
    //MUST throw an exception if:
    //Wages are set lower than 2.13$ - UNIMPLEMENTED
    //Hours exceeds 40 (FOH Employees cannot work overtime) - UNIMPLEMENTED
    //Tips received are less than 30$ for the month (Department of labor rules) - UNIMPLEMENTED
    
    
    // Precondition only works with 
    // int hours : how many hours worked in the day for the employee
    // int wage : the hourly wage the employee 
    //public FrontOfHouseEmployee(){ //Default constructor, all values set to minimum
        
        // broken commented code 
        //for(int i = 0; i < tipTable.length; i++)
        //    tipTable[i] = 0;//set all tips in the table to 0
    //    setWage(2.13);
    //    setHours(0);
    //}
    
    // set hours, wage, tips for a day 
    public FrontOfHouseEmployee(String fName, String lName, int id, double hours, double wage, double[] tipTable){
        super(fName, lName, id, hours); // Passes this data to the super class's constructor (Employee).
        setWage(wage);
        setTipTable(tipTable);
    }
    //setter and getter methods
    public double[] getTipTable() { //Does NOT calculate total tips, the getTips() function does
        return tipTable;
    }
    
    
    public double getTips(){ //calculate and return the sum of all the tips from a tip table (all tips made in a day)
        double totalTips = 0;
        for(int i = 0; i < getTipTable().length; i++)
            totalTips += getTipTable()[i];
        return totalTips;
    }

    // set an array full of tips from tables
    public void setTipTable(double[] tipTable) {
        this.tipTable = tipTable;
    }

    public void setWage(double wage)
    {
        this.wage = wage;
    }
    
    public double getWage()
    {
        return this.wage;
    }
    
    // from interface PayCalculator
    @Override
    public double calculatePay()
    {
        return getTips() + getHours() * getWage();
    }
    
    //@Override
    //public double getMoney(){ //Calculate a tipped employees earnings, which is tips earned added to the wage
    //    return getTips() + getHours() * getWage();
    //}
}

