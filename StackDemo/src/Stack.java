
public class Stack {

    Node head;
    //tail;

    public Stack() {
        head = null;
    }

    void clear() {
        head = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    // addFirst
    void push(Student x) {
        Node p = new Node(x); // (1) p.next = null;
        p.next = head; // (2)
        head = p;
    }

    // removeFirst and getFirst
    Student pop() {
        if (isEmpty()) {
            return null;
        }
        Node x = head;
        head = head.next;
        x.next = null;
        return (x.info);
    }

    Student top() {
        if (isEmpty()) {
            return null;
        }
        return head.info;
    }
}
