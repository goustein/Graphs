package com.goustein.graphs;

import java.util.PriorityQueue;
import java.util.Scanner;

import com.goustein.graphs.MST.Edge;

public class DijkstraAlgo {
	static int[][] adjM;
	static int cost[];
	static int edgeTO[]; 
	static PriorityQueue<Edge> pq;
	static int m;
	static int n;
	static Scanner s = new Scanner(System.in);
	static int source ;
	static int visitedCount;
	
	
	static class Edge implements Comparable<Edge>{
		int f; // from
		int t; // to
		int w; // weight
		public Edge(int f, int t, int w) {
			super();
			this.f = f;
			this.t = t;
			this.w = w;
		}
       public int compareTo(Edge o) {
			return w-o.w;
		}
	}

	public static void main(String[] args) {
		
		intialize();
		
		djkstrasAlgo(source);
		printTotalWeigth();
	}
	
	
	static void  printTotalWeigth(){
		for (int i = 0; i < cost.length; i++) {
			System.out.println(s+"->"+ i +":"+cost[i]);
		}
		
	}
	
	
	static void djkstrasAlgo(int source){
		
		addNodesReachable(source);
		
		while(!pq.isEmpty()){
			Edge edge = pq.remove();
			if(isPartOfPath(edge)){
				addNodesReachable(edge.t);
			}
			
}
		}
		
	 static boolean isPartOfPath(Edge edge){
		 
		 if(cost[edge.t] > cost[edge.f]+edge.w){
			 cost[edge.t] = cost[edge.f]+edge.w;
			  edgeTO[edge.t] = edge.f;		 
			 return true;
		 }
		 
		 return false;
		 
	  }
	
	
	static void addNodesReachable(int node){
		for(int i =0 ;i<m ; i++){
			if(adjM[node][i] > 0){
				pq.add(new Edge(node, i,adjM[node][i]));
			}
		}
	}
	
	

   static void intialize(){
	source =s.nextInt();
	m =s.nextInt();
	n = s.nextInt();
	adjM = new int[m][n];
	for(int i =0 ;i < m; i++ )
	 for(int j=0 ;j <n;j++)
		 adjM[i][j] = s.nextInt();

  
     pq =new PriorityQueue<Edge>();
     cost = new int[m];
     
     for (int k = 0; k < cost.length; k++) {
    	
    	 cost[k] = Integer.MAX_VALUE;
		
	}
     //set the source cost to zero ;
     cost[source] = 0;
     
     // set 
 	 edgeTO = new int[m];
	}
	
}
