package com.goustein.graphs.undirected;

import java.util.LinkedList;

/**
 false:
0
7
0 1 4
1 0 2 3
2 1 3
3 1 3 
4 0 5 6
5 4 6
6 4 5


true:
0
7
0 1 4
1 0 2 3
2 1 3
3 1 3 5
4 0 5 6
5 3 4 6
6 4 5
 
 */

public class RecursiveDFS {

	
	
	public static void main(String[] args) {
		int source = GraphInitializer.getSource();
		Graph g = GraphInitializer.getGraph();
		
		System.out.println(DFS(g, source));
		
	}
	
	static int[] getEdgeTO(Graph g , int source){
        DFS(g, source);
        return edgeTO;
	}
	
	
	static int visitedCount ;
	static int v;
	static boolean [] visited;
	static int[] edgeTO;

	static boolean DFS(Graph g, int source){
	       
		 if(g.v ==0 || g.v == 1){
			 return true;
		 }
		 
	
		 if(g.adj[source].size() == 1){
			 return false;
		 }
		 
		 v = g.v;
		 visited = new boolean[g.v];
		 edgeTO = new int[g.v];
		 visited[source] = true;
		 visitedCount++;
		int firstUnvnisedNodeOfSource = g.adj[source].get(0).to;
		if(!recursiveCall(g,firstUnvnisedNodeOfSource) || v != visitedCount){
			return false;
		}
		
		return true;
	}
	
	
	
	
	static boolean recursiveCall(Graph g , int node){
		 if(g.adj[node].size() == 1){
			 return false;
		 }
		 if(visited[node])
			 return true;
		 
		 visited[node] = true;
		 visitedCount++;
		 
		 LinkedList<Edge> list = g.adj[node];
		 
		 for(int i =0 ;i<list.size();i++){
			 if(!recursiveCall(g, list.get(i).to)){
				 return false;
			 }
		 }
	    	 
		
		return true;
	}
	
	
	
}
