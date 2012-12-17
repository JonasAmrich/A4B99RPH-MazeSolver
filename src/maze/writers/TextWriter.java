/*
 * @copyright	Copyright (c) 2012 Jonas Amrich
 */
package maze.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import maze.utils.Coordinate;

/**
 *
 * @author jonasamrich
 */
public class TextWriter implements Writer {

	@Override
	public void writePath(Deque<Coordinate> path, String original, String output) throws IOException {

		BufferedWriter out = new BufferedWriter(new FileWriter(output + ".txt"));

		while (!path.isEmpty()) {
			out.write(path.poll().toString());
			out.newLine();
		}

		out.close();
	}
}
