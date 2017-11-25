package com.goustein.graph;

import java.util.LinkedList;

public class Graph {

	public LinkedList<Edge> adj[];
	public int edges;
	public int v;

	public Graph(int v) {
		adj = new LinkedList[v];
		this.v = v;
		for(int i =0 ;i < v ; i++){
			adj[i] = new LinkedList<Edge>();
		}
	}

	void addEdge(int from, int to, int weight) {
		edges++;
		adj[from].add(new Edge(from, to, weight));

	}
	
	public void addEdge(Edge edge) {
		edges++;
		adj[edge.from].add(edge);

	}

	void addEdge(int from, int to) {
		addEdge(from, to, 1);
	}

}
