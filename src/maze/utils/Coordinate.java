/*
 * @copyright	Copyright (c) 2012 Jonas Amrich
 */
package maze.utils;

/**
 *
 * @author jonasamrich
 */
public final class Coordinate {

	public final int x;
	public final int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + ", " + y;
	}
}
