package Graph;

import java.util.Arrays;

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

    //dijkstra
    public static void dijkstra(int[][] graph, int start, int end) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] checked = new boolean[n]; 
        int[] predecessor = new int[n]; 

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!checked[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            if (dist[u] == Integer.MAX_VALUE) {
                break;
            }

            checked[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !checked[v]) {
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        predecessor[v] = u;
                    }
                }
            }
        }

        System.out.println("Khoảng cách ngắn nhất từ đỉnh " + start + " đến đỉnh " + end + " là: " + dist[end]);

        System.out.print("Đường đi: ");
        printPath(predecessor, start, end);
    }

    // Phương thức in đường đi từ đỉnh start đến đỉnh end
    private static void printPath(int[] predecessor, int start, int end) {
        if (end == start) {
            System.out.print(start + " ");
        } else if (predecessor[end] == -1) {
            System.out.println("Không có đường đi");
        } else {
            printPath(predecessor, start, predecessor[end]);
            System.out.print(end + " ");
        }
    }

}
