package com.goustein.graphs.directed;

import java.util.LinkedList;
import java.util.Stack;

import com.goustein.graphs.DirectedEdge;
import com.goustein.graphs.EdgeWeightedDAG;


/**

	
7
6
0 1
1 2
2 3
4 5
5 6
6 3
 */

public class DirectedGraphCycleCheck {
	
	static boolean [] isVisted;
	static Stack<Integer> stack = new Stack();
	static boolean [] inStack;
	
	
	
	public static void main(String[] args) {
		EdgeWeightedDAG g = DiGraphIntializer.getdigraph();
		
		System.out.println(hasCycle(g));
	}
	
	
	static boolean hasCycle(EdgeWeightedDAG g){
		isVisted = new boolean[g.vertex];
		inStack = new boolean[g.vertex];
		for(int i =0 ;i < g.vertex ; i++){
			if(!isVisted[i]){
				boolean b = DFS(i, g);
				if(b ){
					return b;
				}
			}
		}
		
		return false;
	}
	
	static boolean DFS(int source,EdgeWeightedDAG g){
		 isVisted[source] = true;
		 stack.add(source);
		 inStack[source] = true;
		 
		 while(!stack.isEmpty()){
			 int node =stack.peek();
			 boolean cycle = isInStack(node, g);
			 if(cycle){
				 return true;
			 }
			 
			 int nextUnvistedNode = getUnvistedNode(node, g);
			 
			 if(nextUnvistedNode == -1){
				 int poped =stack.pop();
				 inStack[poped] = false;
			 }else{
				 stack.add(nextUnvistedNode);
				 inStack[nextUnvistedNode] = true;
				 isVisted[nextUnvistedNode] = true;
			 }
			 
		 }
		
		
		return false;
	}
	
	
	
	static private int getUnvistedNode(int node, EdgeWeightedDAG g) {
        
		LinkedList<DirectedEdge> list = g.adj[node];
		
		for(int i =0 ; i< list.size() ;i++){
			if(!isVisted[list.get(i).to]) return list.get(i).to;
		}
		
		return -1;
	}


	static boolean isInStack(int node,EdgeWeightedDAG g){
		
		LinkedList<DirectedEdge> list = g.adj[node];
		
		for(int i = 0 ;i<list.size();i++){
			if(isVisted[list.get(i).to] && inStack[list.get(i).to]){
				return true;
			}
		}
		
		
		
		return false;
	}

}
