package com.company;

import java.util.ArrayList;
//I fixted it!
public class minHeap <T extends Comparable<T>>{
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
    public void increaseKey(int pos){
        int currentPos=pos;
        while(moveDown(currentPos)){
            int rPos =  rightChild(currentPos);
            int lPos = leftChild(currentPos);
            if (rPos<size && minHeap.get(rPos).compareTo(minHeap.get(lPos))<0){
                swap(rPos,currentPos);
                currentPos=rPos;
            }else{
                swap(lPos,currentPos);
                currentPos=lPos;
            }
        }


    }
    private boolean moveDown(int pos){
        boolean leftSmaller=leftChild(pos)<size && (minHeap.get(leftChild(pos)).compareTo(minHeap.get(pos))<0);
        boolean rightSmaller=rightChild(pos)<size && (minHeap.get(rightChild(pos)).compareTo(minHeap.get(pos))<0);
        return leftSmaller || rightSmaller;

    }
    public T viewMin(){
        return minHeap.get(0);
    }
    public T extractMin(){
        T min = minHeap.get(0);
        minHeap.set(0,minHeap.get(size-1));
        size--;
        increaseKey(0);
        return min;
    }
}

