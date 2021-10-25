package com.company;

import java.util.ArrayList;
import java.util.Arrays;

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
        Edge e =new Edge(from, to, weight);
        Edge e2=new Edge(to, from, weight);
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
                System.out.println(u.dist);
                MSTtotal += u.dist;
                u.visited = true;
            }
            System.out.println("MST size is: "+MSTtotal);
        }
    }
}

class Vertex implements Comparable<Vertex>{
    String name;
    ArrayList<Edge> OutEdges;
    Integer dist= Integer.MAX_VALUE;
    Vertex prev= null;
    boolean visited = false;
    public Vertex(String id){
        name=id;
        OutEdges=new ArrayList<Edge>();
    }
    public void addOutEdge(Edge e) {
        OutEdges.add(e);
    }


    @Override
    public int compareTo(Vertex o) {
        if (this.dist<o.dist)
            return -1;
        if (this.dist>o.dist)
            return 1;
        return 0;
    }

    public Integer getDist() {
        return dist;
    }

    public void setDist(Integer dist) {
        this.dist = dist;
    }

    public Vertex getPrev() {
        return prev;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
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


    public static void main(String[] args) {
        AdjGraph MyGraph=new AdjGraph();
        Vertex Eskildstrup = new Vertex("Eskildstrup");
        Vertex Maribo = new Vertex("Maribo");
        Vertex NykøbingF = new Vertex( "NykøbingF");
        Vertex Vordingborg = new Vertex("Vordingborg");
        Vertex Haslev = new Vertex("Haslev");
        Vertex Korsør = new Vertex( "Korsør");
        Vertex Køge = new Vertex("Køge");
        MyGraph.addVertex(Eskildstrup);
        MyGraph.addVertex(Maribo);
        MyGraph.addVertex(NykøbingF);
        MyGraph.addVertex(Vordingborg);
        MyGraph.addVertex(Haslev);
        MyGraph.addVertex(Korsør);
        MyGraph.addVertex(Køge);
        MyGraph.addEdge(Eskildstrup,Maribo,28);
        MyGraph.addEdge(Eskildstrup,NykøbingF, 13);
        MyGraph.addEdge(Eskildstrup,Vordingborg,25);
        MyGraph.addEdge(Haslev,Korsør,60);
        MyGraph.addEdge(Haslev,Køge,24);
        MyGraph.addEdge(Haslev,Vordingborg,1);
        MyGraph.addEdge(Haslev,Haslev,1);
        MyGraph.addEdge(Haslev,Køge, 1);
        MyGraph.addEdge(Haslev,NykøbingF, 1);
        MyGraph.addEdge(Haslev,Vordingborg,3);
        MyGraph.addEdge(Haslev,Korsør, 3);
        MyGraph.addEdge(Haslev,Køge,4);
        MyGraph.addEdge(Haslev,Køge, 1);
        MyGraph.PrintGraph();
        MyGraph.MSTPrims();
    }
}

