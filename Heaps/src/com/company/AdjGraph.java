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
        Vertex a = new Vertex("0");
        Vertex b = new Vertex("1");
        Vertex c = new Vertex( "2");
        Vertex d = new Vertex("3");
        Vertex e = new Vertex("4");
        Vertex f = new Vertex( "5");
        Vertex g = new Vertex("6");
        MyGraph.addVertex(a);
        MyGraph.addVertex(b);
        MyGraph.addVertex(c);
        MyGraph.addVertex(d);
        MyGraph.addVertex(e);
        MyGraph.addVertex(f);
        MyGraph.addVertex(g);
        MyGraph.addEdge(a,b,1);
        MyGraph.addEdge(a,c, 5);
        MyGraph.addEdge(a,e,3);
        MyGraph.addEdge(b,e,1);
        MyGraph.addEdge(b,f,7);
        MyGraph.addEdge(c,d,1);
        MyGraph.addEdge(d,e,1);
        MyGraph.addEdge(d,g, 1);
        MyGraph.addEdge(e,c, 1);
        MyGraph.addEdge(e,d,3);
        MyGraph.addEdge(e,f, 3);
        MyGraph.addEdge(e,g,4);
        MyGraph.addEdge(f,g, 1);
        MyGraph.PrintGraph();
        MyGraph.MSTPrims();
    }
}

