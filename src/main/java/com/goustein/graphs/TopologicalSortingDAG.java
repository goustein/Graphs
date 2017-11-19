package com.goustein.graphs;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSortingDAG {
	
	static boolean isVisited [] ;
	static EdgeWeightedDAG  g;
	
 static Stack<Integer> getTopologicalSort(EdgeWeightedDAG gr,int source){
	 Stack<Integer>  ts = new Stack<Integer>();
	 Stack<Integer> t = new Stack<Integer>();
	 isVisited = new boolean[gr.vertex];
	 g = gr;
	 isVisited[source] = true;
	 t.add(source);
	 
	 while(!t.isEmpty()){
		int node =  t.peek();
		int nextNode = getUnvisitedNodeEdge(node);
		if(nextNode == -1){
			t.pop();
			isVisited[node] = true;
			ts.push(node);
		}else{
			t.push(nextNode);
		}
	 }
	 return ts;
 }

 
  static int getUnvisitedNodeEdge(int node){
	  System.out.println(node);
	  LinkedList<DirectedEdge> list = g.adj[node];
	  for(int i =0;i<list.size();i++){
		  DirectedEdge edge = list.get(i);
		  if(!isVisited[edge.to]){
			  return edge.to;
		  }
	  }
	  return -1;
   }
 
}
