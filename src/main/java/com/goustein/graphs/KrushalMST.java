package com.goustein.graphs;

import java.util.PriorityQueue;
import java.util.Scanner;

import com.goustein.graphs.MST.Edge;

public class KrushalMST {
	
	static int[][] adjM;
	static boolean visited[];
	static int totalWeight = 0;
	static int weight[];
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
		int source =s.nextInt();
		intialize();
		
		mst(source);
		
		System.out.println(totalWeight);
	}
	
	
	static void mst(int source){
		
		visited[source] = true;
		addUnVistedNode(source);
		
		visitedCount++;
		
		while(!pq.isEmpty() && visitedCount < m ){
			Edge e = pq.remove();
			if(!visited[e.t]){
			edgeTO[e.t] = e.f;
			visited[e.t] = true;
			visitedCount++;
			totalWeight = totalWeight + e.w;
			addUnVistedNode(e.t);
			}
		}
		
	}
	
	static void addUnVistedNode(int node){
		for(int i =0 ;i<m ; i++){
			if(visited[i] == false && adjM[node][i] > 0){
				pq.add(new Edge(node, i,adjM[node][i]));
			}
		}
	}
	
	

   static void intialize(){
	m =s.nextInt();
	n = s.nextInt();
	adjM = new int[m][n];
	for(int i =0 ;i < m; i++ )
	 for(int j=0 ;j <n;j++){
		 int w = s.nextInt();
		 if(w > 0){
			 pq.add(new Edge(i,j, w));
		 }
	 }

     visited = new boolean [m];
     pq =new PriorityQueue<Edge>();
     weight = new int[m];
 	edgeTO = new int[m];
	}
	

}
