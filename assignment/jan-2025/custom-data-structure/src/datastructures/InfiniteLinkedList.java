package datastructures;

public class InfiniteLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public void append(Node node) {
            if (this.next == null) {
                this.next = node;
            } else {
                this.next.append(node);
            }
        }


    }

    private Node head;

    public InfiniteLinkedList() {
        this.head = null;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void append(Node newNode) {
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.head.append(newNode);
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public Node getHead() {
        return this.head;
    }

    public int getLength() {
        int length = 0;
        for (Node current = this.head; current != null; current = current.next) {
            length++;
        } return length;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void print() {
        Node current = this.head;
        while (current != null) {
            System.out.print("[" + current.data + "] -> ");
            current = current.next;
        }
        System.out.println("[NULL]");
    }

}


/*
* list + queue pro max
* ==> list + deque
* implement all optional list operation
* permit all element including null
* deque because ( [previous node address]<-[data]->[next node address] ) queue of fixed size 3 for
*   double linkedList or
* ( [data]->[next node address]
* let me build remove first
* */