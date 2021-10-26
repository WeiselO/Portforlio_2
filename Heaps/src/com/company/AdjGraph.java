package com.company;
import java.util.ArrayList;

public class AdjGraph {
    ArrayList<Vertex> vertices;
    public AdjGraph(){
        vertices=new ArrayList<Vertex>();
    }
    public void addVertex(Vertex v){
        vertices.add(v);
    }
    public void addEdge(Vertex from,Vertex to, Integer weight){
        if(!(vertices.contains(from) && vertices.contains(to)) ) {
            System.out.println("Vertex not in graph");
            return;
        }
        Edge edgeFromTo = new Edge(from, to, weight);
        Edge edgeToFrom = new Edge(to, from, weight);
    }

    public  void PrintGraph(){
        for (int i=0;i<vertices.size();i++){
            System.out.println(" From Vertex: "+ vertices.get(i).name);
            Vertex currentfrom=vertices.get(i);
            for(int j=0; j<currentfrom.OutEdges.size();j++){
                Edge currentEdge=currentfrom.OutEdges.get(j);
                System.out.println(" To: "+ currentEdge.to.name + " weight: "+currentEdge.weight);
            }
            System.out.println(" ");
        }
    }

    public void MSTPrims() {
        MinHeap<Vertex> Q = new MinHeap<>();
        for (int vertex = 0; vertex < this.vertices.size(); vertex++) {
            vertices.get(vertex).setDist(Integer.MAX_VALUE);
            vertices.get(vertex).setPrev(null);
            vertices.get(vertex).visited = false;
            Q.insert(vertices.get(vertex));
        }
        if (vertices.size() > 0){
            int start = 0;
            vertices.get(start).setDist(0); //starting at 0.
            int position = Q.getPosition(vertices.get(start)); //getting the position of the starting vertex
            Q.decreaseKey(position); //Fixing the minheap since we changed the value of the starting vertex.
            int MSTtotal = 0;
            System.out.println("Minimum Spanning Tree:");
            while (!Q.isEmpty()){
                Vertex u = Q.extractMin(); //Taking the smallest u.
                for (int uOutEdgeIndex = 0; uOutEdgeIndex < u.OutEdges.size(); uOutEdgeIndex++) {
                    Edge uOutEdge = u.OutEdges.get(uOutEdgeIndex);
                    if (uOutEdge.weight < uOutEdge.to.dist && u.visited == false){
                        uOutEdge.to.setDist(uOutEdge.weight);
                        uOutEdge.to.setPrev(u);
                        int pos = Q.getPosition(uOutEdge.to);
                        Q.decreaseKey(pos);
                    }
                }
                if (u.prev != null){
                    System.out.println("Distance from "+u.prev.name+" to "+u.name+" is "+u.dist+" km.");
                }
                MSTtotal += u.dist;
                u.visited = true;
            }
            System.out.println("MST size is: "+MSTtotal+" km.");
            System.out.println("MST price is: "+ MSTtotal*100000 +"DKK");
        }
    }
}

class Edge{
    Integer weight;
    Vertex from;
    Vertex to;
    public Edge(Vertex from, Vertex to, Integer cost){
        this.from=from;
        this.to=to;
        this.weight=cost;
        this.from.addOutEdge(this);
    }
}

