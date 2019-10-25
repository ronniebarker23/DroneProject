/**
 * 
 */
package droneSimulation;

/**
 * @author ronniebarker
 * Visual of arena
 */
public class ConsoleCanvas {
	int xSize, ySize;
	char [][] canvas;
	
	/**
	 * Create canvas
	 * @param x width of arena
	 * @param y height of arena
	 */
	public ConsoleCanvas(int x, int y) {
		xSize = x;
		ySize = y;
		canvas = new char [ySize+2][xSize+2];    //create array of len given (+2 for edges)
		
		for(int yIndex = 0; yIndex <= ySize+1; yIndex ++) {				//loop through y
			for(int xIndex = 0; xIndex <= xSize+1; xIndex ++) {			//loop through x
				if(yIndex == 0 || yIndex == ySize+1 || xIndex == 0 || xIndex == xSize+1) {				//if edge
					canvas[yIndex][xIndex] = '#';
				}
			}
		}

		
	}
	
	/**
	 * add drone to canvas
	 * @param x xlocation of drone
	 * @param y ylocation of drone
	 * @param d char displayed for drone
	 */
	public void showIt(int x, int y, char d) {
		canvas[y+1][x+1] = d;		//add at index 1 past that to account for border
	}
	
	public String toString() {
		String out = "";
		for(int yIndex = 0; yIndex < ySize+2; yIndex ++) {				//loop through y
			for(int xIndex = 0; xIndex < xSize+2; xIndex ++) {			//loop through x
				if(canvas[yIndex][xIndex] != '\u0000') {
					out += canvas[yIndex][xIndex];
				}
				else {
					out += " ";
				}
			}
			out += "\n";
		}
		return out;
	}

	/**
	 * Create and print canvas
	 * @param args
	 */
	public static void main(String[] args) {
		ConsoleCanvas c = new ConsoleCanvas (10, 5);	// create a canvas
		//c.showIt(4,3,'D');								// add a Drone at 4,3
		System.out.println(c.toString());				// display result
	}


}
