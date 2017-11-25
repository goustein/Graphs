package com.goustein.dfsandbfs;

import java.util.LinkedList;

import com.goustein.graph.ConstuctGraph;
import com.goustein.graph.Edge;
import com.goustein.graph.Graph;



/*


9
32
0 1
0 2
1 0 
1 2
1 5
2 0 
2 1
2 5
2 4
2 3
2 6
3 4
3 2
3 6
3 7
4 2
4 6
4 3
4 7
5 1
5 2
5 6
5 8
6 2
6 4
6 3
6 7
7 4
7 3
7 6
8 5
8 6
 */

public class KCoresOfUndirectedGraph {
	
	public static void main(String[] args) {
		Graph g = KcoreGraph();
		for(int i = 0;i <g.v ; i++){
			if(g.adj[i].size() > 0){
				System.out.print(i+" :");
				LinkedList<Edge> list  = g.adj[i];
				for(int j = 0 ; j <list.size(); j++ ){
					System.out.print(list.get(j).to+" -> ");
				}
				System.out.println();
			}
		}
	}
	 static int delV = 0;
	 static boolean isDeleted[];
	 static int edgeCount[];
	
	static Graph KcoreGraph(){
		Graph g = ConstuctGraph.getGraph();
		edgeCount = new int[g.v];
		isDeleted = new boolean[g.v];
		// now i have all the edge counts
		for(int i= 0 ; i< g.v ; i++){
			edgeCount[i] = g.adj[i].size();
		}
		
		int core = 3;
		int prevdelV = delV;
		boolean execute = true;
		
		// find the node whose edge is less than 3 and avoid already  nodes
		while(execute){
			execute = false;
			for(int j =0 ; j <g.v ; j++){
				if(!isDeleted[j] && g.adj[j].size() == 0){
					System.out.println("disconnected graph");
					execute = false;
					break;
				}else if(!isDeleted[j] && g.adj[j].size() < core){	
					delteEdgesAndEdgesOFitsChildren(j, g);
				}
			}
			if(prevdelV < delV){
				execute = true;
				prevdelV = delV;
			}
		}
		
		return g;
	}
	
	static void delteEdgesAndEdgesOFitsChildren(int from,Graph g){
	   isDeleted[from] = true;
	   delV++;
	   LinkedList<Edge> list = g.adj[from];
	   for(int j =0 ; j< list.size(); j++ ){
		   Edge edge = list.get(j);
		   LinkedList<Edge> newList = new LinkedList<Edge>();
		   LinkedList<Edge> oldList = g.adj[edge.to];
 		   for(int i = 0 ; i< oldList.size(); i++  ){
 			   Edge oldEdge= oldList.get(i);
 			   if(oldEdge.to != from){
 				  newList.add(oldEdge); 
 			   }
 		   }
		   g.adj[edge.to] = newList;
	   }
	   g.adj[from].clear();
	}
	
	
	

}
