package com.goustein.bactracking;

import java.time.chrono.IsoChronology;
import java.util.LinkedList;
import java.util.Stack;

import com.goustein.graph.ConstuctGraph;
import com.goustein.graph.Edge;
import com.goustein.graph.Graph;


/**
10
30
0 1 
0 2
0 5
1 0
1 6
1 3
2 0 
2 4
2 7
3 1
3 9
3 4
4 3
4 2
4 8
5 0
5 8
5 9
6 1
6 7
6 8
7 2
7 6
7 9
8 4
8 5
8 6
9 3
9 5
9 7


o/p:  true
 */

public class McoloringProblem {
	
	static int maxColour;
	static boolean [] isVisted ;
	static int [] colorUsed;
	static boolean [] colorsUsedByAdjacentNodes;
	public static void main(String[] args) {
		Graph g = ConstuctGraph.getGraph();
		System.out.println(init(g, 0,3));
	}
	
	
	
	static boolean init(Graph g, int source,int m){
		
	maxColour = m;
	isVisted = new boolean[g.v];
	colorUsed = new int[g.v];
	for(int i = 0 ; i< g.v ; i++) colorUsed[i] = -1;
	return coloring(g, 0);
	}
	
	public static boolean coloring(Graph g, int node){
		isVisted[node] = true;
		boolean [] colors = getColorsUsedByvisitedNeighbourNode(g, node);
		for(int i = 0 ; i< colors.length ; i++){
			if(!colors[i]){
				colorUsed[node] = i;
				int unvistedNode = getNextUnvisitedNode(g, node);
				if(unvistedNode == -1){
					return true;
				}else{
			       boolean result =  coloring(g, unvistedNode);
			       if(result) return result;
				}
				
				
			}
		}
		
		isVisted[node] = false;
		colorUsed[node] = -1;
		return false;
		
	}
		
	private static  int getNextUnvisitedNode(Graph g, int node) {
		
		LinkedList<Edge> list  = g.adj[node];
		for(int i = 0 ; i< list.size();i++){
			Edge e = list.get(i);
			if(!isVisted[e.to]){
			return  e.to;
			}
		}
		
	 return -1;
	}



	
	
	
  static  boolean[] getColorsUsedByvisitedNeighbourNode(Graph g , int node){
		boolean [] colorsUsed  = new boolean[maxColour];
		
		LinkedList<Edge> list  = g.adj[node];
		for(int i = 0 ; i< list.size();i++){
			Edge e = list.get(i);
			if(isVisted[e.to]){
				colorsUsed[colorUsed[e.to]] = true;
			}
		}
		
		
		return colorsUsed;
	}

}
