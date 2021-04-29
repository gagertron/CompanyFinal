/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

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
    public FrontOfHouseEmployee(String fName, String lName, int id, double hours){
        super(fName, lName, id, hours); // Passes this data to the super class's constructor (Employee).
        setWage(wage);
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

    /**
     * A simple generator that will randomly generate tip amounts on a given day.
     * Just pass in the number of days you want to generate.
     * Needs for the employee class to have a First and Last Name as well as an employee ID.
     * Will then export the txt file in the project directory with the employee id and first name as the file name.
     * @author David Mendez
     */
    public void simulateDay(int numDays){
        Random rand = new Random();
        int upperbound = 10; //Max 10 tips in a given day.
        int tipUpperbound = 50; //Max $50 a tip

        int id = getId();
        int day = 1;
        int arraySize = 0;
        Vector tipList = new Vector(); // Used to store the tips generated.

        //Write to file
        try{
            FileWriter myWriter = new FileWriter(id+"-"+super.getfName()+".txt");
            myWriter.write("FIRST NAME: " + getfName() + "\n");
            myWriter.write("LAST NAME: " + getlName() + "\n");
            myWriter.write("Wage: " + getWage() + "\n");
            myWriter.write("ID: "+id+"\n");

            //Append the tips.
            for (int i = 0; i < numDays; i++) {

                // Creates number of tips made in a day. Minimum 1 tip.
                myWriter.write("DAY: "+ day +"\n");
                int numberOfTips = rand.nextInt(upperbound);
                if (numberOfTips==0) numberOfTips = 1;

                for (int j = 0; j < numberOfTips; j++) {
                    int tipAmount = rand.nextInt(tipUpperbound);
                    if (tipAmount == 0) tipAmount = 1;
                    myWriter.write("$"+tipAmount+"\n");
                    tipList.addElement(tipAmount); // Add the tipAmount to the vector list.
                    arraySize++;
                }
                day++;
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            // Now that we know the size of the array we can set it here so that we can pass it
            // to the object's TipTable.
            double[] tips = new double[arraySize];
            for (int i = 0; i < arraySize; i++) {
                tips[i] = (int) tipList.get(i); // Cast to an int so that it can be read by the array which will turn it into a double.
            }
            setTipTable(tips);

        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // This is just to see how to read from the text file.
        try {
            File myFile = new File(id+"-"+getfName()+".txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

