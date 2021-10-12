package com.company;

import java.util.ArrayList;

public class MinHeap <T extends Comparable<T>>{
    ArrayList<T> minHeap;
    private int size;
    public minHeap(){
        this.minHeap= new ArrayList<T>();
        this.size=0;

    }
    private int parent (int pos){
        return (pos-1)/2;
    }
    private int leftChild (int pos){
        return (pos*2)+1;
    }
    private int rightChild (int pos){
        return (pos*2)+2;
    }
    public void swap(int pos1, int pos2){
        T item1= minHeap.get(pos1);
        T item2= minHeap.get(pos2);
        minHeap.set(pos1, item2);
        minHeap.set(pos2, item1);
    }
    public void insert (T item){
        minHeap.add(item);
        size++;
        decreaseKey(size-1);
    }


    public void decreaseKey(int pos) {
        int currentPos = pos;
        while (minHeap.get(currentPos).compareTo(minHeap.get(parent(currentPos))) < 0) {
            swap(currentPos, parent(currentPos));
            currentPos = parent(currentPos);
        }
    }

    public T viewMin(){
        return null;
    }
}

