package com.goustein.bactracking;

public class KnightTourProblem {
	
	

	
public static void main(String[] args) {
	knightTourPath(0,7);
	printChessBoard();
	
}
  static void printChessBoard(){
	for(int i =0 ;i < 8 ; i++){
		for(int j =0 ; j < 8; j++){
			System.out.print(arr[i][j]+"   ");
		}
		System.out.println();
	}
}


static int count = 0; 
static int arr[][] = new int[8][8];
static boolean[][] isVisited = new boolean[8][8];
	
  static void knightTourPath(int x,int y){
	 // System.out.println(x+ "   "+y);
		isVisited[x][y] = true;
		arr[x][y] = count++;
		int[] xCord = generateNextXCordianted(x);
		int[] yCord = generateNextYCordinates(y);
		
		for(int i = 0 ; i< 8;i++){
			if(isvalidCordinates(xCord[i], yCord[i]) && !isVisited[xCord[i]][yCord[i]]){
				knightTourPath(xCord[i],yCord[i]);			
			}
		}

		if(count < 64){
			isVisited[x][y] = false;
			count--;
		}
 }
  
	
	
 static int [] generateNextXCordianted(int x){
	 // first generate the x-1,x-1, x+1,x+1,x+2,x+2,x-2,x-2
	 int [] cord = new int[8];
	 cord[0] = x-1;
	 cord[1] = x-1;
	 cord[2] = x+1;
	 cord[3] = x+1;
     cord[4] = x+2;
     cord[5] = x+2;
     cord[6] = x-2;
     cord[7] = x-2;
     
     return cord;
 }
 
 static int[] generateNextYCordinates(int y ){
	 //first generate sequence;
	 // y+2,y-2,y+2,y-2,y+1,y-1,y+1,y-1;
	 int [] cord = new int[8];
	 cord[0] = y+2;
	 cord[1] = y-2;
	 cord[2] = y+2;
	 cord[3] = y-2;
     cord[4] = y+1;
     cord[5] = y-1;
     cord[6] = y+1;
     cord[7] = y-1;
     return cord;
 }
	
   static boolean isvalidCordinates(int x, int y){

	   if(x >= 0 && x <= 7 && y >= 0 && y <= 7){
		   return true;
	   }
	   return false;
    }
 

}
