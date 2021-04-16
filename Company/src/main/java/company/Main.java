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
         Bartender jack = new Bartender(8, 3, tips);
         System.out.println(jack.getTips());
         System.out.println(jack.calculatePay());
         
         
         
        
        
    }
}
