package com.goustein.graphs.undirected;

import java.util.LinkedList;
import java.util.Stack;

/**
//both euler circle and path
0
5
0 1 2 3
1 0 2
2 0 1 
3 0 4
4 0 3

euler path:

0
5
0 1 2 3
1 0 2
2 0 1 
3 0 4
4 3
 
 */

public class EulerCycleAndPath {
	
	public static void main(String[] args) {
		int source = GraphInitializer.getSource();
		Graph g = GraphInitializer.getGraph();
		
		checkEulerCircleAndPath(g, source);
		System.out.println("Euler path:"+hasEulerPath);
		System.out.println("Euler circle:"+hasEulerCircle);
	}

static int edgeCount;
static int vertexCount;
static boolean hasEulerPath;
static boolean hasEulerCircle;
static boolean [] isVisited;
 
  static void checkEulerCircleAndPath(Graph g,int source){
	  
	  Stack<Integer> stack   =  new Stack<Integer>();
	  vertexCount++;
	  stack.add(source);
	  int lastPoped = -1;
	  
	  if(g.adj[source].size() < 2){
		  return;
	  }
	  
	  while(!stack.isEmpty()){
		  int node = stack.pop();
		  lastPoped = node;
		  int unvistedNode = getUnvistedEdge(g, node);
		  if(unvistedNode == -1){
			  break;
		  }
		  stack.add(unvistedNode);
	  }
	  
	  if(edgeCount == g.edges){
		  hasEulerPath= true;
		  if(source == lastPoped){
			  hasEulerCircle = true;
		  }
		  
	  }
	  
	  
  }
   
static int getUnvistedEdge(Graph g , int node){
	LinkedList<Edge> edge = g.adj[node];
	for(int i = 0 ;i< edge.size(); i++){
		if(!edge.get(i).isVisited){
			edge.get(i).isVisited = true;
			edgeCount++;
			markedgeAsVisited(edge.get(i).to,node,g);
			return edge.get(i).to;
		}
	}
	return -1;
}
 static void markedgeAsVisited(int from, int to ,Graph g){
	 
	 LinkedList<Edge> list =g.adj[from];
	 for(int i =0 ;i <list.size();i++){
		 if(list.get(i).to == to){
			 list.get(i).isVisited = true;
			 edgeCount++;
		 }
	 }
	 
 }
	
}
