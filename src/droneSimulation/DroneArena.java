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
	private Drone drone;
	Random randomGenerator;
	
	/**
	 * Initialise arena with given size
	 * @param X int width
	 * @param Y int length
	 */
	public DroneArena(int X, int Y) {
		xSize = X;
		ySize = Y;
		
		randomGenerator = new Random();			//create random
		
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DroneArena a = new DroneArena(20, 10);	// create drone arena
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
		drone = new Drone(xVal, yVal);
		
	}
	
	/**
	 * return size of arena and location of drones
	 */
	public String toString() {
		return "The arena is " + xSize + " x " + ySize + " and " + drone.toString();
	}

}
