package com.goustein.graphs.undirected;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**

// biparite graph

0 
13
0 1 2 5 6
1 0 3
2 
3 1 5
4 5 6
5 0 3 4 
6 0 4 7
7 6 8
8 7 10
9 10 11
10 8 9 12
11 9 12
12 10 11



// not a biparite
source 
total no pf vertices
edges  
 
 
0  
13
0 1 2 5 6
1 0 3
2 
3 1 4 5
4 3 5 6
5 0 3 4 
6 0 4 7
7 6 8
8 7 10
9 10 11
10 8 9 12
11 9 12
12 10 11
 */

public class BiPartite {

	
	public static void main(String[] args) {
		
		int source = GraphInitializer.getSource();
		Graph g = GraphInitializer.getGraph();
		System.out.println(isColorable(g, source));
		
	}
	
	static boolean isColorable(Graph g, int source){
		
		boolean [] isColored = new boolean[g.v];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean isvisited[] = new boolean[g.v];
		
		queue.add(source);
		isvisited[source] = true;
		
		while(!queue.isEmpty()){
			int node = queue.remove();
			boolean colorable  = checkforColorable(g, node, isColored, isvisited, queue);
			if(!colorable)
				return colorable;
		}
		return true;
		
		
	}
	
 // 1. node is colored 
 // 2.node is not colored
 // 	
	
	
  static boolean checkforColorable(Graph g,int node, boolean[] iscolored,boolean isVisted[],Queue q){
		
	  LinkedList<Edge> list = g.adj[node];
	  
	  for(int i =0 ;i< list.size();i++){
		 if(!isVisted[list.get(i).to]){
			 iscolored[list.get(i).to] = !iscolored[node];
			 isVisted[list.get(i).to] = true;
			 q.add(list.get(i).to);
		 }else{
			 
			 if(iscolored[node] == iscolored[list.get(i).to]){
				 return false;
			 }
		 }
	  }
	  
	  return true;
	}
	
}
