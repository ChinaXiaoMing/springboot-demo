package dataStructure;

import java.util.LinkedList;

public class MyLinkedList {

    private int size = 0;

    private Node first;

    private Node last;

    public MyLinkedList() {

    }

    private static class Node {
        int element;
        Node next;
        public Node(int element) {
            this.element = element;
        }
    }

    public void addAtHead(int val) {
        final Node f = first;
        Node node = new Node(val);
        first = node;
        node.next = f;
        size++;
    }

    public void addAtIndex(int index, int val) {

    }

    public int get(int index) {
        return 1;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList.size());
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(1, 1);
    }

}
