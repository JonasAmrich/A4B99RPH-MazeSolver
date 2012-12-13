/*
 * @copyright	Copyright (c) 2012 Jonas Amrich
 */
package maze.solvers;

import java.util.ArrayDeque;
import java.util.Deque;
import maze.utils.Coordinate;
import maze.utils.Map;

/**
 *
 * @author jonasamrich
 */
public class BreadthFirstSearch implements Solver {

	public static final int[] directions = {-1, 1, 0, 0};

	@Override
	public Deque<Coordinate> findPath(int[][] _map) {

		Map map = new Map(_map);

		// ArrayDeque provides all used operations in amortized constant time
		// and is faster and more memory efficient than LinkedList
		Deque<Node> queue = new ArrayDeque<Node>();

		int sx = map.startPosition[0];
		int sy = map.startPosition[1];

		queue.add(new Node(sx, sy, null));
		map.markVisited(sx, sy);

		Node node;
		int i, x, y;

		while (!queue.isEmpty()) {
			node = queue.pollFirst();

			// loop through all directions
			for (i = 0; i < 4; i++) {
				x = node.x + directions[i];
				y = node.y + directions[3 - i];

				if (map.isInside(x, y) && map.isPassable(x, y) && !map.isVisited(x, y)) {
					if (map.isFinal(x, y)) {
						return constructPath(queue.getLast());
					}

					queue.add(new Node(x, y, node));
					map.markVisited(x, y);
				}
			}
		}

		return null;
	}

	private Deque<Coordinate> constructPath(Node node) {
		Deque<Coordinate> coordinates = new ArrayDeque<Coordinate>();

		while (node.parent != null) {
			coordinates.addFirst(new Coordinate(node.x, node.y));
			node = node.parent;
		}

		return coordinates;
	}

	private final class Node {

		public final int x;
		public final int y;
		public final Node parent;

		public Node(int x, int y, Node parent) {
			this.x = x;
			this.y = y;
			this.parent = parent;
		}
	}
}
