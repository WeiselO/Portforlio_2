package com.company;
import java.util.ArrayList;
import java.util.HashMap;

public class MinHeap<T extends Comparable<T>>{
    HashMap<T, Integer> positionTable = new HashMap<>();
    //root = 0
    ArrayList<T> MinHeap;
    private int size;
    public MinHeap(){
        this.MinHeap= new ArrayList<>();
        this.size=0;
    }
    public boolean isEmpty(){
        if (size > 0) return false;
        else return true;
    }

    // Returns the position of an item in our positionTable.
    public int getPosition(T item){
        return positionTable.get(item);
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

    // Swaps two values in our minHeap and updates the positionTable.
    public void swap(int pos1, int pos2){
        T item1 = MinHeap.get(pos1);
        T item2 = MinHeap.get(pos2);
        MinHeap.set(pos1, item2);
        MinHeap.set(pos2, item1);
        positionTable.put(MinHeap.get(pos1),pos1);
        positionTable.put(MinHeap.get(pos2),pos2);
    }

    // Inserts a value into our minHeap and positionTable
    public void insert (T item){
        MinHeap.add(item);
        positionTable.put(item,size); //BEFORE you change the size, you log the items position.
        size++;
        decreaseKey(size-1);
    }

    // Updates the minHeap by "bubbling up" the values in the minHeap
    public void decreaseKey(int pos) {
        int currentPos = pos;
        while (MinHeap.get(currentPos).compareTo(MinHeap.get(parent(currentPos))) < 0) {
            swap(currentPos, parent(currentPos));
            currentPos = parent(currentPos);
        }
    }

    // Updates the minHeap by "bubbling down" the values in the minHeap.
    public void increaseKey(int pos){
        int currentPos=pos;
        while(moveDown(currentPos)){
            int rPos =  rightChild(currentPos);
            int lPos = leftChild(currentPos);
            if (rPos<size && MinHeap.get(rPos).compareTo(MinHeap.get(lPos))<0){
                swap(rPos,currentPos);
                currentPos=rPos;
            }else{
                swap(lPos,currentPos);
                currentPos=lPos;
            }
        }
    }

    //Returns true if
    private boolean moveDown(int pos){
        boolean leftSmaller=leftChild(pos)<size && (MinHeap.get(leftChild(pos)).compareTo(MinHeap.get(pos))<0);
        boolean rightSmaller=rightChild(pos)<size && (MinHeap.get(rightChild(pos)).compareTo(MinHeap.get(pos))<0);
        return leftSmaller || rightSmaller;

    }

    // Extracts the minimum value
    public T extractMin(){
        T min = MinHeap.get(0);
        MinHeap.set(0,MinHeap.get(size-1));
        positionTable.put(MinHeap.get(0),0);
        size--;
        increaseKey(0);
        return min;
    }
}

