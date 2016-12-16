package DataStructures.MinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by degan on 12/14/2016
 */
public class MinHeap{
    private final int rootIndex = 0;
    private List<Integer> items;
    private int size;

    public MinHeap(){
        items = new ArrayList<Integer>();
    }

    private boolean hasLeftChild(int index) {
        return !(getLeftChildIndex(index) >= size);
    }
    private boolean hasRightChild(int index){
        return !(getRightChildIndex(index) >= size);
    }
    private boolean hasParent(int index){
        return !(index == rootIndex || getParentIndex(index) < 0);
    }

    private int getParentIndex(int index){
        if (index % 2 == 0) return (index / 2) - 1;
        else return (index / 2);
    }
    private int getLeftChildIndex(int index){
        if (index % 2 == 0) return (index * 2) + 1;
        else return (index * 2);
    }

    private int getRightChildIndex(int index){
        return (index * 2) + 2;
    }

    private void heapifyDown(){
        int currIndex = rootIndex;

        while (hasLeftChild(currIndex)){
            if (!hasRightChild(currIndex) || items.get(getLeftChildIndex(currIndex)) > items.get(getRightChildIndex(currIndex)) ) {
                swap(getLeftChildIndex(currIndex), currIndex);
                currIndex = getLeftChildIndex(currIndex);
            }
            else{
                swap(getRightChildIndex(currIndex), currIndex);
                currIndex = getLeftChildIndex(currIndex);
            }
        }
    }

    private void heapifyUp(){
        int currIndex = size-1;

        while (hasParent(currIndex)){
            if (items.get(currIndex) < items.get(getParentIndex(currIndex)) ) {
                swap(getParentIndex(currIndex), currIndex);
                currIndex = getParentIndex(currIndex);
            }
            else{
                break;
            }
        }
    }

    // takes indices
    private void swap(int a, int b){
        int temp;

        temp = items.get(a);
        items.set(a, items.get(b));
        items.set(b, temp);
    }

    public void insert(int data){
        items.add(data);
        size++;

        // If this isn't the first element we are adding
        if (size != 1){
            //swap(size-1, rootIndex);
            heapifyUp();
        }

        System.out.println(toString());
    }

    public void removeMinimum(){
        if (size == 0) throw new IllegalStateException();

        swap(rootIndex, size-1);
        items.remove(size-1);
        size--;
        heapifyDown();
        System.out.println(toString());
    }

    public String toString(){
        StringBuilder heapString  = new StringBuilder();

        for (int data : items){
            heapString.append(data + "-");
        }

        return heapString.toString();
    }

    public static void main(String[] args){
        MinHeap myHeap = new MinHeap();
        myHeap.insert(4);
        myHeap.removeMinimum();
        myHeap.insert(2);
        myHeap.insert(1);
        myHeap.removeMinimum();
        myHeap.insert(7);
        myHeap.insert(11);
        myHeap.removeMinimum();
    }
}
