package com.goustein.graphs;

import java.io.StreamTokenizer;
import java.util.Scanner;
import java.util.Stack;

public class DAGCriticalPath {

	static Scanner scanner = new Scanner(System.in);
	static int vertexCount;
	static EdgeWeightedDAG g;
	static int s;
	static int t;

	public static void main(String[] args) {
		
		initializeGraph();
		
		//Stack<Integer> ts = TopologicalSortingDAG.getTopologicalSort(g,s); 
		//System.out.println(ts);
		
		DirectedEdge[] e = LongestPathEdgeWeightDAG.getLongestPath(g, s);
		
	}

	static void initializeGraph() {
		vertexCount = scanner.nextInt();
		
		g = new EdgeWeightedDAG(2*vertexCount+2);
		s = 2*vertexCount;
		t = s+1; // 2*vertex +1 
		 scanner.nextLine();
	  for(int i = 0 ;i<vertexCount ;i++){	
       String nextLine = scanner.nextLine();
       String[] split= nextLine.split("\\s+");
	   int nodeWeight = Integer.valueOf(split[0]);
	   
	   g.adj[i].add(new DirectedEdge(i,i+vertexCount, nodeWeight));
	   g.adj[s].add(new DirectedEdge(s,i,0));
	   g.adj[i+vertexCount].add(new DirectedEdge(i+vertexCount,t,0));
	   for(int j =1; j<split.length ;j++){
		   g.adj[i].add(new DirectedEdge(i+vertexCount,Integer.valueOf(split[j]),0));
	   }
	  }
	}

}
