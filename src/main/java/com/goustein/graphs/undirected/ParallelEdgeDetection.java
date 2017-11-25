package com.goustein.graphs.undirected;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;



/**
0
3
0 1 1 2 2
1 0 0 2 2
2 0 0 1 1
 */

public class ParallelEdgeDetection {
	
	
		
	public static void main(String[] args) {
		
		int source  = GraphInitializer.getSource();
		Graph  g = GraphInitializer.getGraph();
		
		System.out.println(modifiedBFS(g, source));
		
	}
	
	static int modifiedBFS(Graph g, int source){
		int count = 0;
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean [] isVisited = new boolean[g.v];
		q.add(source);
		
		while(!q.isEmpty()){
			int node = q.remove();
			if(!isVisited[node]){
			 isVisited[node] = true;
			 count = count +getParallelEdgesCount(g, node, isVisited, q);
			}
		}
	
		return count;
	}
	
	static int getParallelEdgesCount(Graph g, int node , boolean [] isVisited,Queue<Integer> q){
		int count = 0;
		LinkedList<Edge> list = g.adj[node];
		Set<Integer> set = new HashSet<Integer>();
		for(int i =0 ;i< list.size();i++){
			if(!isVisited[list.get(i).to]){
				set.add(list.get(i).to);
				q.add(list.get(i).to);
				++count;
			}
			
		}
		
		
		return count - set.size();
	}
	
}
