package com.goustein.graphs.undirected;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UndirectedGraphProbems {
	
	/**
	
	 payload of Traversal
0
6
0 1 2 5
1 0 2 
2 0 1 3 4 
3 2 4 5
4 2 3 
5 0 3

0
10
0 1 2 5
1 0 2 
2 0 1 3 4 
3 2 4 5
4 2 3 
5 0 3
6 7 
7 6
8
9
	
	 */
	
	
	
	public static void main(String[] args) {
	int source  = GraphInitializer.getSource();
	Graph g = GraphInitializer.getGraph();
	 
	  System.out.println("DFS");	
	  Queue<Integer> q = DFS(source, g);
	  printTraversal(q);
	 
	  System.out.println("BFS");
	  q = BFS(source, g);
	  printTraversal(q);
	  
	  //print connected components
	  int cc [] = connetedComponents(g);
	  printTraversal(cc);
	  
	 }
	
	static void printTraversal(Queue<Integer> queue){
		System.out.println(queue);
		
	}
	
	static void printTraversal(int [] queue){
		System.out.println(queue);
	for(int  i = 0;i <queue.length ;i ++){
		System.out.print(queue[i]+" ");
	}
		
	}
	
	
static int[] connetedComponents(Graph g) {
	int[] cc = new int[g.v];
    boolean [] visited =  new boolean[g.v];
	int count = 0;
	
	for(int i = 0; i < g.v ; i++ ){
		if(!visited[i]){
		count++;
		DFSForConnectedComponents(visited, i, cc, g, count);
		}
		
	}
	
	
	
	return cc;
	}
	
	
	
	
	
	
	
	

	static Queue<Integer> BFS(int source ,Graph g){
	
	Queue<Integer> queue = new ArrayDeque<Integer>();
	Queue<Integer> q = new ArrayDeque<Integer>();
	boolean visited[] = new boolean[g.v];
	q.add(source);
	visited[source] = true;
	
	while(!q.isEmpty()){
	 int node = q.remove();
	 queue.add(node);
	 addAllUnvisitedNodesTOQueue(q, g, visited, node);
	}
	
	 return queue;
	}
	
	static void addAllUnvisitedNodesTOQueue(Queue<Integer> q ,Graph g,boolean[] visited,int source)
	{
		LinkedList<Edge> list = g.adj[source];
		for(int i =0 ; i< list.size() ; i++){
			Edge edge = list.get(i);
			if(!visited[edge.to]){
				q.add(edge.to);
				visited[edge.to] = true;
			}
		}
	}
	
 static void DFSForConnectedComponents(boolean visited[], int source,int [] cc,Graph g,int count ){
	 Queue<Integer> q = new ArrayDeque<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		visited[source] = true;
		stack.add(source);
		
		while(!stack.isEmpty()){
			int node = stack.peek();
			int unvisitedchildNode = getUnvisiedNode(node, g, visited);
			
			if(unvisitedchildNode == -1){
				int n = stack.pop();
				q.add(n);
				cc[n] = count;
			}else{
				stack.push(unvisitedchildNode);
				visited[unvisitedchildNode] = true;
			}
		}
			
  }
	
	
	
  static Queue<Integer> DFS(int source, Graph g){
	Queue<Integer> q = new ArrayDeque<Integer>();
	boolean [] visited = new boolean[g.v];
	Stack<Integer> stack = new Stack<Integer>();
	visited[source] = true;
	stack.add(source);
	
	while(!stack.isEmpty()){
		int node = stack.peek();
		int unvisitedchildNode = getUnvisiedNode(node, g, visited);
		
		if(unvisitedchildNode == -1){
			q.add(stack.pop());
		}else{
			stack.push(unvisitedchildNode);
			visited[unvisitedchildNode] = true;
		}
	}
		
	return q; 
  }
  
  
   static int getUnvisiedNode(int node , Graph g,boolean visited[]){
	  
	 LinkedList<Edge> list = g.adj[node];
	 
	 for(int i=0 ; i< list.size() ;i++){
		  Edge edge = list.get(i);
		 if(!visited[edge.to]){
			 return edge.to;
		 }
	 }
	 
	 return -1;
  }

}
