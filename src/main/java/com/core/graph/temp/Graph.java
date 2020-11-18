package com.core.graph.temp;

import java.util.Iterator;

public interface Graph {

	int getTotalVortices();

	boolean isDirected();

	void insert(Edge edge);

	boolean isEdge(int source, int dest);

	Edge getEdge(int source, int dest);

	Iterator<Edge> edgeIterator(int source);
}
