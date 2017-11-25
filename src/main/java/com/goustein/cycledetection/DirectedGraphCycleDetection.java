package com.goustein.cycledetection;

import java.util.LinkedList;
import java.util.Stack;

import com.goustein.graph.ConstuctGraph;
import com.goustein.graph.Edge;
import com.goustein.graph.Graph;

public class DirectedGraphCycleDetection {
	
	public static void main(String[] args) {
		Graph g =ConstuctGraph.getGraph();
		hasCycle(g);
		
	}
	
	static boolean isVisited [];
	static boolean hasSelfLoop;
	static boolean inStack[];
	static boolean hasCycle;
	static Stack<Integer> s ;
	 static boolean hasCycle(Graph g){
		 boolean hasCycle = false;
		 isVisited = new boolean[g.v];
		 inStack = new boolean[g.v];
		 int v = g.v;
		 for(int i = 0 ; i< v; i++){
			 if(!isVisited[i]){
				boolean cycle =  hasCycle(i,g);
				if(cycle){
				//		printLoop();
					break;
				}
			 }
		 }	 
		 return hasCycle;
	  }
	
	 
	 private static void printLoop() {
       int source = s.pop();
       Stack<Integer> rs = new Stack<Integer>();
       
       while(true){
    	   int node = s.pop();
    	   if(node == source){
    		   rs.add(node);
    		   break;
    	   }else{
    		   rs.add(node);
    	   }
       }
       
       while(!rs.isEmpty()){
    	   System.out.print(rs.pop()+" ->");
       }
       		
	}


	static boolean hasCycle(int node, Graph g){
		 boolean hasCyclelocal = false;
		  s  = new Stack<Integer>();
		 s.add(node);
		 inStack[node] = true;
		 isVisited[node] = true;
		 while(!s.isEmpty()){
			 int topNode = s.peek();
			 int next = getUnvistedNode(topNode, g);
			 if(hasCycle){
				 hasCyclelocal = true;
				 break;
			 }else if( next == -1){
				 int popedNode = s.pop();
				 inStack[popedNode] = false;
			 }else{
				 s.add(next);
				 isVisited[next] = true;
				 inStack[next] = true;
			 }
		 }
		 return hasCyclelocal;  
	  }
	 
	
	
	static int getUnvistedNode(int node ,Graph g){
		LinkedList<Edge> adjList = g.adj[node];
		 if(adjList.size() != 0){
			 for(int i = 0 ;i< adjList.size() ; i++){
				Edge edge = adjList.get(i);
				 if(inStack[edge.to]){
					hasCycle = true;
					s.add(edge.to);
					break;
				}else if(!isVisited[edge.to]){
					return edge.to;
				}
			 }
		 }
		
		return -1;
	}

}
