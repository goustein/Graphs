package com.goustein.graphs.undirected;

import java.util.Scanner;

public class GraphInitializer {
	static Scanner s  = new Scanner(System.in);
	// first source 
	// then the graph
	static int getSource(){
		int source = s.nextInt();
		s.nextLine();
		return source;
	}
	
	// it takes just the 
   static Graph getGraph(){
		int v = s.nextInt();
		Graph g = new Graph(v);
		s.nextLine();
		for(int i = 0 ;i < v; i++){
			String[] str = s.nextLine().split("\\s+");
			int node = Integer.valueOf(str[0]);
			for(int j =1 ; j < str.length ; j++)
				g.addEdge(node,Integer.valueOf(str[j]));
		}
		
		return g;
		
	}

}
