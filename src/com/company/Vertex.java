package com.company;
import java.util.ArrayList;

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
    public void setDist(Integer dist) {
        this.dist = dist;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
    }
}
