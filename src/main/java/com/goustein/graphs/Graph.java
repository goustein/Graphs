package com.goustein.graphs;

import java.util.Scanner;

public class Graph {
	
	private static int [][] adjM;
	
	static boolean isTCal [] ;
	
	static  int[] reachableCount ;
	
	static boolean visited[] ;
	
	static int m ;
	static int n ;
	
 public static void main(String[] args) {
	Scanner s  = new Scanner(System.in);
      m =  s.nextInt();
	  n = s.nextInt();

	adjM = new int [m][n];
	isTCal = new boolean[m];
	reachableCount = new int[m];
	visited =  new boolean[m];
	
	for(int i = 0 ;i<m;i++){
	 for(int j = 0 ;j < n;j++){
		 adjM[i][j] = s.nextInt();
	 }
	}
	CalculateTrasitive();

	display(adjM, m, n);
	displayReachableVertices();
	
	
}
   static void displayReachableVertices(){
	   for (int i = 0; i < reachableCount.length ; i++) {
		   System.out.println(" vertex:"+i+" count:"+reachableCount[i]);
		
	}
   }
 
    
  static void CalculateTrasitive(){
	  
    for(int node = 0; node < m ; node++){
      if(!isTCal[node]){
    	  calculateTransitive(node);
      }    	
    }
	   
   }
 
 
 static void calculateTransitive(int node){
	 
	 for(int i =0 ;i< n ;i++){
		 if(adjM[node][i] == 1 && i != node){
			 reachableCount[node] = reachableCount[node]+1;
			 if(isTCal[i]){
				 merge(i,node);
			 }else{
				 calculateTransitive(i);
				 merge(i,node);
			 }
			 
		 }
	 }
	 
	 isTCal[node] = true;
	 
 }
 
 
 static void merge (int from , int to){
	 for(int i =0 ; i< n ; i++){
		 if(adjM[from][i] == 1 && adjM[to][i] == 0){
			 reachableCount[to] = reachableCount[to]+1;
			 adjM[to][i]=1 ;
		 }
	 }
	 
	 
 }
 
 
 public static void display(int adj[][],int m,int n){
	 
	 
	 for(int i = 0 ;i<m;i++){
		 for(int j = 0 ;j < n;j++){
			System.out.print(adjM[i][j]+" ");
		 }
		 System.out.print("\n");
		}
	 
	 
 }
 
 
 
}
