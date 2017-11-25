package com.goustein.graphs;

import java.util.Scanner;

public class GraphComposer {
	
	
	static EdgeWeightedDAG init(){
		Scanner s = new Scanner(System.in);
		int vertexCount = s.nextInt();
		EdgeWeightedDAG g = new EdgeWeightedDAG(vertexCount);
		s.nextLine();
		
		for(int i =0 ;i <vertexCount ;i++){
		String str = s.nextLine();
		String split[] = str.split("\\s+");
		//LinkedList<DirectedEdge> list = g.adj[Integer.valueOf(s)]
				
		}
		
		
		return g;
	}

}
