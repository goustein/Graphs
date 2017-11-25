package com.goustein.graph;

public class Edge {
 public int from;
 public int to;
 public int weight;

public Edge(int from, int to, int weight) {
	super();
	this.from = from;
	this.to = to;
	this.weight = weight;
}
public Edge(int from, int to) {
  this(from, to,1);
}
 
}
