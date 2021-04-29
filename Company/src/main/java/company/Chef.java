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
public class Chef extends BackOfHouseEmployee {
    
    private String membership;
    private double wage;
    public double hours;


    
    // Precondition: Employees first name, last name, ID #,  
    public Chef(String fName, String lName, int id, double hours, String membership){
        super(fName, lName, id, hours, membership); 
        setWage();
    }

    public String getMembership()
    {
        return this.membership;
    }

    // set the membership level of this BackOfHouseEmployee
    // membership level will be random in our case but will determine how high or low an instance of this object's wage is
    public void setMembership(String membership)
    {
        this.membership = membership;
    }

    // set the wage for a chef
    // will vary depending on membership status
    
    public void setWage()
    {
        switch  (this.getMembership())
            {
                    case "Gold": 
                            this.wage = 25;
                    
                    case "Silver":
                            this.wage = 15;
                    
                    case "Bronze":
                            this.wage = 10;
            }
    }

    // return the wage for a chef
    public double getWage()
    {
        return this.wage;
    }


    @Override
    public double calculatePay()
    {

        return 27.00;

    }

    
    // Subtracts total break time from total hours worked. 
    @Override
    public double takeBreak()
    {
        return super.getBreakTime() - super.getHours();
    }


}

