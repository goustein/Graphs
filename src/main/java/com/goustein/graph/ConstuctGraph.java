package com.goustein.graph;

import java.util.Scanner;


/**
  10 // number of vertex;
  10  // number of edges
  1 10 0   // from to weight
  .
  .
  .
  
  
  
  10 // number of vertex;
  10  // number of edges
  1 10 // from to 
  .
  .
  .
  
 */

public class ConstuctGraph {
	static Scanner s = new Scanner(System.in);
	
	public static  Graph getGraph(){
		int v = s.nextInt();
		int edges  = s.nextInt();
		s.nextLine();
		Graph g = new Graph(v);
		for(int i = 0 ; i < edges; i++ ){
		 String[] split = s.nextLine().split("\\s+");
		 // it is  undirect non weight graph
		 if(split.length == 2){
			 int from = Integer.valueOf(split[0]);
			 int to = Integer.valueOf(split[1]);
			 g.addEdge(from, to);
			 
		 }else if(split .length == 3){
			 int from = Integer.valueOf(split[0]);
			 int to = Integer.valueOf(split[1]);
			 int weight = Integer.valueOf(split[2]);
			 g.addEdge(from, to,weight);
		 }	 
		}
		System.out.println("gouse bsha");
		return g;
	}

}
