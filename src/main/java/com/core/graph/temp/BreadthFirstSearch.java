package com.core.graph.temp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	public static int[] search(Graph graph, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();

		int[] parent = new int[graph.getTotalVortices()];
		// Declare array parent and initialize its elements to –1.
		for (int i = 0; i < graph.getTotalVortices(); i++) {
			parent[i] = -1;
		}

		boolean[] identified = new boolean[graph.getTotalVortices()];

		identified[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int current = queue.remove();
			Iterator<Edge> iterator = graph.edgeIterator(current);

			while (iterator.hasNext()) {
				Edge edge = iterator.next();
				int neighbor = edge.getDestination();

				if (!identified[neighbor]) {
					identified[neighbor] = true;
					queue.offer(neighbor);
					parent[neighbor] = current;
				}
			}

		}
		return parent;

	}

}
