/*
 * java -cp build/classes -Xmx512M -XX:+UseParallelGC maze.Maze
 * 
 * @copyright	Copyright (c) 2012 Jonas Amrich
 */
package maze.solvers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import maze.utils.Coordinate;
import maze.utils.Map;

/**
 *
 * @author jonasamrich
 */
public class BreadthFirstSearch implements Solver {
	
	public static final int[] directions = {-1, 1, 0, 0};
	
	Map map;
	ArrayDeque<Node> queue;
	
	@Override
	public List<Coordinate> findPath(int[][] _map) {

		map = new Map(_map);
		queue = new ArrayDeque<Node>();
		
		int sx = map.startPosition[0];
		int sy = map.startPosition[1];
		
		queue.add(new Node(sx, sy, null));
		map.markVisited(sx, sy);
		
		Node node;
		List path = null;
		int i, x, y;
		
		mainloop:
		while(!queue.isEmpty())
		{
			node = queue.pollFirst();

			// loop through all directions
			for(i = 0; i < 4; i++)
			{
				x = node.x + directions[i];
				y = node.y + directions[3 - i];

				if (map.isInside(x, y) && map.isPassable(x, y) && !map.isVisited(x, y))
				{	
					if(map.isFinal(x, y))
					{	
						path = constructPath(queue.getLast());
						break mainloop;
					}
					
					queue.add(new Node(x, y, node));
					map.markVisited(x, y);
				}
			}
		}
	
		return path;
	}
	
	private List<Coordinate> constructPath(Node node)
	{	
		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		
		while(node.parent != null)
		{
			coordinates.add(new Coordinate(node.x, node.y));
			node = node.parent;
		}
		
		Collections.reverse(coordinates);
		return coordinates;
	}
	
	private final class Node {
	
		public final int x;
		public final int y;

		public final Node parent;

		public Node(int x, int y, Node parent)
		{
			this.x = x;
			this.y = y;
			this.parent = parent;
		}

	}
}
