package com.goustein.dfsandbfs;

import java.util.Stack;

public class TopologicalSort {

	
	
	public static Stack<Integer> topologicalSort(int graph){
		return DFSRecursive.DFS(0);
	}
}
