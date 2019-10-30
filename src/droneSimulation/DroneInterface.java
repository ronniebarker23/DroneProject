/**
 * 
 */
package droneSimulation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;




/**
 * @author ronniebarker
 * Allows user interaction with arena
 */
public class DroneInterface {
	
	 private Scanner s;							// scanner used for input from user
	 
	 private DroneArena myArena;				// arena in which drones are shown
	 JFileChooser chooser = new JFileChooser();

	
	 /**
	  * constructor for DroneInterface
	  * sets up scanner used for input and the arena
	  * then has main loop allowing user to enter commands
	  */
	 public DroneInterface() {
		 s = new Scanner(System.in);			// set up scanner for user input
		 myArena = new DroneArena(20, 6);	// create arena of size 20*6
		 //myArena.addDrone();
		 //myArena.addDrone();
		 //moveDrones();

		 char ch = ' ';
		 do {
			 System.out.print("Enter (N)ew arena, (A)dd drone, get (I)nformation, (D)o display, (M)ove, (S)ave arena, (L)oad arena or e(X)it > ");
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
			 case 'M':
			 case 'm':
				 moveDrones();
				 break;
			 case 'N':
			 case 'n':
				 //ask for size
				 System.out.println("Enter width of the arena ");
				 int x = s.nextInt();
				 s.nextLine();
				 System.out.println("Enter height of the arena ");
				 int y = s.nextInt();
				 s.nextLine();
				 newArena(x,y);
				 break;
			 case 'S':
			 case 's':
				 saveArena();
				 break;
			 case 'L':
			 case 'l':
				 openFile();
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
	 
	 /**
	  * move all drones 10 times
	  */
	 private void moveDrones() {
		 int count = 10;
		 while(count > 0) {		//loop 10 times
			 myArena.moveAllDrones();			//move drones
			 doDisplay();			//redraw arena
			 System.out.print(myArena.toString());			//print drones and their location
			 count -= 1;
		 }
		 try
		 {
		     Thread.sleep(200);
		 }
		 catch(InterruptedException stop)
		 {
		     Thread.currentThread().interrupt();
		 }
		 
	 }
	 
	/**
	 * create new arena
	 * @param x width of arena
	 * @param y height of arena
	 */
	 private void newArena(int x, int y) {
		 myArena = new DroneArena(x,y);
	 }
	 
	 /**
	  * save arena to file
	  */
	 private void saveArena() {
		 //pick name and location
		 int approve = chooser.showSaveDialog(null);
		 if (approve == JFileChooser.APPROVE_OPTION) {			//if possible
			 File selFile = chooser.getSelectedFile();			//get output file
			 File currDir = chooser.getCurrentDirectory();		//get directory to save to
				System.out.println("You chose to save into file: "
						+ selFile.getName() + " in the dir " 
						+ currDir.getAbsolutePath());
			
			 //save
			 try {
				 FileWriter outFileWriter = new FileWriter (selFile);		//create filewriter for selected file
				 PrintWriter writer = new PrintWriter(outFileWriter);
				 writer.println(myArena.saveArena());						//save arena info to file
				 writer.close();
			 } 
			 catch (FileNotFoundException e) {								//if can't find file
			 	e.printStackTrace();
			 } 
			 catch (IOException e) {										//if input/output error
			 	e.printStackTrace();
			 }
		 }
		 
	 }
	 
	 /**
	  * load arena from file
	  */
	 public void openFile() {
		 int approve = chooser.showOpenDialog(null);
		 if (approve == JFileChooser.APPROVE_OPTION) {				// if possible
		 	File selFile = chooser.getSelectedFile();				//selected file
		 	System.out.println("You chose to open this file: "
		 				+ selFile.getName());
		 	if(selFile.isFile()){ //exits and is a file
		 		//set up file and stream
				try {
					FileReader fileReader = new FileReader(selFile);
					BufferedReader bufReader = new BufferedReader(fileReader);
			 		String input;
			 		input = bufReader.readLine();
			 		while (input!= null) {
			 			System.out.println(input);
			 			input = bufReader.readLine();
			 		}
			 		
			 		bufReader.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		 		

		 	}
		 }

	 }
	 


	 public static void main(String[] args) {
		 DroneInterface r = new DroneInterface();	// just call the interface
		 
		 
	 }

	}

