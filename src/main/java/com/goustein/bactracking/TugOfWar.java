package com.goustein.bactracking;

public class TugOfWar {
	
	public static void main(String[] args) {
		int[] arr = new int[]{3, 4, 5, -3, 100, 1, 89, 54, 23, 20}; //diff is 0  
        //int [] arr = new int[]{23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}; // diff is 1
        
		boolean [] firstSubsetElements = getFirstSetElements(arr);
		System.out.println(diff);
		System.out.println();
		printFirstSetNUmbers(arr, firstSubsetElements);
		
		
		
	}
	
	static void printFirstSetNUmbers(int [] arr , boolean [] firstSubsetElements){
		for(int i =0 ;i < arr.length ; i++){
			if(firstSubsetElements[i]){
				System.out.print(arr[i] + " ");
			}
		}
	}
	
	
	static boolean [] getFirstSetElements(int arr[]){
		int k = arr.length/2;
		boolean [] inFirstSubSet = new boolean[arr.length];
		int diff = Integer.MAX_VALUE;
		boolean [] firstSubsetElements = new boolean[arr.length];
		int length = 0;
		recursiveCalculateFirtSetElements(arr, k, inFirstSubSet, firstSubsetElements, length);
		return firstSubsetElements;
		
	}
	
	
	static int diff = Integer.MAX_VALUE; 
	
	static void recursiveCalculateFirtSetElements(int arr[],int k,boolean [] inFirstSubSet, boolean[]firstSubsetElements,int length){
		
		for(int i = 0 ; i< arr.length ; i++){
			if(!inFirstSubSet[i] && length+1 < k ){
				inFirstSubSet[i] = true;
				recursiveCalculateFirtSetElements(arr, k, inFirstSubSet, firstSubsetElements, length+1);
				inFirstSubSet[i] = false;
			}else if(!inFirstSubSet[i] && length+1 == k){
				inFirstSubSet[i] = true;
				int tempDiff =calculateTheDiff(arr, inFirstSubSet);
				if(tempDiff < diff){
					copyBooleanArray(inFirstSubSet, firstSubsetElements);
					diff = tempDiff;
				}
				inFirstSubSet[i] = false;
				
			}
			
		}
		
	}
	    
	
	
	
	
	
	
	static void copyBooleanArray(boolean from[] ,boolean [] to){
		for(int i=0 ;i < from.length;i++){
			to[i] = from[i];	
		}
	}
	
	
	static int calculateTheDiff(int[] arr , boolean [] inFirstSubset){
		int firstSum = 0;
		int secondSum = 0;
		for(int i = 0 ;i < inFirstSubset.length;i++){
			if(inFirstSubset[i]){
				firstSum = firstSum+arr[i];
			}else{
				secondSum = secondSum+arr[i];
			}
		}
		return Math.abs(firstSum-secondSum);
	}
	
	
	
	
	

}
