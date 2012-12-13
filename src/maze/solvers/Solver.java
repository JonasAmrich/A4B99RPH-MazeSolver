
package maze.solvers;

import java.util.List;
import maze.utils.Coordinate;

/**
 *
 * @author jonasamrich
 */
public interface Solver {
	
	List<Coordinate> findPath(int[][] _map);

}
