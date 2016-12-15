package DataStructures.LinkedList;;

import java.util.List;

/**
 * Created by degan on 12/13/2016.
 */
public class LinkedList<E> {
    private Node head;
    private Node tail;
    int size;

    private static  class Node<E> {
        Node next;
        E data;

        public Node(E data){
            this.data = data;
        }
    }

    public LinkedList(){
        head = null;
        tail = null;
    }

    public void remove(int targetIndex){
        if (targetIndex >= size || targetIndex < 0) throw new IndexOutOfBoundsException();

        if (targetIndex == 0){
            head = head.next;
        }
        else {
            int currIndex = 0;
            Node currNode = head;

            while (currIndex != targetIndex-1){
                currNode = currNode.next;
                currIndex++;
            }

            currNode.next = currNode.next.next;
        }

        size--;
        System.out.println(toString());
    }

    public <E> void insert(E data, int targetIndex){
        Node newNode = new Node(data);

        if (targetIndex > size || targetIndex < 0) throw new IndexOutOfBoundsException();

        if (targetIndex == 0){
            if (head == null) tail = newNode;
            newNode.next = head;
            head = newNode;
            //tail = newNode;
        }
        else if (targetIndex == size){
            tail.next = newNode;
            tail = newNode;
        }
        else{
            Node currNode = head;
            int currIndex = 0;

            while (currIndex != targetIndex-1){
                currIndex++;
                currNode = currNode.next;
            }

            newNode.next = currNode.next;
            currNode.next = newNode;
        }

        size++;
        System.out.println(toString());
    }


    public String toString(){
        Node currNode = head;

        StringBuilder prettyList = new StringBuilder();

        while (currNode != null){
            prettyList.append(currNode.data + "->");
            currNode = currNode.next;
        }

        prettyList.append("NULL");
        prettyList.append("   Tail:" + tail + "   Head:" + head);
        prettyList.append("   Size:" + size);

        return prettyList.toString();
    }

    /* Navigate to node at given index */
    private Node navigateToNode(Node startNode, int targetIndex) throws Exception{
        int currIndex = 0;
        Node currNode = startNode;

        while (currIndex != targetIndex){
            if (currNode == null){
                throw new Exception("Null Node, not sure why this would happen");
            }
            currIndex++;
            currNode = currNode.next;
        }

        return currNode;
    }
}
