package com.goustein.graphs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BellmanFordSP {

	
	static int source;
	
	static EdgeWeightedDAG g;
	static int vertexCount ;
	static Scanner  s = new Scanner(System.in);
	static int [] distTO;
	static DirectedEdge edgeTO[];
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	static boolean inQ[];
	
	
	public static void main(String[] args) {
		initialize();
		BFAlog();
		printWeigth();
	}
	
	static void printWeigth(){
		for(int i =0 ;i <vertexCount ; i++){
			System.out.println(i+" : "+distTO[i]);
		}
	}
	static void BFAlog(){
		distTO[source] = 0;
		queue.add(source);
		inQ[source] = true;
		
		while(!queue.isEmpty()){
			int node = queue.remove();
			inQ[node] = false;
			LinkedList<DirectedEdge> list = g.adj[node];
			
			for(int i =0; i< list.size() ;i++){
				DirectedEdge edge = list.get(i);
				
				if(distTO[edge.to] > distTO[edge.from]+edge.weight){
					
					distTO[edge.to] = distTO[edge.from]+edge.weight;
					edgeTO[edge.to] = edge;
					if(!inQ[edge.to]){
						queue.add(edge.to);
						inQ[edge.to] = true;
					}	
				}
				
		
			}
			
		}
		
		
	}
	
	public static void initialize(){
		source = s.nextInt();
		vertexCount = s.nextInt();
		distTO = new int[vertexCount];
		for(int k =0 ; k <vertexCount ;k++){
			distTO[k]=Integer.MAX_VALUE;
		}
		edgeTO = new DirectedEdge[vertexCount];
		inQ = new boolean[vertexCount];
		
		g = new EdgeWeightedDAG(vertexCount);
		for(int i =0 ; i< vertexCount ; i++){
			for(int j =0 ;j <vertexCount ; j++){
				int w = s.nextInt();
				if(w != 0)
				g.adj[i].add(new DirectedEdge(i,j,w));
			}
		}
		
		
		
		
	}
}
