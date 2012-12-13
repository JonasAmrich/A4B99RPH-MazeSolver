
package maze.utils;

/**
 *
 * @author jonasamrich
 */
public final class Coordinate {

	final public int x;
	final public int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + ", " + y;
	}

}
