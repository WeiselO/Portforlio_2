package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MinHeap<String> myMinHeap=new MinHeap<String>();
        myMinHeap.insert("Albert");
        myMinHeap.insert("Line");
        myMinHeap.insert("Benjamin");
        myMinHeap.insert("Aisha");
        myMinHeap.insert("Anya");
        myMinHeap.insert("Patrick");

        while (!myMinHeap.isEmpty()){
            System.out.println(myMinHeap.extractMin());
        }
    }

}
