package com.goustein.graphs.directed;

import java.util.LinkedList;
import java.util.Stack;

import com.goustein.graphs.DirectedEdge;
import com.goustein.graphs.EdgeWeightedDAG;

public class TopologicalSortDIrectedGraphs {
	
	
	static Stack<Integer> topStack = new Stack<Integer>();
	static boolean [] isVisted;
	static Stack<Integer> stack = new Stack();
	static boolean [] inStack;

	
	
	public static void main(String[] args) {
		EdgeWeightedDAG g = DiGraphIntializer.getdigraph();
		Stack<Integer> stack = topologicalSort(g);
		System.out.println(stack);
	}
	
	static Stack<Integer> topologicalSort(EdgeWeightedDAG g){
		
		isVisted = new boolean[g.vertex];
		inStack = new boolean[g.vertex];
		if(DirectedGraphCycleCheck.hasCycle(g)){
		System.out.println("Has a cycle");	
		}else{
		
		for(int i =0 ;i < g.vertex ; i++){
			if(!isVisted[i]){
			DFS(i, g);
			}
		}
		}
		
		return topStack;
	}
	
	
	static void  DFS(int source,EdgeWeightedDAG g){
		 isVisted[source] = true;
		 stack.add(source);
		 inStack[source] = true;
		 
		 while(!stack.isEmpty()){
			 int node =stack.peek();
			 
			 int nextUnvistedNode = getUnvistedNode(node, g);
			 
			 if(nextUnvistedNode == -1){
				 int poped =stack.pop();
				 topStack.add(poped);
			 }else{
				 stack.add(nextUnvistedNode);
				 isVisted[nextUnvistedNode] = true;
			 }
			 
		 }
		
	}
	
	
	
	static private int getUnvistedNode(int node, EdgeWeightedDAG g) {
       
		LinkedList<DirectedEdge> list = g.adj[node];
		
		for(int i =0 ; i< list.size() ;i++){
			if(!isVisted[list.get(i).to]) return list.get(i).to;
		}
		
		return -1;
	}


}
