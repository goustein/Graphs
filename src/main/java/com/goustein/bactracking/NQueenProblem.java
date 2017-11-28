package com.goustein.bactracking;

public class NQueenProblem {
	
static int n;
static int [][] isReachable;
static boolean [][] isQueenPlaced;
static int count = 0;

public static void main(String[] args) {
	 
	boolean  areQueensPlaced =  init(8);
	 if(areQueensPlaced) printPath();
}


static void printPath(){
	for(int i =0 ;i < n ;i++){
		for(int j =0 ;j < n ;j++){
			System.out.print(isQueenPlaced[i][j]+" ");
		}
		System.out.println();
	}
}

static public boolean init(int N){
	n = N;
	isReachable = new int [n][n];
	isQueenPlaced = new boolean [n][n];
	for(int i =0 ;i <n ;i++)
		for(int j =0 ;j < n; j++){
			boolean  allPLaced = queenN(i, j);
			if(allPLaced) return allPLaced;
		}
	return false;
}



static boolean isReachable(int x,int y){
	 if(isReachable[x][y] > 0) return false;
	 else return true;
}


 public static boolean  queenN(int x, int y){
	 
	 if(!isReachable(x, y)) return false;
	 
	 
	 isQueenPlaced[x][y]=true;
	 count++;
	 markQueenAttactingPosition(x, y);
	 
	 if(count == n){
		 return true;
	 }
	 
	for(int i =0 ;i <n ;i++)
		for(int j =0 ;j < n; j++){
			if(isReachable(i, j)){
			boolean  allPLaced = queenN(i, j);
			if(allPLaced) return allPLaced;
			}
		}
	 
	 
	 isQueenPlaced[x][y]=false;
	 count--;
	 unmarkQueenAttactingPosition(x, y);
	  
	 return false;
  }


static void markQueenAttactingPosition(int x, int y){
	
	for(int i = 0; i< n ;i++){
		isReachable[x][i]++;
		isReachable[i][y]++;
	}
 int a = 1;
 while(true){
	if(validate(x+a,y+a)){
		isReachable[x+a][y+a]++;
		a++;
	}else{
		break;
	}
 }
	
 a = 1;
 while(true){
		if(validate(x-a,y-a)){
			isReachable[x-a][y-a]++;
			a++;

		}else{
			break;
		}
	 }
    
 a = 1;
 while(true){
		if(validate(x+a,y-a)){
			isReachable[x+a][y-a]++;
			a++;

		}else{
			break;
		}
	 }
    
 a = 1;
 while(true){
		if(validate(x-a,y+a)){
			isReachable[x-a][y+a]++;
			a++;

		}else{
			break;
		}
	 }
}
 
 

static void unmarkQueenAttactingPosition(int x, int y){
	
	for(int i = 0; i< n ;i++){
		isReachable[x][i]--;
		isReachable[i][y]--;
	}
 int a = 1;
 while(true){
	if(validate(x+a,y+a)){
		isReachable[x+a][y+a]--;
		a++;

	}else{
		break;
	}
 }
	
 a = 1;
 while(true){
		if(validate(x-a,y-a)){
			isReachable[x-a][y-a]--;
			a++;

		}else{
			break;
		}
	 }
    
 a = 1;
 while(true){
		if(validate(x+a,y-a)){
			isReachable[x+a][y-a]--;
			a++;

		}else{
			break;
		}
	 }
    
 a = 1;
 while(true){
		if(validate(x-a,y+a)){
			isReachable[x-a][y+a]--;
			a++;

		}else{
			break;
		}
	 }
}



static  boolean validate(int x ,int y){
	if(x >= 0 && x < n && y >=0 && y < n){
		return true;
	}
	
	return false;
}


	
	
	
	

}
