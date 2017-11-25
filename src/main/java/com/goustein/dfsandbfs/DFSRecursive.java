package com.goustein.dfsandbfs;

import java.util.LinkedList;
import java.util.Stack;

import com.goustein.graph.ConstuctGraph;
import com.goustein.graph.Edge;
import com.goustein.graph.Graph;
/**
 
3
4
0 1
0 2 
1 0
2 0




 */
public class DFSRecursive {
	
	public static void main(String[] args) {
   System.out.println(DFS(0));
	
	}
	
	 static boolean isVisited [] ;
	 
	 public static Stack<Integer> DFS(int source){
		 Graph g = ConstuctGraph.getGraph();
		 return DFS(g);
	 }
	
	 public static Stack<Integer> DFS(Graph g){
		 System.out.println("gouse bsdadaskdjasdjk");
		 isVisited = new boolean[g.v];
		 Stack<Integer> s = new Stack<Integer>();
		 for(int i = 0 ; i< g.v ;i++ ){
			 if(!isVisited[i]){
				 DFSRecursiveCall(s, i, g, isVisited);
			 }
		 }
		 
		 return s;
	 }
	 
	static void DFSRecursiveCall(Stack<Integer> s,int node,Graph g,boolean[] isvisted){
		 
		isvisted[node] = true;
		LinkedList<Edge> list = g.adj[node];
		 for(int i =0 ; i< list.size();i++){
			 Edge edge = list.get(i);
			 if(!isvisted[edge.to]){
				 DFSRecursiveCall(s,edge.to, g, isvisted);
			 }
		 }
		 s.add(node);
	 }
	 
	 
	

	
	
	
	
}
