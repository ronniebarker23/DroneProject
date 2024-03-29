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
	 * show all the drones in the interface
	 * @param c	the canvas in which drones are shown
	 */
	public void showDrones(ConsoleCanvas c) {
		for(int index = 0; index < DroneArray.length; index ++) {
			if(DroneArray[index] != null) {
				DroneArray[index].displayDrone(c);
			}
		}

	}

	
	/**
	 * add drone to arena
	 * @param givenDrone
	 */
	public void addDrone() {
		boolean clash = true;		//initialise clash to true
		int xVal = randomGenerator.nextInt(xSize);
		int yVal = randomGenerator.nextInt(ySize);
		
		while(clash) {
			if(getDroneAt(xVal, yVal) == null) {
				clash = false;
			}
			xVal = randomGenerator.nextInt(xSize);		//random x less than width
			yVal = randomGenerator.nextInt(ySize);		//random y less than height
			
			
		}
		
		
		Drone newDrone = new Drone(xVal, yVal, Direction.randomDirection());
		
		int index = 0;
		while(DroneArray[index] != null) {
			index++;
		}
		DroneArray[index] = newDrone;
		
	}
	
	/**
	 * add given drone to arena
	 * @param x co ord
	 * @param y co ord 
	 * @param d direction of movement
	 * @param id id of drone
	 */
	public void addDrone(int x, int y, Direction d, int id) {
		Drone newDrone = new Drone(x, y, d, id);
		
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
		String locations = "The arena is " + xSize + " x " + ySize;
		for(int index = 0; index < DroneArray.length; index++) {		//find all drones
			if(DroneArray[index] != null) {
				locations += "\n";
				locations += DroneArray[index].toString();
			}
		}
				
		return locations;
	}
	
	/**
	 * search arraylist of drones to see if there is a drone at x,y
	 * @param x
	 * @param y
	 * @return null if no Drone there, otherwise return drone
	 */
	public Drone getDroneAt(int x, int y) {
		for(int index = 0; index< DroneArray.length; index++) {		//loop through drone array
			if(DroneArray[index] != null) {
				if(DroneArray[index].isHere(x,y)) {
					return DroneArray[index];		//if drone there, return that drone
				}
			}
		}
		return null;		//if not found, return null
  }
	
	/**
	 * get width of arena
	 * @return int width of arena
	 */
	public int getXSize() {
		return xSize;
	}
	
	/**
	 * get height of arena
	 * @return int height of arena
	 */
	public int getYsize() {
		return ySize;
	}
	
	/**
	 * Checks if space valid/ free
	 * @param xCo location x
	 * @param yCo location y
	 * @return true if can move, false if can't
	 */
	public boolean canMoveHere(int xCo, int yCo) {
		//if in arena
		if(xCo < xSize && xCo >= 0 && yCo < ySize && yCo >= 0) {
			//if space free
			if(getDroneAt(xCo, yCo) == null) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * try to move all drones
	 */
	public void moveAllDrones() {
		for(int index = 0; index < DroneArray.length; index ++) {
			if(DroneArray[index] != null) {
				DroneArray[index].tryToMove(this);
			}
		}
	}
	
	/**
	 * Provide data to save arena
	 * @return string with arena info on each line
	 */
	public String saveArena() {
		String save = "";
		save += xSize + "\n";
		save += ySize;
		for(int index = 0; index < DroneArray.length; index++) {		//find all drones
			if(DroneArray[index] != null) {
				save += "\n";
				save += DroneArray[index].saveDrone();
				
			}
		}
		
		return save;
				
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


}
