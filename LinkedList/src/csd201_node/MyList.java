/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csd201_node;

/**
 *
 * @author Admin
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(Student info) {
        Node node = new Node(info);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
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

    void addManyFirst(Student info[]) {
        for (int i = 0; i < info.length; i++) {
            addFirst(info[i]);
        }
    }

    void addIndex(Student info, int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(info);
        } else {
            Node cu = head;
            int pos = 0;
            while (cu != null) {
                if (pos == index - 1) {
                    break;
                }
                pos++;
                cu = cu.next;
            }
            if (cu == null) {
                return;
            } else {
                if (cu.next == null) {
                    addLast(info);
                } else {
                    Node node = new Node(info);
                    node.next = cu.next;
                    cu.next = node;
                }
            }
        }
    }

    void clear() {
        head = tail = null;
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        } else {
            head = head.next;
        }
    }

    void deleteLast() {
        if (head == tail) {
            clear();
        } else {
            Node node = head;
            while (node.next.next != null) { // giới hạn node nho hon tail -1
                // hoac while (node.next.next != null)
                node = node.next;
            }
            node.next = null;
            tail = node;
        }
    }

    Student delLast() {
        if (isEmpty()) {
            return null;
        }
        Node node = head;
        while (node.next != tail) { // giới hạn node nho hon tail -1
            // hoac while (node.next.next != null)
            node = node.next;
        }
        Student value = node.next.info;
        node.next = null;
        tail = node;
        return value;
    }

    void display() {
        Node cur = head;
        System.out.printf("%-10s%-15s%-15s\n", "SID", "Name", "Mark");

        while (cur != null) {
            System.out.printf("%-10s%-15s%-15f\n", cur.info.sid, cur.info.name, cur.info.mark);
            cur = cur.next;
        }
        System.out.println("");
    }

//    boolean checkPrime(int value
//    ) {
////        if (value <= 1) {
////            return false;
////        } else {
////            for (int i = 2; i <= Math.sqrt(value); i++) {
////                if(value % i == 0){
////                    return false;
////                }
////            }
////            return true;
////        }
//        for (int i = 2; i <= Math.sqrt(value); i++) {
//            if (value % i == 0) {
//                return false;
//            }
//        }
//        return value > 1;
//    }
//
//    void addNoPrimeFirst(Student value
//    ) {
//        if (!checkPrime(value)) {
//            addFirst(value);
//        }
//    }
    Node getFirst() {
        return head;
    }

    Node getLast() {
        return tail;
    }

    Node get(Student x) {
        Node node = head;
        while (node != null) {
            if (node.info == x) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    Node find(Node p) {
        Node node = head;
        while (node != null) {
            if (node.info == p.info) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // Sai vi node next co the null
    Node getNext(Node p) {
        Node node = head;
        while (node != null) {
            if (node.info == p.info) {
                if (node.next != null) {
                    return node.next;
                }
                return null;
            }
            node = node.next;
        }
        return null;
    }

    Node getPrev(Node p) {
        Node node = head;
        while (node.next != null) {
            if (node.next.info == p.info) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    int size() {
        int res = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            ++res;
        }
        return res;
    }

    Node getIndex(int index) {
        Node cur = head;
        int cnt = 0;
        while (cur != null) {
            if (cnt++ == index) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    void insertAfter(Node p, Student x) {
        if (p == tail) {
            addLast(x);
        } else {
            Node a = new Node(x);
            a.next = p.next;
            p.next = a;
        }
    }

    void insertBefore(Node p, Student x) {
        if (p == head) {
            addFirst(x);
        } else {
            Node a = getPrev(p);
            insertAfter(a, x);
        }
    }

    void insert(int index, Student x) {
        Node a = getIndex(index);
        insertBefore(a, x);
    }

    void remove(Node p) {
        getPrev(p).next = getNext(p);
        p.next = null;
    }

    void remove(int index) {
        Node x = getIndex(index);
        if (x != null) {
            remove(x);
        }
    }

    void removeAfter(Node p) {
        if (p != tail) {
            Node x = getNext(p);
            remove(x);
        }
    }

    void removeBefore(Node p) {
        if (p != head) {
            Node x = getPrev(p);
            remove(x);
        }
    }

    void set(Node p, Student x) {
        p.info = x;
    }

    Node max() {
        if (isEmpty()) {
            return null;
        }
        Node temp;
        Node cur = temp = head;
        while (cur != null) {
            if (cur.info.mark > temp.info.mark) {
                temp = cur;
            }
            cur = cur.next;
        }
        return temp;
    }

    Node secondMax() {
        if (head == null || head.next == null) {
            return null; // Nếu danh sách rỗng hoặc chỉ có 1 phần tử
        }

        Node maxNode = max(); // Tìm node lớn nhất
        Node secondMaxNode = null;

        Node p = head;

        while (p != null) {
            if (p != maxNode) { // Bỏ qua maxNode
                // Nếu secondMaxNode là null hoặc giá trị của p lớn hơn giá trị của secondMaxNode
                if (secondMaxNode == null || p.info.mark > secondMaxNode.info.mark) {
                    secondMaxNode = p;
                }
            }
            p = p.next;
        }

        return secondMaxNode; // Trả về node có giá trị lớn thứ hai
    }

    void swap(Node p, Node q) {
        if (p == null || q == null) {
            return;
        }

        Student temp = p.info;
        p.info = q.info;
        q.info = temp;
    }

    void sort() {
        Node p = head;
        while (p != null) {
            Node q = p.next;
            while (q != null) {
                if (p.info.mark > q.info.mark) {
                    swap(p, q);
                }
                q = q.next;
            }
            p = p.next;
        }
    }

    void selectionSort(Node p, Node q) {
        for (Node i = p; i != q; i = i.next) {
            Node pos = i;
            for (Node j = i.next; j != q.next; j = j.next) {
                if (pos.info.mark > j.info.mark) {
                    pos = j;
                }
            }
            swap(i, pos);
        }
    }

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public Student searchByName(String name) {
        Node node = head;
        while (node != null) {
            if (name.equals(node.info.name)) {
                return node.info;
            }
            node = node.next;
        }
        return null;
    }

    public Node searchByMark(double mark) {
        Node node = head;
        while (node != null) {
            if (node.info.mark == mark) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void sortByMark() {
        if (head == tail) {
            return;
        }
        Node cur = head;
        int posMain = 0;
        while (cur.next != null) {
            Node node = cur.next;
            int posCur = posMain;
            int posNode = posCur + 1;
            int location = -1;
            double ganMark = cur.info.mark;
            while (node != null) {
                if (ganMark > node.info.mark) { // Tăng dần
                    ganMark = node.info.mark;
                    location = posNode;
                }
                posNode++;
                node = node.next;
            }
            swap(cur, getIndex(location));
            cur = cur.next;
            posMain++;
        }

    }

    public void sortByMark1() {
        if (head == tail) {
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            Node node = cur.next;
            while (node != null) {
                if (cur.info.mark > node.info.mark) {
                    swap(cur, node);
                }
                node = node.next;
            }
            cur = cur.next;
        }
    }

    public void sortByName() {
        if (head == tail) {
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            Node node = cur.next;
            while (node != null) {
                int com = cur.info.name.compareToIgnoreCase(node.info.name);
                if (com > 0) {
                    swap(cur, node);
                }
                node = node.next;
            }
            cur = cur.next;
        }
    }

    //seach (int x)
    //seach by name
    //seach by ID
    //seach by Mark
    //sort
//    by Name
//    by ID
//    by mark       
}
