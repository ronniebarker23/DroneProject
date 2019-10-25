/**
 * 
 */
package droneSimulation;

/**
 * @author ronniebarker
 * Controls drones in the arena
 */
public class Drone {
	
	private int xPosition;
	private int yPosition;
	private static int start = 0;
	private int ID;
	private Direction direction;


	
	/**
	 * instantiate drone
	 * @param X int
	 * @param Y int
	 */
	public Drone(int X, int Y, Direction dir) {
		direction = dir;
		xPosition = X;
		yPosition = Y;
		ID = start++;
	}
	
	/**
	 * print location of the instantiated drone
	 */
	public String toString() {
		return "Drone " + ID + " is at " + xPosition + ", " + yPosition + " moving " + direction.toString();
	}
	
	/**
	 * confirm/ deny is drone is at that location
	 */
	public boolean isHere(int x, int y) {
		if(xPosition == x && yPosition == y) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * display the drone in the canvas
	 * @param c	the canvas used
	 */
	public void displayDrone(ConsoleCanvas c) {
		c.showIt(xPosition, yPosition, 'D');
	}
	
	/**
	 * move to new location
	 * @param c arena
	 */
	public void tryToMove(DroneArena a) {
		//calculate new co-ord
		int newX;
		int newY;
		if (direction == Direction.NORTH) {
			newX = xPosition;
			newY = yPosition -1;
		}
		else if (direction == Direction.SOUTH) {
			newX = xPosition;
			newY = yPosition +1;
		}
		else if (direction == Direction.WEST) {
			newX= xPosition-1;
			newY = yPosition;
		}
		else {
			newX = xPosition +1;
			newY = yPosition;
		}
		
		//if can move there
		if(a.canMoveHere(newX, newY)) {
			xPosition = newX;
			yPosition = newY;
		}
		else {
			direction = Direction.next(direction);
		}
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Drone d = new Drone(5, 3, Direction.SOUTH);		// create drone
		Drone x = new Drone(2,3, Direction.NORTH);
		System.out.println(d.toString());	// print where is
		System.out.println(x.toString());

	}

}
