/*
 * @copyright	Copyright (c) 2012 Jonas Amrich
 */
package maze.writers;

import java.io.IOException;
import java.util.Deque;
import maze.utils.Coordinate;

/**
 *
 * @author jonasamrich
 */
public interface Writer {
	
	public void writePath(Deque<Coordinate> path, String original, String output) throws IOException;
	
}
