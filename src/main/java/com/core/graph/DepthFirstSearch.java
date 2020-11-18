package com.core.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {
	private int totalVortices; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	DepthFirstSearch(int vortices) {
		totalVortices = vortices;
		adj = new LinkedList[vortices];
		for (int i = 0; i < vortices; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int vortices, int w) {
		adj[vortices].add(w); // Add w to v's list.
	}

	// A function used by DFS
	void util(int vortices, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[vortices] = true;
		System.out.print(vortices + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[vortices].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				util(n, visited);
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void search(int vortices) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[totalVortices];

		// Call the recursive helper function to print DFS traversal
		util(vortices, visited);
	}

	public static void main(String args[]) {
		DepthFirstSearch g = new DepthFirstSearch(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.search(0);
	}

}
