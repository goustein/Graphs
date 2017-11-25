package com.goustein.graphs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class FindNegativeCycleIntheGraph {
	
	static int vertex ;
	static EdgeWeightedDAG g;
	static Queue<Integer> q = new ArrayDeque<Integer>();
	static boolean inQ[];
	static boolean hasNegativeCycle = false;
	static int[] distTO;
	
  static boolean hasNegativeCycle(EdgeWeightedDAG graph,int source){
		FindNegativeCycleIntheGraph.g = graph;
	    
	   vertex = graph.vertex;
	   inQ = new boolean[vertex];
	   distTO = new int[vertex];
	   for(int k =0 ; k < vertex; k++){
		   distTO[k]  = Integer.MAX_VALUE; 
	   }
	   distTO[source] = 0;
	     q.add(source);
	     inQ[source]= true;
	     for(int i =0;i< vertex ;i ++){
		   int node = q.remove();
		   inQ[node] = false;
		  LinkedList<DirectedEdge> list = graph.adj[node];
		  
		  
		  for(int j =0 ;j<list.size();j++){
			  DirectedEdge edge = list.get(0);
			  if(distTO[edge.to] > distTO[edge.from]+edge.weight){
				  distTO[edge.to] = distTO[edge.from]+edge.weight;
				  if(!inQ[edge.to]){
					  q.add(edge.to);
				  }
			  }
			  
		  }
		   
		   
		   
	   }
	     
	 
	  return false;
	}

}
