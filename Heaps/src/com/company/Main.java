package com.company;
import java.util.ArrayList;
import java.util.List;

public class Main {
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
