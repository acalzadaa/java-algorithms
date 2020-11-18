package com.core.graph.temp;

import lombok.Data;

@Data
public class Edge {

	private int destination;
	private int origin;
	private double weight;

	public Edge(int source, int dest) {
		this.origin = source;
		this.destination = dest;
	}

	public Edge(int source, int dest, double weight) {
		this.origin = source;
		this.destination = dest;
		this.weight = weight;
	}

}
