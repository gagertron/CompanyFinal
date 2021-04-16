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
 //The Bartender class is a tipped/FOH Employee
//The Bartender class has a unique variable tracking how many guests they have served
public final class Bartender extends FrontOfHouseEmployee implements PayCalculator {
    
    private int guestsServed;

    public Bartender(){ //default constructor, all values set minimum (which is why the super keyword is used, because the parent default is also minimum)
       
        
        setWage(0);
        setHours(0);
        //setTipTable(super.getTipTable());
        guestsServed = 0;
    }

    public Bartender(double hours, int guests_served, double[] tipTable){
        setWage(5.00);
        setHours(hours);
        this.guestsServed = guests_served;
        setTipTable(tipTable);
        
    }
    //setters and getters
    public int getGuestsServed() {
        return guestsServed;
    }

    public void setGuestServed(int guests_served) {
        this.guestsServed = guests_served;
    }

    //INCOMPLETE
}

