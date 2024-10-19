package Graph;

public class Graph {

    int[][] a;
    int n;
    char[] v;

    Graph() {
        v = "ABCDEFGHIJKLMN".toCharArray();
    }

    void setData(int[][] b) {
        n = b.length;
        int i, j;
        a = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void visit(int i) {
        System.out.print(v[i] + "  ");
    }

// code for breadth-first traversal here
    void breadthFirst(boolean[] enqueued, int k) {
        MyQueue q = new MyQueue();
        q.enqueue(new Integer(k));
        enqueued[k] = true;

        while (!q.isEmpty()) {
            int h = Integer.parseInt((q.dequeue()).toString().trim());
            visit(h);
            for (int i = 0; i < n; i++) {
                if ((!enqueued[i]) && a[h][i] > 0) {
                    q.enqueue(new Integer(i));
                    enqueued[i] = true;
                }
            }
        }
    }

    void breadth(int k) {
        boolean[] enqueued = new boolean[n];
        for (int i = 0; i < n; i++) {
            enqueued[i] = false;
        }
        breadthFirst(enqueued, k);
        for (int i = 0; i < n; i++) {
            if (!enqueued[i]) {
                breadthFirst(enqueued, i);
            }
        }
    }

// code for depth-first traversal here
    void depthFirst(boolean visited[], int i) {
        visit(i);
        visited[i] = true;
        int j;
        for (j = 0; j < n; j++) {
            if (a[i][j] > 0 && (!visited[j])) {
                depthFirst(visited, j);
            }
        }
    }

    void depth(int k) {
        boolean[] visited = new boolean[20];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        depthFirst(visited, k);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirst(visited, i);
            }
        }
        System.out.println();
    }

}
