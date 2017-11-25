package com.goustein.graphs.undirected;

import java.util.LinkedList;

public class Graph {
	
	LinkedList<Edge>[] adj ;
	int v ; // number of vertices in the graph
	int edges;
	public Graph(int v) {
		super();
		this.v = v;
		adj = new LinkedList[v];
		for(int i =0 ;i < v;i++)
			adj[i] = new LinkedList<Edge>();
	}
	
	public void addEdge(int from ,int to){
		edges++;
		adj[from].add(new Edge(to, 1));
	}
	
	public void addEdge(int from ,int to, int weight){
		edges++;
		adj[from].add(new Edge(to,weight));
	}
}
