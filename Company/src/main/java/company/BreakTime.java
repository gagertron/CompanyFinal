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
public interface BreakTime {
    
    // MV to represent the total amount of time on break
    // break should be deducted from hours worked
    //private int breakTime;
    
    
    // This function should be randomly called 0-3 times throughout the day.
    // Each break should be calculaked and added up each day.
    // The total break time will then be dudcted from hours worked each day.
    // If an Employee works 42 hours in a week but has 4 hours of break time that week,
    // They will NOT recieve overtime.
    
    public double takeBreak();
    
}
