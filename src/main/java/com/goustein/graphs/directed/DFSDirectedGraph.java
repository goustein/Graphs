package com.goustein.graphs.directed;

import java.util.LinkedList;
import java.util.Stack;

import com.goustein.graphs.DirectedEdge;
import com.goustein.graphs.EdgeWeightedDAG;

public class DFSDirectedGraph {
/**
 
 	
13
22
4 2
2 3
3 2
6 0
0 1
2 0
11 12
12 9
9 10
9 11
8 9
10 12
11 4
4 3
3 5
7 8
8 7
5 4
0 5
6 4
6 9
7 6 
	
 */
	static boolean isVisited[];
	static int[] edgeTO;
	
	public static void main(String[] args) {
		EdgeWeightedDAG g = DiGraphIntializer.getdigraph();
		int source = 0;
		DFS(source, g);
		System.out.println(isVisited);
		printVisted();
	}
	
	
	static void printVisted(){
		for(int i =0 ; i< isVisited.length ;i++){
			System.out.println(i +":"+isVisited[i]);
		}
	}

	static void DFS(int source,EdgeWeightedDAG g){
		Stack<Integer> stack = new Stack<Integer>();
		isVisited = new boolean[g.vertex];
		edgeTO = new int[g.vertex];
		stack.add(source);
		isVisited[source] = true;
		
		while(!stack.isEmpty()){
			
			int node = stack.peek();
			
			int unvistedNode = getUnvistedNode( node, g);
			
			if(unvistedNode == -1){
				stack.pop();
			}else{
				stack.add(unvistedNode);
				isVisited[unvistedNode] = true;
			}
		}
		
		
	}
	
	

	private static int getUnvistedNode(int node, EdgeWeightedDAG g) {
		
		LinkedList<DirectedEdge> list = g.adj[node];
		
		for(int i =0 ;i < list.size() ; i++){
			if(!isVisited[list.get(i).to]){
				return list.get(i).to;
			}
		}
		
		
	return -1;
	}

	
}
