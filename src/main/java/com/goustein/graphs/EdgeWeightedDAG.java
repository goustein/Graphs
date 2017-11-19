package com.goustein.graphs;

import java.util.LinkedList;

public class EdgeWeightedDAG {
	
	LinkedList<DirectedEdge> [] adj;
	int vertex;
	
	public EdgeWeightedDAG(int v){
		adj = new LinkedList[v];
		for(int i = 0 ;i< v ; i++){
			adj[i] = new LinkedList<DirectedEdge>();
		}
		
		this.vertex = v;
	}
	
}
