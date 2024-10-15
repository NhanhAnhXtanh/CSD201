
public class Node {

    Student info;
    Node next;

    public Node() {

    }

    public Node(Student info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Student info) {
        this(info, null);
    }
}
