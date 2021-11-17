package com.company;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating the Adjacency Graph
        AdjGraph MyGraph=new AdjGraph();

        // Creating all Verticies
        Vertex Eskildstrup = new Vertex("Eskildstrup");
        Vertex Haslev = new Vertex("Haslev");
        Vertex Holbæk = new Vertex("Holbæk");
        Vertex Jærgerspris = new Vertex("Jærgerspris");
        Vertex Kalundborg = new Vertex("Kalundborg");
        Vertex Korsør = new Vertex( "Korsør");
        Vertex Køge = new Vertex("Køge");
        Vertex Maribo = new Vertex("Maribo");
        Vertex Nakskov = new Vertex("Nakskov");
        Vertex NykøbingF = new Vertex( "NykøbingF");
        Vertex Næstved = new Vertex("Næstved");
        Vertex Ringsted = new Vertex("Ringsted");
        Vertex Roskilde = new Vertex("Roskilde");
        Vertex Slagelse = new Vertex("Slagelse");
        Vertex Sorø = new Vertex("Sorø");
        Vertex Vordingborg = new Vertex("Vordingborg");

        // Adding all the Verticies to our graph
        MyGraph.addVertex(Eskildstrup);
        MyGraph.addVertex(Haslev);
        MyGraph.addVertex(Holbæk);
        MyGraph.addVertex(Jærgerspris);
        MyGraph.addVertex(Kalundborg);
        MyGraph.addVertex(Korsør);
        MyGraph.addVertex(Køge);
        MyGraph.addVertex(Maribo);
        MyGraph.addVertex(Nakskov);
        MyGraph.addVertex(NykøbingF);
        MyGraph.addVertex(Næstved);
        MyGraph.addVertex(Ringsted);
        MyGraph.addVertex(Roskilde);
        MyGraph.addVertex(Slagelse);
        MyGraph.addVertex(Sorø);
        MyGraph.addVertex(Vordingborg);

        // Adding the edges and their weights
        MyGraph.addEdge(Eskildstrup,Maribo,28);
        MyGraph.addEdge(Eskildstrup,NykøbingF, 13);
        MyGraph.addEdge(Eskildstrup,Vordingborg,25);
        MyGraph.addEdge(Haslev,Korsør,60);
        MyGraph.addEdge(Haslev,Køge,24);
        MyGraph.addEdge(Haslev,Næstved,25);
        MyGraph.addEdge(Haslev,Ringsted,19);
        MyGraph.addEdge(Haslev,Roskilde, 47);
        MyGraph.addEdge(Haslev,Slagelse, 48);
        MyGraph.addEdge(Haslev,Sorø,34);
        MyGraph.addEdge(Haslev,Vordingborg, 40);
        MyGraph.addEdge(Holbæk,Jærgerspris,34);
        MyGraph.addEdge(Holbæk,Kalundborg, 44);
        MyGraph.addEdge(Holbæk,Korsør, 66);
        MyGraph.addEdge(Holbæk,Ringsted, 36);
        MyGraph.addEdge(Holbæk,Roskilde, 32);
        MyGraph.addEdge(Holbæk,Slagelse, 46);
        MyGraph.addEdge(Jærgerspris,Korsør, 94);
        MyGraph.addEdge(Jærgerspris,Køge, 58);
        MyGraph.addEdge(Jærgerspris,Ringsted, 56);
        MyGraph.addEdge(Jærgerspris,Roskilde, 33);
        MyGraph.addEdge(Jærgerspris,Slagelse, 74);
        MyGraph.addEdge(Jærgerspris,Sorø, 63);
        MyGraph.addEdge(Kalundborg,Ringsted, 62);
        MyGraph.addEdge(Kalundborg,Roskilde, 70);
        MyGraph.addEdge(Kalundborg,Slagelse, 39);
        MyGraph.addEdge(Kalundborg,Sorø, 51);
        MyGraph.addEdge(Korsør,Næstved, 45);
        MyGraph.addEdge(Korsør,Slagelse, 20);
        MyGraph.addEdge(Køge,Næstved, 45);
        MyGraph.addEdge(Køge,Ringsted, 28);
        MyGraph.addEdge(Køge,Roskilde, 25);
        MyGraph.addEdge(Køge,Vordingborg, 60);
        MyGraph.addEdge(Maribo,Nakskov, 27);
        MyGraph.addEdge(Maribo,NykøbingF, 26);
        MyGraph.addEdge(Næstved,Roskilde, 57);
        MyGraph.addEdge(Næstved,Ringsted, 26);
        MyGraph.addEdge(Næstved,Slagelse, 37);
        MyGraph.addEdge(Næstved,Sorø, 32);
        MyGraph.addEdge(Næstved,Vordingborg, 28);
        MyGraph.addEdge(Ringsted,Roskilde, 31);
        MyGraph.addEdge(Ringsted,Sorø, 15);
        MyGraph.addEdge(Ringsted,Vordingborg, 58);
        MyGraph.addEdge(Slagelse,Sorø, 14);

        // Priting the graph and then running Prims-method, which prints the MST
        MyGraph.PrintGraph();
        MyGraph.MSTPrims();
    }

}
