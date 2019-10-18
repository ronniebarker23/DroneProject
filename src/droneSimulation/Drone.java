/**
 * 
 */
package droneSimulation;

/**
 * @author ronniebarker
 *
 */
public class Drone {
	
	private int xPosition;
	private int yPosition;
	private static int start = 0;
	private int ID;
	private char direction;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Drone d = new Drone(5, 3);		// create drone
		Drone x = new Drone(2,3);
		System.out.println(d.toString());	// print where is
		System.out.println(x.toString());

	}
	
	/**
	 * instantiate drone
	 * @param X int
	 * @param Y int
	 */
	public Drone(int X, int Y) {
		xPosition = X;
		yPosition = Y;
		ID = start++;
	}
	
	/**
	 * print location of the instantiated drone
	 */
	public String toString() {
		return "Drone " + ID + " is at " + xPosition + ", " + yPosition;
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

}
