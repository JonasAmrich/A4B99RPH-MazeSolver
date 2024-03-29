/*
 * @copyright	Copyright (c) 2012 Jonas Amrich
 */
package maze;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import maze.solvers.BreadthFirstSearch;
import maze.solvers.Solver;
import maze.writers.Writer;

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

		// default start and finish positions fits for grand1 maze
		int[] start = {0, 1};
		int[] finish = {map.length - 2, map[0].length - 1};
		String output = null;

		try {

			for (int i = 0; i < args.length; i++) {

				if (args[i].startsWith("--start")) {
					start[0] = Integer.parseInt(args[i].substring("--start".length() + 1, args[i].indexOf(":")));
					start[1] = Integer.parseInt(args[i].substring(args[i].indexOf(":") + 1));
					
				}

				if (args[i].startsWith("--finish")) {
					finish[0] = Integer.parseInt(args[i].substring("--finish".length() + 1, args[i].indexOf(":")));
					finish[1] = Integer.parseInt(args[i].substring(args[i].indexOf(":") + 1));
				}
				
				if (args[i].startsWith("--out=")) {
					output = args[i].substring("--out=".length());
				}

			}

		} catch (NumberFormatException e) {
			System.out.println("An error ocurred while parsing start and finish arguments.");
			System.exit(0);
		}
		
		System.out.println("Finding path");

		Deque path = solver.findPath(map, start, finish);
		double findTime = System.nanoTime();
		
		if (path == null) {
			System.out.println("No path found, sorry.");
			System.exit(0);
		}

		System.out.printf("Path found. Size %d, elapsed %.3fs%n", path.size(), (findTime - parseTime) / 1000000000.);

		
		if (output != null) {
			
			System.out.printf("Saving path as %s%n", output);
			
			try {

				Writer writer = (Writer) Class.forName("maze.writers." + output + "Writer").newInstance();
				writer.writePath(path, filename, filename.substring(0, filename.lastIndexOf(".")) + ".solved");

			} catch (ClassNotFoundException ex) {
				Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {
				Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {
				Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}

	private static int[][] parseImage(String filename) {

		try {

			BufferedImage image = ImageIO.read(new File(filename));

			int width = image.getWidth();
			int height = image.getHeight();

			int[][] map = new int[width][height];


			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					map[x][y] = image.getRGB(x, y) & 0x00FFFFFF;
				}
			}

			return map;

		} catch (IOException ex) {
			System.out.printf("An error ocurred while reading file '%s'.%n", filename);
			Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
			System.exit(0);
		}

		return null;
	}

}
