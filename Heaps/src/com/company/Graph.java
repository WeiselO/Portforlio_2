package com.company;
// Adjacency Matrix representation in Java

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private int numVertices;
    private int adjMatrix[][];

    // Initialize the matrix
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int [numVertices][numVertices];
    }

    public void addEdge(int from, int to, int weight){
        adjMatrix[from][to] = weight;
        adjMatrix[to][from] = weight;
    }

    public void removeEdge(int from, int to){
        adjMatrix[from][to] = 0;
        adjMatrix[to][from] = 0;
    }

    public void print(){
        for (int from = 0; from < adjMatrix.length; from++) {
            for (int to = 0; to < adjMatrix.length; to++) {
                if(adjMatrix[from][to]>0){
                    System.out.println("Edge from: "+ from +" to "+ to +" is weight:"+adjMatrix[to][from]+"");
                }
            }
        }

    }

    public void MSTPrims(){
        int[] distance = new int[adjMatrix.length];
        int[] prev = new int[adjMatrix.length];
        MinHeap<Pair> Q = new MinHeap<>();
        ArrayList<Pair> vertexPairs = new ArrayList<>();

        Arrays.fill(distance, Integer.MAX_VALUE); //Making all distances infinite.
        Arrays.fill(prev,-1); //Making a start value for prev
        if (adjMatrix.length>0) distance[0] = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            vertexPairs.add(new Pair(distance[i],i)); //Inserting the pairs into an array
            Q.insert(vertexPairs.get(i)); //adding the pairs to the MinHeap.
        }
        int MST = 0;
        while(!Q.isEmpty()){
            Pair u = Q.extractMin();
            for (int v = 0; v < adjMatrix.length; v++) {
                if (adjMatrix[u.index][v]==1 && adjMatrix[u.index][v]<distance[v]){
                    distance[v]=adjMatrix[u.index][v];
                    prev[v]=u.index;
                    int pos = Q.getPosition(vertexPairs.get(v));
                    vertexPairs.get(v).distance=adjMatrix[u.index][v];
                    Q.decreaseKey(pos);
                }
                
            }
            MST+=distance[u.index];
        }
        System.out.println("Minimum spanning tree");
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.println("parent: "+prev[i]+" to "+i+" has distance: "+distance[i]);
        }


    }

    class Pair implements Comparable<Pair>{
        Integer distance;
        Integer index;

        public Pair(Integer distance, Integer index){
            this.distance = distance;
            this.index = index;

        }
        @Override
        public int compareTo(Pair p){
            return this.distance.compareTo(p.distance);
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(7);
        graph.addEdge(0,1,1);
        graph.addEdge(0,4,3);
        graph.addEdge(0,2,5);
        graph.addEdge(1,4,1);

        graph.print();
    }

}

