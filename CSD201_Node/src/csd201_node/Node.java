package csd201_node;

public class Node {

    int info; // number: mac dinh la 0
    Node next; // object, array,String: mac dinh la null
    // logic la false

    public Node() {

    }

    public Node(int info) {
        this.info = info;
        next = null;
    }

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }

}
