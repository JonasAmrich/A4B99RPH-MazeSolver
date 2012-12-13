/*
 * @copyright	Copyright (c) 2012 Jonas Amrich
 */
package maze.utils;

/**
 *
 * @author jonasamrich
 */
public class Map {

	public static final int VISITED_SQUARE = 0x00333333;
	public static final int WALL_SQUARE = 0x00000000;
	public final int width;
	public final int height;
	private int[][] map;

	public Map(int[][] map) {
		this.map = map;
		width = map.length;
		height = map[0].length;
	}

	public boolean isInside(int x, int y) {
		return x >= 0 && y >= 0 && x < width && y < height;
	}

	public boolean isPassable(int x, int y) {
		return map[x][y] != WALL_SQUARE;
	}

	public boolean isVisited(int x, int y) {
		return map[x][y] == VISITED_SQUARE;
	}

	public void markVisited(int x, int y) {
		map[x][y] = VISITED_SQUARE;
	}
}
