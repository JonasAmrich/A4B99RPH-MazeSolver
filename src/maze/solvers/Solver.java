
package maze.solvers;

import java.util.Deque;
import maze.utils.Coordinate;

/**
 *
 * @author jonasamrich
 */
public interface Solver {
	
	Deque<Coordinate> findPath(int[][] _map);

}
