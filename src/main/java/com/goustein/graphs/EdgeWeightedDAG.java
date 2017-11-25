package com.goustein.graphs;

import java.util.LinkedList;

public class EdgeWeightedDAG {
	
	public LinkedList<DirectedEdge> [] adj;
	public int vertex;
	
	public EdgeWeightedDAG(int v){
		adj = new LinkedList[v];
		for(int i = 0 ;i< v ; i++){
			adj[i] = new LinkedList<DirectedEdge>();
		}
		this.vertex = v;
	}
	
	
	public void addEdge(int from ,int to ,int weight){
		adj[from].add(new DirectedEdge(from, to, weight));
	}
	
}
