/**
 * 
 */
package droneSimulation;

import java.util.Random;

/**
 * @author ronniebarker
 * where drones are
 */
public class DroneArena {
	
	private int xSize;
	private int ySize;
	private Drone [] DroneArray;
	Random randomGenerator;
	
	/**
	 * Initialise arena with given size
	 * @param X int width
	 * @param Y int length
	 */
	public DroneArena(int X, int Y) {
		xSize = X;
		ySize = Y;
		DroneArray = new Drone [20]; 
		
		randomGenerator = new Random();			//create random
		
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DroneArena a = new DroneArena(20, 10);	// create drone arena
		a.addDrone();
		a.addDrone();
		System.out.println(a.toString());	// print where is


	}
	
	/**
	 * add drone to arena
	 * @param givenDrone
	 */
	public void addDrone() {
		int xVal = randomGenerator.nextInt(xSize);		//random x less than width
		int yVal = randomGenerator.nextInt(ySize);		//random y less than height
		Drone newDrone = new Drone(xVal, yVal);
		
		int index = 0;
		while(DroneArray[index] != null) {
			index++;
		}
		DroneArray[index] = newDrone;
		
	}
	
	/**
	 * return size of arena and location of drones
	 */
	public String toString() {
		String locations = "";
		for(int index = 0; index < DroneArray.length; index++) {		//find all drones
			if(DroneArray[index] != null) {
				locations += DroneArray[index].toString();
				locations += "\n";
			}
		}
				
		return locations;
	}

}
