package com.goustein.cycledetection;

import java.util.ArrayDeque;
import java.util.Queue;

import com.goustein.graph.ConstuctGraph;
import com.goustein.graph.Edge;
import com.goustein.graph.Graph;
import com.goustein.graph.GraphFromEdges;



/**
5
7
0 1 10
0 3 3
0 4 1
1 2 1
2 1 -5
3 1 1
4 3 1
 */

public class BellmanFordAlgo {
	
	
	
	
	
	public static void main(String[] args) {
	Graph g =	ConstuctGraph.getGraph();
	System.out.println(hasNegativecycle(g, 0));
	}
	
	
	
	static int visitedEdges;
	static Edge edgeTO [];
	static  int[] distTO;
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	static boolean hasNegtiveCycle;
	static boolean[] inQ;
	
	static boolean hasNegativecycle(Graph g,int source){
		edgeTO = new Edge[g.v];
		distTO = new int[g.v];
		inQ = new boolean[g.v];
		for(int i = 0;i< g.v ;i++)
			distTO[i] =Integer.MAX_VALUE;
		queue.add(source);
		inQ[source] = true;
		distTO[source] = 0;
		while(!queue.isEmpty() && !hasNegtiveCycle ){
			int node = queue.remove();
			inQ[node] = false;
			relax(node,g);
		}		
		return hasNegtiveCycle;
	}
	private static void relax(int node, Graph g) {
		for(Edge edge : g.adj[node]){
			if(distTO[edge.to] > distTO[node]+edge.weight){
				visitedEdges++;
				edgeTO[edge.to] = edge;
				distTO[edge.to] = distTO[node]+edge.weight;
				
				if(!inQ[edge.to]){
					queue.add(edge.to);
					inQ[edge.to] = true;
				}
				if(visitedEdges%g.v == 0){
					findNegativeCycle();
				}
			}
		}
	}
	private static void findNegativeCycle() {
    		Graph g =GraphFromEdges.getGraph(edgeTO);
    		hasNegtiveCycle = DirectedGraphCycleDetection.hasCycle(g);	
	}

}
