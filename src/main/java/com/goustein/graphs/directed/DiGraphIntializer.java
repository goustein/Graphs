package com.goustein.graphs.directed;

import java.util.Scanner;

import com.goustein.graphs.EdgeWeightedDAG;

public class DiGraphIntializer {
	
	static Scanner s = new Scanner(System.in);
	
  	
 static EdgeWeightedDAG getdigraph(){
	 
	 int v = s.nextInt();
	 s.nextLine();
	 int edgecount = s.nextInt();
	 s.nextLine();
	 EdgeWeightedDAG g = new EdgeWeightedDAG(v);
	 
	 for(int i =0 ; i< edgecount ; i++){
		 String str[]  = s.nextLine().split("\\s+");
		 g.addEdge(Integer.valueOf(str[0]),Integer.valueOf(str[1]),1);
	 }
	 
	
	 return g;
	 
 }

}
