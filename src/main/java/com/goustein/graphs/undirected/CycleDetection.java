package com.goustein.graphs.undirected;

import java.util.LinkedList;
import java.util.Stack;

import com.goustein.graphs.EdgeWeightedDAG;

public class CycleDetection {
static Graph g;


/**
 * 
noncyclic 

0
3
0 1  
1 0 2 
2 1 



cyclic 

0 
3
0 1 2 
1 0 2 
2 0 1
 */
	
	
public static void main(String[] args) {
	int source = GraphInitializer.getSource();
	Graph g = GraphInitializer.getGraph();
	
	System.out.println(isGraphAcyclic(g, source));
	
}	


 static boolean isGraphAcyclic(Graph g,int source){
	boolean[] inStack = new boolean[g.v];
	boolean isVisted [] = new boolean[g.v];
	Edge[] edge = new Edge[g.v];
	int[] edgeTO = new int [g.v];
	for(int k=0 ;k < g.v ;k++)
		edgeTO[k] = -1;
	
	Stack<Integer> s = new Stack();
	isVisted[source] = true;
	s.add(source);
	inStack[source] = true;
	while(!s.isEmpty()){
	 int node = s.peek();
	 boolean isCyclic = anyOfItsChildINStack(g, node, inStack,edgeTO);
	
	 if(isCyclic){
		 return true;
	 }
	 
	 int nextUnvistedNode = unvistedNode(node, g, isVisted);
	 if(nextUnvistedNode == -1){
		int poped =  s.pop();
		 inStack[poped] = false;
	 }else{
		 edgeTO[nextUnvistedNode] = node;
		 s.add(nextUnvistedNode);
		 inStack[nextUnvistedNode] = true;
		 isVisted[nextUnvistedNode] = true;
	 }
	 
	}
	
	
	
	return false;
}

 static int unvistedNode(int node,Graph g,boolean isVisited []){
	 
	 LinkedList<Edge> list = g.adj[node];
	 for(int i =0;i < list.size();i++){
		 if(!isVisited[list.get(i).to]){
			 return list.get(i).to;
		 }
	 }
	 
	 return -1;
 }
 
 
static boolean anyOfItsChildINStack(Graph g , int node,boolean [] inStack, int [] edgeTO){
	
	LinkedList<Edge> list = g.adj[node];
	for(int i =0 ;i < list.size();i++){
		if(list.get(i).to != edgeTO[node] && inStack[list.get(i).to] ){
			return true;
		}
	}
	
	return false;
}

}
