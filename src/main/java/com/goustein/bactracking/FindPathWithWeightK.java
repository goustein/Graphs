package com.goustein.bactracking;

import java.util.LinkedList;

import com.goustein.graph.ConstuctGraph;
import com.goustein.graph.Edge;
import com.goustein.graph.Graph;


/**
4
4
0 1 10
1 2 20
2 3 30
3 1 10




9
28
0 1 4
0 7 8
1 0 4
1 2 8
1 7 11
2 1 8
2 3 7
2 8 2
2 5 4
3 2 7
3 4 9
3 5 14
4 3 9
4 5 10
5 4 10
5 3 14
5 2 4
5 6 2
6 5 2
6 8 6
6 7 1
7 0 8
7 6 1
7 8 7
7 1 11
8 2 2
8 6 6
8 7 7
 */

public class FindPathWithWeightK {
	
	public static void main(String[] args) {
		Graph g = ConstuctGraph.getGraph();
		System.out.println(isAnyPath(g,0,62));
		
	}
	
	
	
	static boolean isAnyPath(Graph g, int source, int k){	
		int pathWeight = 0 ;
		boolean isVisited [] = new boolean[g.v];
		
		return isAnyPath(g, source, k,pathWeight,isVisited);
	}
	
  static boolean isAnyPath(Graph g, int node, int k, int pathW,boolean isVisited[]){
	   
	  boolean isPath = false;
	  
	  isVisited[node] = true;
	  LinkedList<Edge> list = g.adj[node];
	  for(int i = 0 ; i< list.size() ; i++){
		  Edge edge = list.get(i);
		  if(!isVisited[edge.to]){
			  if(pathW+edge.weight >= k){
				  isPath = true;
			  }else{
				  isPath = isAnyPath(g, edge.to, k, pathW+edge.weight, isVisited);
			  }
			  
			  if(isPath == true) break;
		  }
	  }
	   	
     isVisited[node] = false;
		
	 return isPath;	
    }
	
	
	
	

}
