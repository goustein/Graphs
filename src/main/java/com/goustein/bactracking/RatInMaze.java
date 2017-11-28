package com.goustein.bactracking;

public class RatInMaze {
	
	static int[][] maze;
	static boolean [][] isvisted;
	static int xLength;
	static int yLength;
	static int destX;
	static int destY;
public static void main(String[] args) {
	int startX = 0;
	int startY = 0;
	maze = new int [][]{
		{1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}
	};
	
	destX = 3;
	destY = 3;
	xLength = maze.length;
	yLength = maze[0].length;
	isvisted = new boolean[xLength][yLength];
	
   boolean result =  maze(startX, startY);
    if(result){
    	printPath();
    }
}

static void printPath(){
	for(int i =0 ;i < xLength ;i++){
		for(int j =0 ;j < yLength ;j++){
			System.out.print(isvisted[i][j]+" ");
		}
		System.out.println();
	}
}



static boolean mazeInti(int x, int y){
	if(isValid(x, y)) return maze(x, y);
	return false;
}

  static private boolean maze(int x, int y) {
	if(x == destX && y == destY){
		isvisted[x][y] = true;
		return true;
	}
	isvisted[x][y] = true;
	int [] xCord = getXCord(x);
	int [] ycord = getYCord(y);
	
	for(int i =0 ; i< xCord.length;i++){
		int tempX = xCord[i];
		int tempY = ycord[i];
		
		if(isValid(tempX, tempY)){
			boolean  isPathFound = maze(tempX, tempY);
			if(isPathFound){
				return isPathFound;
			}		
		}
	}
	
	isvisted[x][y] = false;
	return false;
}
  
  
  
 static boolean isValid(int x ,int y){
	  
	  if(x>=0 && x< xLength && y>=0 && y < yLength && maze[x][y] ==1 && !isvisted[x][y]) return true;
	  
	  
	  return false;
	  
  }
  
 static  int[] getXCord(int x){
	  int xcord []= new int[2];
	  xcord[0] = x;
	  xcord[1] = x+1;
	  return xcord;
	  
  }
  
  static int[] getYCord(int y){
	  int yCord[] = new int[2];
	  yCord[0] = y+1;
	  yCord[1] = y;
	  return yCord;
  }


}
