package com.goustein.graphs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class LongestPathEdgeWeightDAG {
	
	static EdgeWeightedDAG g ;
    static Stack<Integer> stack;
    static DirectedEdge[] edgeTO;
    static int [] sPath;
    static PriorityQueue<DirectedEdge> pq =  new PriorityQueue<DirectedEdge>(new Comparator<DirectedEdge>() {

		public int compare(DirectedEdge o1, DirectedEdge o2) {
			
			return o1.weight -o2.weight;
		}
	});
    
    
    static DirectedEdge[] getLongestPath(EdgeWeightedDAG g,int s){
    	 edgeTO = new DirectedEdge[g.vertex];
    	 sPath = new int[g.vertex];
    	 LongestPathEdgeWeightDAG.g = g;
    	 
    	 for(int i =0;i< g.vertex;i++ ){
    		 sPath[i] = Integer.MAX_VALUE;
    	 }
    	 sPath[s] = 0;
    	 
    	stack = TopologicalSortingDAG.getTopologicalSort(g,s);
    	changeWeightsTONegative();
    	calculateLongestPath();
    	printLongestWeight();
     return edgeTO;
     }
    
    static void changeWeightsTONegative(){
    	for(int i =0 ;i< g.vertex;i++){
    		LinkedList<DirectedEdge> list = g.adj[i];
    		for(int j =0 ;j < list.size(); j++){
    			DirectedEdge edge = list.get(j);
    			edge.weight = -1 * edge.weight;
    		}
    	}
    }
    
   static void printLongestWeight(){
    	for(int i =0 ; i< sPath.length;i++){
    		System.out.println(i+":"+" "+sPath[i]);
    	}
    }

   static void calculateLongestPath(){
    	
	 while(!stack.isEmpty()){
		int node = stack.pop();
		addAllEdgeTOPQ(node);
		 while(!pq.isEmpty()){
			 calculatedAndShortedPath(pq.remove());
		 }
	 }
	   
	 
    }
   
   static void calculatedAndShortedPath(DirectedEdge e){
	   if( sPath[e.to] > sPath[e.from]+e.weight){
		   edgeTO[e.to] = e;
		   sPath[e.to] = sPath[e.from]+e.weight;
	   }
	   
   }

 static void  addAllEdgeTOPQ(int node){
	 LinkedList<DirectedEdge> list=g.adj[node];
	 
	 for(int i =0 ;i < list.size();i++){
		 pq.add(list.get(i));
	 }
	 
	   
   }
   
   

}
