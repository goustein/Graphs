package com.goustein.graphs;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class DAGLongestPath {
	
	static int[][] adjM;
	static int [] weight;
	static Edge [] edgeTO;
	static Scanner s = new Scanner(System.in);
	static int source;
	static int m;
	static int n;
	
	static boolean [] visited ;
	
	static Stack<Integer>  ts =  new Stack<Integer>();
	
	
	public static void main(String[] args) {
		initialize();
		topologialSort(source);
		shortestPath();
		printShortedPaths();
		
	}
	
	static void printShortedPaths(){
		for(int i = 0 ;i< n; i++ ){
			System.out.println("Source :"+source+" path:"+ -1 *weight[i]);
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int f;
		int t ;
		int w;
		public Edge(int f, int t, int w) {
			super();
			this.f = f;
			this.t = t;
			this.w = w;
		}
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return w-o.w;
		}
		
	}
	
	static void shortestPath(){
		
		
		weight[source] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		while(!ts.isEmpty()){
			int node = ts.pop();
			addEdges(node, pq);
			
			while(!pq.isEmpty()){
			Edge edge =	pq.remove();
			
			if( weight[edge.t] > weight[edge.f]+adjM[edge.f][edge.t]){
				weight[edge.t] = weight[edge.f]+adjM[edge.f][edge.t];
				edgeTO[edge.t] = edge;
			}
			  
			}
			
			
		}
		
	}
	
	static void addEdges(int node,PriorityQueue<Edge> pq){
		for(int i =0 ;i < m ; i++){
			if(i != node && adjM[node][i] != 0){
				pq.add(new Edge(node, i,adjM[node][i]));
			}
		}
	}
	
	
	static void topologialSort(int source){
		Stack<Integer> st = new Stack<Integer>();
		visited[source] = true;
		st.add(source);
		
		
		while(!st.isEmpty()){
			int node = st.peek();
			int nextUnvistedNode = getUnvisitedNode(node);
			if(nextUnvistedNode == -1){
				ts.push(node);
				st.pop();
				visited[node] = true;
			}
			else{
				st.push(nextUnvistedNode);
			}
		}
		
	}
	
	
	
	
	private static int getUnvisitedNode(int node) {
		for(int i = 0 ;i< m;i++ ){
			if(i != node && !visited[i] && adjM[node][i] != 0){
				return i ;
			}
		}
		return -1;
	}


	static void initialize(){
		source = s.nextInt();
		m = s.nextInt();
		n = s.nextInt();
		adjM = new int[m][n];
		weight = new int[m];
		edgeTO = new Edge[m];
		for(int k = 0 ;k< weight.length ;k++){
			weight[k] = Integer.MAX_VALUE;
		}
		visited = new boolean[m];
		for(int i=0 ;i< m; i++ ){
			for(int j=0;j<n;j++){
				adjM[i][j] = -1 * s.nextInt();
			}
		}
		
	}
  
}
