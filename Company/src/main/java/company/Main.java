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
import java.util.Random;
import java.util.Scanner;

//Main method that will create an object to utilize all of our code
public class Main {

    public static void main(String[] args) {
	
        // use polymorphism to quickly create some FOH and BOH employees to work with
        // FrontOfHouseEmployee[] workers = new FrontOfHouseEmployee[2];
        // workers[0] = new Bartender();
        // workers[1] = new Bartender();
         
        // System.out.println(workers[0].calculatePay());
         
         // create a tipTable to work with
         double[] tips = {22.50, 10.00, 5};
         
         // hours , guestsServed, arrayOfTips
         Bartender jack = new Bartender("Jack", "Wilson", 1, 2.0, 7.5, 3, tips);
         Bartender rick = new Bartender("Rick", "Turner", 2, 4.0, 7.5, 12, tips);

        // Write Jack's info to a txt file.
        daySimulator(jack, 3); // Generate info for jack working 3 days.
        daySimulator(rick, 7);
    }

    // A simple generator that will randomly generate tip amounts on a given day.
    // Just pass in an employee object and the number of days you want to generate.
    // Needs for the employee class to have a First and Last Name as well as an employee ID.
    // Will then export the txt file in the project directory with the employee id and first name as the file name.
    public static void daySimulator(Bartender employee, int numDays){

        Random rand = new Random();
        int upperbound = 10; //Max 10 tips in a given day.
        int tipUpperbound = 50; //Max $50 a tip

        int id = employee.getId();
        int day = 1;

        //Write to file
        try{
            FileWriter myWriter = new FileWriter(id+"-"+employee.getfName()+".txt");
            myWriter.write("NAME: " + employee.getfName() + "\n");
            myWriter.write("LAST NAME: " + employee.getlName() + "\n");
            myWriter.write("Wage: " + employee.getWage() + "\n");
            myWriter.write("ID: "+id+"\n");

            //Append the tips.
            for (int i = 0; i < numDays; i++) {

                myWriter.write("DAY: "+ day +"\n");
                int numberOfTips = rand.nextInt(upperbound);
                if (numberOfTips==0) numberOfTips = 1;

                for (int j = 0; j < numberOfTips; j++) {
                    int tipAmount = rand.nextInt(tipUpperbound);
                    if (tipAmount == 0) tipAmount = 1;
                    myWriter.write("$"+tipAmount+"\n");
                }
                day++;
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
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
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
