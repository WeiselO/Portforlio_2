package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    boolean adjMatrixHasEdge[][];
    int adjMatrixWeight[][];
    int numVertices;

    public Graph(int numVertices){
        this.adjMatrixHasEdge = new boolean[numVertices][numVertices];
        this.adjMatrixWeight = new int[numVertices][numVertices];
        this.numVertices = numVertices;
    }

    public void addEdge (int from, int to, int weight){
        this.adjMatrixHasEdge[from][to]=true;
        this.adjMatrixHasEdge[to][from]=true;
        this.adjMatrixWeight[from][to]=weight;
        this.adjMatrixWeight[to][from]=weight;
    }

    public void print(){
        for (int from = 0; from < numVertices; from++) {
            for (int to = 0; to < numVertices; to++) {
                if(adjMatrixHasEdge[from][to]){
                    System.out.println("Edge from: "+ from +" to "+ to +" is weight:"+adjMatrixWeight[to][from]);
                }
            }
        }
    }

    public ArrayList<String> MSTPrims() {
        ArrayList<String> MST = new ArrayList<>();

        int[] distance = new int[numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE); //Making all initial values in distance = "infinite".

        int[] prev = new int[numVertices];
        Arrays.fill(prev,-1); //Making all initial values of prev = -1.

        MinHeap<Pair> Q = new MinHeap<>();
        Pair[] vertexPairs = new Pair[numVertices];
        for (int i = 0; i < numVertices; i++) {
            Pair newPair = new Pair(distance[i], i);
            Q.insert(newPair);
            vertexPairs[i] = newPair;
        } //Initializes a minHeap of size = numVerticies, with Pair-objects. Adds every pair to the vertexParis-array.

        if (numVertices > 0) {
            distance[0] = 0; //Starting value is 0.
            vertexPairs[0].distance = 0; //Starting value is 0
            int pos = Q.getPosition(vertexPairs[0]); //Getting the position of the starting element
            Q.decreaseKey(pos); //Fixing the minHeap, since we changed a Pair at "pos" to have a weight of 0.
            int MSTtotal = 0;
            while (!Q.isEmpty()) {
                Pair u = Q.extractMin(); //Getting the minimum distance (starting value is 0)
                int from = u.index;
                for (int to = 0; to < numVertices; to++) {
                    if (adjMatrixHasEdge[from][to] && adjMatrixWeight[from][to] < distance[to]) { //If it has value and that value is smaller than infinity
                        distance[to] = adjMatrixWeight[from][to];
                        prev[to] = from;
                        pos = Q.getPosition(vertexPairs[to]); //initializing our new edge as our new position
                        vertexPairs[to].distance = distance[to]; //updating the value of the vertexPairs to match distance
                        Q.decreaseKey(pos); //Fixing the minHeap.
                    }
                }
                MSTtotal += distance[from];
                String printout = "Edge: "+prev[from]+ " To: " + from + " = " + distance[from];
                MST.add(printout);
                //System.out.println("Edge: " + prev[from] + " To: " + from + " has weight:" + distance[from]);
                //the first prev[from] = -1, because -1 is inital value.
            }
            System.out.println("MST size is: "+MSTtotal);
            System.out.println("Price of this MST is: "+MSTtotal*100000+" DKK");
        }
        return MST;
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
        Graph myGraph = new Graph( 7);
        myGraph.addEdge(0,1,9);
        myGraph.addEdge(0,2,5);
        myGraph.addEdge(0, 4,3);
        myGraph.addEdge(1, 4,5);
        myGraph.addEdge(1, 5,7);
        myGraph.addEdge(2, 3,3);
        myGraph.addEdge(3, 4,3);
        myGraph.addEdge(3, 6,2);
        myGraph.addEdge(4, 2,7);
        myGraph.addEdge(4, 3,3);
        myGraph.addEdge(4, 5,3);
        myGraph.addEdge(4, 6,4);
        myGraph.addEdge(5, 6,9);

        myGraph.print();
        myGraph.MSTPrims();
    }

}

