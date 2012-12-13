
package maze;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import maze.solvers.BreadthFirstSearch;
import maze.solvers.Solver;

/**
 *
 * @author jonasamrich
 */
public class Maze {


	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("Missing parameter: maze filename.");
			System.exit(0);
		}
		
		String filename = args[0];
		
		Solver solver = new BreadthFirstSearch();
		
		double startTime = System.nanoTime();
		
		System.out.println("Parsing image file");
		
		int[][] map = parseImage(filename);
		
		double parseTime = System.nanoTime();
		
		System.out.printf("Image file parsed. Elapsed %.3fs%n", (parseTime - startTime) / 1000000000.);
		
		System.out.println("Finding path");
		
		List path = solver.findPath(map);
		
		double findTime = System.nanoTime();
		
		System.out.printf("Path found. Size %d, elapsed %.3fs%n", path.size(), (findTime - parseTime) / 1000000000.);
		
	}
	
	private static int[][] parseImage(String filename) {
		
		try {
			
			BufferedImage image = ImageIO.read(new File(filename));
			
			int width = image.getWidth();
			int height = image.getHeight();
			
			int[][] map = new int[width][height];
			
			
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					map[x][y] = image.getRGB(x, y) & 0x00FFFFFF;
				}
			}
			
			return map;
			
		} catch (IOException ex) {
			System.out.println("An error ocurred while reading image file.");
			Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return null;
	}
	
}
