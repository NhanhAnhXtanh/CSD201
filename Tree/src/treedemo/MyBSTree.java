package treedemo;

import java.util.ArrayList;

public class MyBSTree {

    Node root;

    public MyBSTree() {
        this.root = null;
    }

    public void clear() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int x) {
        // insert when BSTree is Empty
        if (isEmpty()) {
            System.out.println("Insert root: " + x);
            Node newNode = new Node(x);
            root = newNode;
            return;
        }

        // insert when BSTree is not empty
        Node cur;
        Node parrentOfCur = null;
        cur = root;
        while (cur != null) {
            // check if node x exist
            if (cur.info == x) {
                System.out.println("The key " + x + " already exists, no insertion");
                return;
            }

            // find position to insert: foundNode == null; parent...
            parrentOfCur = cur;
            if (x < cur.info) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        // now cur = null; parentOfCur has not both children

        // insert x to be child of parentOfCur node
        Node newNode = new Node(x);
        if (x < parrentOfCur.info) {
            System.out.println("Insert " + parrentOfCur.info + ".left: " + x);
            parrentOfCur.left = newNode;
        } else {
            System.out.println("Insert " + parrentOfCur.info + ".right: " + x);
            parrentOfCur.right = newNode;
        }
    }

    public void insertMany(int array[]) {
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    // Pre-order: Node -> Left -> Right
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        visit(node
        );
        preOrder(node.left);
        preOrder(node.right);
    }

    // In-order: Left -> Node -> Right
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        visit(node);
        inOrder(node.right);
    }

    // Post-order: Left -> Right -> Node
    void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        visit(node);
    }

    void visit(Node node) {
        System.out.print(node.info + " ");
    }

    // duyet theo chieu rong
    void breadth() {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            visit(p);
        }
    }

    //merge deletion
    public void deleteByMerging(int x) {  // merging Left
        //bên trái delNode thế delNode bên phải delNode gán vào bên phải ngoài cùng của Node gán
        //check if BSTree is emptys
        if (isEmpty()) {
            System.out.println("BSTree is emplty, no deletion");
            return;
        }

        //search node to be delete
        Node deleteNode;
        Node parentOfDeleteNode;
        deleteNode = root;
        parentOfDeleteNode = null;
        while (deleteNode != null) {
            if (deleteNode.info == x) {
                break; // found x
            }

            //continue search
            if (x < deleteNode.info) {
                parentOfDeleteNode = deleteNode;
                deleteNode = deleteNode.left;
            } else {
                parentOfDeleteNode = deleteNode;
                deleteNode = deleteNode.right;
            }
        }

        //check if found x
        if (deleteNode == null) {
            System.out.println("The key " + x + " does not exist, no deltion");
            return;
        }

        // Case 1: delete leaf node
        if (deleteNode.left == null && deleteNode.right == null) {
            //check if deleteNode is root(root là lá thì xóa lá)
            if (parentOfDeleteNode == null) {
                root = null;
            } else {
                if (parentOfDeleteNode.left == deleteNode) {
                    parentOfDeleteNode.left = null;
                } else {
                    parentOfDeleteNode.right = null;
                }
            }
            return;
        }

        // Case 2: delete node having only left child 
        if (deleteNode.left != null && deleteNode.right == null) {
            //check if deleteNode is root
            if (parentOfDeleteNode == null) {
                root = deleteNode.left;
            } else {
                if (parentOfDeleteNode.left == deleteNode) {
                    parentOfDeleteNode.left = deleteNode.left;
                } else {
                    parentOfDeleteNode.right = deleteNode.left;
                }
            }
            deleteNode.left = null;
            return;
        }

        //Case 3: delete node having only right child
        if (deleteNode.left == null && deleteNode.right != null) {
            //check if deleteNode is root
            if (parentOfDeleteNode == null) {
                root = deleteNode.right;
            } else {
                if (parentOfDeleteNode.left == deleteNode) {
                    parentOfDeleteNode.left = deleteNode.right;
                } else {
                    parentOfDeleteNode.right = deleteNode.right;
                }
            }
            deleteNode.right = null;
            return;
        }

        //Case 4: delete node having both left and right children
        if (deleteNode.left != null && deleteNode.right != null) {
            Node rightOfDeleteNode;
            Node replaceNode;  // the right most noe - this will replace deleteNode

            // find the right most node on the left sub-tree of deleteNode
            rightOfDeleteNode = deleteNode.right;
            replaceNode = deleteNode.left;
            while (replaceNode.right != null) {
                replaceNode = replaceNode.right;
            }

            replaceNode.right = rightOfDeleteNode;
            deleteNode.right = null;
            // now deleteNode has only left child

            // check if deleteNode is root
            if (parentOfDeleteNode == null) {
                root = deleteNode.left;
            } else {
                if (parentOfDeleteNode.left == deleteNode) {
                    parentOfDeleteNode.left = deleteNode.left;
                } else {
                    parentOfDeleteNode.right = deleteNode.left;
                }
            }
            deleteNode.left = null;
            return;
        }
    }

    public void deleteByCopying(int x) {// left
        if (isEmpty()) {
            System.out.println("BSTree is emplty, no deletion");
            return;
        }
        Node parentOfDeleteNode = null;
        Node deleteNode = root;

        while (deleteNode != null) {
            if (deleteNode.info == x) {
                break; // found x
            }

            //continue search
            if (x < deleteNode.info) {
                parentOfDeleteNode = deleteNode;
                deleteNode = deleteNode.left;
            } else {
                parentOfDeleteNode = deleteNode;
                deleteNode = deleteNode.right;
            }
        }

        //check if found x = null
        if (deleteNode == null) {
            System.out.println("The key " + x + " does not exist, no deltion");
            return;
        }

        // Case 1: delete leaf node
        if (deleteNode.left == null && deleteNode.right == null) {
            //check if deleteNode is root(root là lá thì xóa lá)
            if (parentOfDeleteNode == null) {
                root = null;
            } else {
                if (parentOfDeleteNode.left == deleteNode) {
                    parentOfDeleteNode.left = null;
                } else {
                    parentOfDeleteNode.right = null;
                }
            }
            return;
        }
        // Case 2: delete node having only left child 
        if (deleteNode.left != null && deleteNode.right == null) {
            //check if deleteNode is root
            if (parentOfDeleteNode == null) {
                root = deleteNode.left;
            } else {
                if (parentOfDeleteNode.left == deleteNode) {
                    parentOfDeleteNode.left = deleteNode.left;
                } else {
                    parentOfDeleteNode.right = deleteNode.left;
                }
            }
            deleteNode.left = null;
            return;
        }

        //Case 3: delete node having only right child
        if (deleteNode.left == null && deleteNode.right != null) {
            //check if deleteNode is root
            if (parentOfDeleteNode == null) {
                root = deleteNode.right;
            } else {
                if (parentOfDeleteNode.left == deleteNode) {
                    parentOfDeleteNode.left = deleteNode.right;
                } else {
                    parentOfDeleteNode.right = deleteNode.right;
                }
            }
            deleteNode.right = null;
            return;
        }

        if (deleteNode.left != null && deleteNode.right != null) {
            // Tìm nút lớn nhất trong cây con trái
            Node parentOfReplaceNode = null;
            Node replaceNode = deleteNode.left;

            while (replaceNode.right != null) {
                parentOfReplaceNode = replaceNode; // Cập nhật parent
                replaceNode = replaceNode.right; // Tiến tới nút bên phải
            }

            //copy info of replayseNode to delNode
            deleteNode.info = replaceNode.info;
            if (parentOfReplaceNode == null) {
                //replayceNode is left child of delNode
                deleteNode.left = replaceNode.left;
            } else {
                //replayceNode is not left child of delNode
                parentOfReplaceNode.right = replaceNode.left;
            }
            replaceNode.left = null;
            return;
        }
    }

    //  balance tree (cay can bang)
    public void inOrderToArray(ArrayList<Integer> a, Node from) {
        if (from == null) {
            return;
        }
        inOrderToArray(a, from.left);
        a.add(from.info);
        inOrderToArray(a, from.right);
    }

    public void balance(ArrayList<Integer> data, int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data.get(middle));
            balance(data, first, middle - 1);
            balance(data, middle + 1, last);
        }
    }

    public void balance() {
        ArrayList<Integer> a = new ArrayList<>();
        inOrderToArray(a, root);
        clear();
        balance(a, 0, a.size() - 1);
    }

    public Node searchFirstBothChildByBreadth(int value) {
        if (root == null) {
            return null;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            if (p.info < value && (p.left != null && p.right != null)) {
                return p;
            }
        }
        return null;
    }

    public Node getParentNode(Node parentOfNode) {
        if (isEmpty()) {
            System.out.println("BSTree is emplty, no deletion");
            return null;
        }

        Node deleteNode = root;
        Node parentOfDeleteNode = null;
        while (deleteNode != null) {
            if (deleteNode.info == parentOfNode.info) {
                break; // found x
            }

            //continue search
            if (parentOfNode.info < deleteNode.info) {
                parentOfDeleteNode = deleteNode;
                deleteNode = deleteNode.left;
            } else {
                parentOfDeleteNode = deleteNode;
                deleteNode = deleteNode.right;
            }
        }
        return parentOfDeleteNode;
    }

    public void rotateRight(Node node) {
        if (isEmpty()) {
            System.out.println("BSTree is emplty, no deletion");
            return;
        }

        Node parentOfNode = getParentNode(node);

        if (parentOfNode.left == null) {
            return;
        }

        Node leftChild = node.left;
        Node rightChildOfLeft = leftChild.right;

        if (parentOfNode == null) {/////

        }

        leftChild.right = node;
        node.left = rightChildOfLeft;

        if (parentOfNode.info > node.info) {
            parentOfNode.left = leftChild;
        } else {
            parentOfNode.right = leftChild;
        }

    }

}
