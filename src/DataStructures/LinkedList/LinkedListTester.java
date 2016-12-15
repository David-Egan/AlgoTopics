package DataStructures.LinkedList;

/**
 * Created by degan on 12/13/2016.
 *
 * Tests implementation of my linked list.
 */
public class LinkedListTester {

    public static void main(String args[]){
        insertAndRemoveTest();
    }

    private static void insertAndRemoveTest(){
        LinkedList testList = new LinkedList();
        testList.insert(3,0);
        testList.insert(5,1);
        testList.insert(6,2);
        testList.remove(1);
        testList.insert(111,1);
        testList.remove(0);
        testList.insert(42,0);
        testList.remove(0);
    }
}
