package com.core.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import lombok.Data;

public class Dijkstra {

	public static void main(String arg[]) {
		int V = 6;

		// adjacency list representation of graph
		List<List<Node>> adj_list = new ArrayList<List<Node>>();
		// Initialize adjacency list for every node in the graph
		for (int i = 0; i < V; i++) {
			List<Node> item = new ArrayList<Node>();
			adj_list.add(item);
		}

		int source = 0;

		adj_list.get(0).add(new Node(1, 2));
		adj_list.get(0).add(new Node(2, 1));
		adj_list.get(1).add(new Node(5, 4));
		adj_list.get(2).add(new Node(5, 3));
		adj_list.get(5).add(new Node(4, 9));
		adj_list.get(5).add(new Node(3, 8));

		// call Dijkstra's algo method

		Dijkstra dpq = new Dijkstra(V);
		dpq.search(adj_list, source);

		// Print the shortest path from source node to all the nodes
		System.out.println("The shorted path from source node to other nodes:");
		System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
		for (int i = 0; i < dpq.dist.length; i++)
			System.out.println(source + " \t\t " + i + " \t\t " + dpq.dist[i]);
	}

	int dist[];
	Set<Integer> visited;
	PriorityQueue<Node> queue;
	int totalVertices; // Number of vertices
	List<List<Node>> adjacentList;

	public Dijkstra(int vertices) {
		this.totalVertices = vertices;
		dist = new int[vertices];
		visited = new HashSet<Integer>();
		queue = new PriorityQueue<Node>(vertices, new Node());
	}

	public void search(List<List<Node>> adjacentList, int startVertex) {
		this.adjacentList = adjacentList;

		for (int i = 0; i < totalVertices; i++)
			dist[i] = Integer.MAX_VALUE;

		// first add source vertex to PriorityQueue
		queue.add(new Node(startVertex, 0));

		// Distance to the source from itself is 0
		dist[startVertex] = 0;
		while (visited.size() != totalVertices) {

			// u is removed from PriorityQueue and has min distance
			int u = queue.remove().node;

			// add node to finalized list (visited)
			visited.add(u);
			graph_adjacentNodes(u);
		}
	}

	private void graph_adjacentNodes(int u) {
		int edgeDistance = -1;
		int newDistance = -1;

		// process all neighbouring nodes of u
		for (int i = 0; i < adjacentList.get(u).size(); i++) {
			Node v = adjacentList.get(u).get(i);

			// proceed only if current node is not in 'visited'
			if (!visited.contains(v.node)) {
				edgeDistance = v.cost;
				newDistance = dist[u] + edgeDistance;

				// compare distances
				if (newDistance < dist[v.node])
					dist[v.node] = newDistance;

				// Add the current vertex to the PriorityQueue
				queue.add(new Node(v.node, dist[v.node]));
			}
		}
	}

	@Data
	private static class Node implements Comparator<Node> {
		public int node;
		public int cost;

		public Node() {
		} // empty constructor

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compare(Node node1, Node node2) {
			if (node1.cost < node2.cost)
				return -1;
			if (node1.cost > node2.cost)
				return 1;
			return 0;
		}
	}

}
