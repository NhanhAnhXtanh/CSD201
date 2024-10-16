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
        int n = graph.length; // Số lượng đỉnh trong đồ thị
        int[] dist = new int[n]; // Khoảng cách ngắn nhất từ start đến các đỉnh khác
        boolean[] checked = new boolean[n]; // Đánh dấu đỉnh đã duyệt
        int[] predecessor = new int[n]; // Đỉnh trước trong đường đi ngắn nhất

        // Khởi tạo khoảng cách ban đầu
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // Duyệt tất cả các đỉnh
        for (int i = 0; i < n; i++) {
            // Chọn đỉnh u với khoảng cách nhỏ nhất trong các đỉnh chưa được duyệt
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!checked[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            // Nếu khoảng cách ngắn nhất là vô hạn, kết thúc quá trình
            if (dist[u] == Integer.MAX_VALUE) {
                break;
            }

            // Đánh dấu đỉnh u đã được duyệt
            checked[u] = true;

            // Cập nhật khoảng cách cho các đỉnh kề với u
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !checked[v]) { // Kiểm tra có cạnh nối
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        predecessor[v] = u;
                    }
                }
            }
        }

        // In kết quả khoảng cách ngắn nhất đến đỉnh end
        System.out.println("Khoảng cách ngắn nhất từ đỉnh " + start + " đến đỉnh " + end + " là: " + dist[end]);

        // In đường đi ngắn nhất
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
