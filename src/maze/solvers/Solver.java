/*
 * @copyright	Copyright (c) 2012 Jonas Amrich
 */
package maze.solvers;

import java.util.Deque;
import maze.utils.Coordinate;

/**
 *
 * @author jonasamrich
 */
public interface Solver {

	Deque<Coordinate> findPath(int[][] _map, int[] start, int[] finish);
}
