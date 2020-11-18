package com.core.graph.alter;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.core.graph.alter.Graph.Vertex;

public class GraphTraversal {
	static Set<String> depthFirstTraversal(Graph graph, String root) {
		Set<String> visited = new LinkedHashSet<String>();
		Deque<String> stack = new LinkedList<String>();
		stack.push(root);
		while (!stack.isEmpty()) {
			String vertex = stack.pop();
			if (!visited.contains(vertex)) {
				visited.add(vertex);
				for (Vertex v : graph.getAdjVertices(vertex)) {
					stack.push(v.label);
				}
			}
		}
		return visited;
	}

	static Set<String> breadthFirstTraversal(Graph graph, String root) {
		Set<String> visited = new LinkedHashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(root);
		visited.add(root);
		while (!queue.isEmpty()) {
			String vertex = queue.poll();
			for (Vertex v : graph.getAdjVertices(vertex)) {
				if (!visited.contains(v.label)) {
					visited.add(v.label);
					queue.add(v.label);
				}
			}
		}
		return visited;
	}
}
