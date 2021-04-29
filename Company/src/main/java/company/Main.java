/* Team 9 - Object Oriented Programming (COSC 3324)
* Trustin Adkins - tadkins1@islander.tamucc.edu
* Trevor Lastelick -
* David Mendez
* Gordon Agerton
 */
//System For accounting Restaurant employee earnings

/*REVISION AND EDIT LOG
*IntelliJ project created - 3/29/2021
* Created objects based on rough UML drafts - Trustin, 4/1/2021
 */

//MISSING COMPONENTS - TO DO
//*Exception Handling
//*Interfaces
//*GUIs
//*Don't forget your comments! Dr. Hadimlioglu is strict about them

package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//Main method that will create an object to utilize all of our code
public class Main {

    public static void main(String[] args) {
	
        // use polymorphism to quickly create some FOH and BOH employees to work with
        // FrontOfHouseEmployee[] workers = new FrontOfHouseEmployee[2];
        // workers[0] = new Bartender();
        // workers[1] = new Bartender();
         
        // System.out.println(workers[0].calculatePay());
         
         // create a tipTable to work with
         // double[] tips = {22.50, 10.00, 5};
         
         // hours , guestsServed, arrayOfTips
         Bartender jack = new Bartender("Jack", "Wilson", 1, 2.0,3);
         Bartender rick = new Bartender("Rick", "Turner", 2, 4.0,12);

        
         // Does not take a wage in constructor, but sets the wage of the class in constructor.
         // Wage is based on membership given. 
         // fname, lname, id #, hours worked, membership level
        //Chef james = new Chef("James", "Smith", 3, 7.3, "Gold");
         
        // Write Jack's info to a txt file.
        // I've created another function that will return a random number between 1-7.
        // You can use it like this below, or you can set a variable to daysWorked if you want all
        // of the employees to have the same amount of generated days.
        daySimulator(jack, daysWorked());
        daySimulator(rick, daysWorked());

        // Just to show that the calculation works.
        System.out.println("Jack's list of tips: " + Arrays.toString(jack.getTipTable()));
        System.out.println("Jack's total tip amt: $" + jack.getTips());
        System.out.println("Jack's hours: " + jack.getHours());
        System.out.println("Jack's wage: " + jack.getWage());
        System.out.println("Jack's total Pay = $" + jack.calculatePay());
        
    }

    /**
     * A simple generator that will randomly generate tip amounts on a given day.
     * Just pass in an employee object and the number of days you want to generate.
     * Needs for the employee class to have a First and Last Name as well as an employee ID.
     * Will then export the txt file in the project directory with the employee id and first name as the file name.
     * @author David Mendez
     */

    public static void daySimulator(FrontOfHouseEmployee employee, int numDays){

        Random rand = new Random();
        int upperbound = 10; //Max 10 tips in a given day.
        int tipUpperbound = 50; //Max $50 a tip

        int id = employee.getId();
        int day = 1;
        int arraySize = 0;
        Vector tipList = new Vector(); // Used to store the tips generated.

        //Write to file
        try{
            FileWriter myWriter = new FileWriter(id+"-"+employee.getfName()+".txt");
            myWriter.write("FIRST NAME: " + employee.getfName() + "\n");
            myWriter.write("LAST NAME: " + employee.getlName() + "\n");
            myWriter.write("Wage: " + employee.getWage() + "\n");
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
            employee.setTipTable(tips);

        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // This is just to see how to read from the text file.
        try {
            File myFile = new File(id+"-"+employee.getfName()+".txt");
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

    /**
     * Will return a random number between 1 and 7 when called.
     * @author David Mendez
     */
    public static int daysWorked(){
        Random rand = new Random();
        int upperbound = 7;
        int days = rand.nextInt(upperbound);
        if(days == 0){
            days = 1;
        }
        return days;

    }
    
    // COMMENT #3
    // This is what I envision having on Chef's daySimulator version.
    // Keep in mind, chef's don't use tips. And their is no wage in their constructor,
    // they set their wage via a function in the constructor based on the membership string given.
    // 
    // 1. daysWorked can either be randomly generated or you can just punch in a number like you've already done.
    // 2. randomly generate the amount of hours that were worked in one day (this should be 1 number per day)
    // 3. input the amount of breaks that were taken each day. (For simplicity sakes I'm thinking 1 break taken per day
    // think of it as a lunch break. And we can maybe randomly generate 0-3 breaks taken a day in the future.
    // 4. Randomly generate the amount of time taken for each break. The amount of time for each break will be 
    // deducted from the total hours worked that week. If 42 hours were worked, but 4 hours of breaks were taken
    // that chef will not recieve his overtime for working over 40 hours. 
    // 5. Ideally take the number of hours worked each day as it's generated and put it into an array or vector.
    // this will be used in the calculatePay function.
    // 6. Do the same as 5 but for the breaks. So we can keep track of the time of breaks and suibtract it from
    // total hours worked within the calculatePay function. IM THINKING HOURSWORKED, AND TOTALBREAKTIME 
    // SHOULD BE TWO SEPARATE ARRAYS.
    
    
    /*
        What I am envisioning, thinking about when I say my comments.
    
    This program is gearing towards manually assigning or randomly generating an employee's
    days worked in a 7 day week , hourly wage , hours worked per day, breaks taken per day,
    time of each break each day, and each tip that was earned on a given day. We can use all
    this to calculate an employees pay at the end of each day, each week, and make sure employees
    are paid at least minimum wage or compensated for overtime. Ideally we'll have arrays or vectors
    for each of these categories for each class and all we'll have to do is read from that class' 
    function and not have to read from files. 
    
    I'm not sure what would be easier for Gordon to translate into a GUI, the class functions
    or reading from a file. 
    
    
    
    
    */
    
}
