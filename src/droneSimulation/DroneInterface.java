/**
 * 
 */
package droneSimulation;
import java.util.Scanner;

/**
 * @author ronniebarker
 * Allows user interaction with arena
 */
public class DroneInterface {
	
	 private Scanner s;							// scanner used for input from user
	 
	 private DroneArena myArena;				// arena in which drones are shown
	
	 /**
	  * constructor for DroneInterface
	  * sets up scanner used for input and the arena
	  * then has main loop allowing user to enter commands
	  */
	 public DroneInterface() {
		 s = new Scanner(System.in);			// set up scanner for user input
		 myArena = new DroneArena(20, 6);	// create arena of size 20*6

		 char ch = ' ';
		 do {
			 System.out.print("Enter (A)dd drone, get (I)nformation, (D)o display or e(X)it > ");
			 ch = s.next().charAt(0);
			 s.nextLine();
			 switch (ch) {
			 case 'A' :
			 case 'a' :
				 myArena.addDrone();	// add a new drone to arena
				 break;
			 case 'I' :
			 case 'i' :
				 System.out.print(myArena.toString());
				 break;
			 case 'D':
			 case 'd':
				 doDisplay();
				 break;
			 case 'x' : 	ch = 'X';				// when X detected program ends
			 break;
			 }
		 } while (ch != 'X');						// test if end

		 s.close();									// close scanner
	 }
	 
	 /**
	  * Display the drone arena on the console
	  * 
	  */
	 void doDisplay() {
		 // determine the arena size 
		 int xSize = myArena.getXSize();
		 int ySize = myArena.getYsize();
		 
		 // hence create a suitable sized ConsoleCanvas object
		 ConsoleCanvas c = new ConsoleCanvas(xSize, ySize);
		 // call showDrones suitably
		 myArena.showDrones(c);		//add drones to canvas
		 // then use the ConsoleCanvas.toString method 
		 String output = c.toString();		//print canvas
		 System.out.println(output);
	 }


	 public static void main(String[] args) {
		 DroneInterface r = new DroneInterface();	// just call the interface
	 }

	}

