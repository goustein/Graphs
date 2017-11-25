package com.goustein.dfsandbfs;

import java.util.LinkedList;
import java.util.Stack;

import com.goustein.graph.ConstuctGraph;
import com.goustein.graph.Edge;
import com.goustein.graph.Graph;
/**
  
   DAG graph
   
   
6
10
0 1 5
0 2 3
1 2 2
1 3 6
2 3 7
2 4 4
2 5 2        
4 5 -2
3 4 -1
3 5 1

  
  
  
 */

public class LongestPathInaDAG {
	
	public static void main(String[] args) {
		longestPath();
	}
	
	static int [] distTO;
	static Edge[] edgeTO;
	
	
	public static void longestPath(){
		Graph g = ConstuctGraph.getGraph();
		distTO = new int[g.v];
		edgeTO  = new Edge[g.v];
		for(int i =0 ;i < g.v ; i++){
			distTO[i] = Integer.MAX_VALUE;
		}
		
		Stack<Integer> s = DFSRecursive.DFS(g);
		int source = s.peek();
		distTO[source] = 0;

		while(!s.isEmpty()){
			
			int node = s.pop();
			
			LinkedList<Edge> list = g.adj[node];
			for(int k =0 ; k< list.size(); k++){
				Edge edge = list.get(k);
				int weight = -1*edge.to;
				if(distTO[edge.to] > distTO[edge.from]+weight){
					edgeTO[edge.to] = edge;
					distTO[edge.to] = distTO[edge.from]+weight;
				}
				
			}
			
		}
		
		int max = 0;
		Edge maxEdge = null;
		
		for(int j =1 ; j< g.v ; j++ ){
			if(max < -1 *distTO[j]){
				max = -1 *distTO[j];
				maxEdge = edgeTO[j];
			}
		}
		Stack<Edge> e = new Stack<Edge>();
		while(maxEdge != null){
		 e.push(maxEdge);
		 maxEdge =  edgeTO[maxEdge.from];
		}
		
	    while(!e.isEmpty()){
	    	Edge ee = e.pop();
	    System.out.println(ee.from+" -> "+ee.to);	
	    }
	}

}
