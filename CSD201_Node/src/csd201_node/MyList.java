package csd201_node;

public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(int info) {
        Node node = new Node(info);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addLast(int info) {
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

    void addManyFirst(int info[]) {
        for (int i = 0; i < info.length; i++) {
            addFirst(info[i]);
        }
    }

    void addIndex(int info, int index) {
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

    int delLast() {
        if (isEmpty()) {
            return -1;
        }
        Node node = head;
        while (node.next != tail) { // giới hạn node nho hon tail -1
            // hoac while (node.next.next != null)
            node = node.next;
        }
        int value = node.next.info;
        node.next = null;
        tail = node;
        return value;
    }

    void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.info);
            cur = cur.next;
            if (cur != null) {
                System.out.print(", ");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

    boolean checkPrime(int value
    ) {
//        if (value <= 1) {
//            return false;
//        } else {
//            for (int i = 2; i <= Math.sqrt(value); i++) {
//                if(value % i == 0){
//                    return false;
//                }
//            }
//            return true;
//        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return value > 1;
    }

    void addNoPrimeFirst(int value
    ) {
        if (!checkPrime(value)) {
            addFirst(value);
        }
    }

    Node getFirst() {
        return head;
    }

    Node getLast() {
        return tail;
    }

    Node get(int x) {
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

    void insertAfter(Node p, int x) {
        if (p == tail) {
            addLast(x);
        } else {
            Node a = new Node(x);
            a.next = p.next;
            p.next = a;
        }
    }

    void insertBefore(Node p, int x) {
        if (p == head) {
            addFirst(x);
        } else {
            Node a = getPrev(p);
            insertAfter(a, x);
        }
    }

    void insert(int index, int x) {
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

    void set(Node p, int x) {
        p.info = x;
    }

    Node max() {
        if (isEmpty()) {
            return null;
        }
        Node temp;
        Node cur = temp = head;
        while (cur != null) {
            if (cur.info > temp.info) {
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
                if (secondMaxNode == null || p.info > secondMaxNode.info) {
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

        int temp = p.info;
        p.info = q.info;
        q.info = temp;
    }

    void sort() {
        Node p = head;
        while (p != null) {
            Node q = p.next;
            while (q != null) {
                if (p.info > q.info) {
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
                if (pos.info > j.info) {
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

}
