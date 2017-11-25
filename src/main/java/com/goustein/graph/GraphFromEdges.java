package com.goustein.graph;

public class GraphFromEdges {

	public static Graph getGraph(Edge[] edges){
		Graph g = new Graph(edges.length);
		
		for(int i =0 ;i < edges.length ; i++){
			Edge edge = edges[i];
			if(edge != null){
				g.addEdge(edge);
			}
		}
		
		return g;
	}
	
	
}
