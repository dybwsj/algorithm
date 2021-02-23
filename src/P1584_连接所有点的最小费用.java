import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: duyubo
 * @date: 2021年01月19日, 0019 16:40
 * @description:
 */
public class P1584_连接所有点的最小费用 {
    public static void main(String[] args) {
        P1584_连接所有点的最小费用 m = new P1584_连接所有点的最小费用();
        m.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}});
    }
    class Edge {
        int x, y, length;
        public Edge(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
    private int[] parent;
    public int minCostConnectPoints(int[][] points) {
        int result = 0;
        int length = points.length;
        parent = new int[length];
        for (int i = 0; i < length; i++) {
            parent[i] = i;
        }

        List<Edge> edgeList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                edgeList.add(new Edge(i, j, len));
            }
        }
        edgeList.sort(Comparator.comparingInt(a -> a.length));
        for (Edge e : edgeList) {
            int x = find(e.x);
            int y = find(e.y);
            if (x == y) {
                continue;
            }
            parent[x] = y;
            result += e.length;
        }
        return result;
    }

    private int find(int x) {
        if (!(parent[x] == x)) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
