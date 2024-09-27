
public class Queue {

    Node head, tail;
    //tail;

    public Queue() {
        head = tail = null;
    }

    void clear() {
        head = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void addLast(Student info) {
        Node node = new Node(info);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
//            node.next = null; 
//      Khong can vi node.next luon chi vao null;
            tail = node;
        }
    }
    // addFirst
    void enqueue(Student x) {
        Node p = new Node(x); // (1) p.next = null;
        p.next = head; // (2)
        head = p;
    }

    // removeFirst
    Student dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node x = head;
        head = head.next;
        x.next = null;
        return (x.info);
    }

    Student front() {
        if (isEmpty()) {
            return null;
        }
        return head.info;
    }
}
