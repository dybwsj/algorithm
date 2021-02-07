import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: duyubo
 * @date: 2021年01月29日, 0029 10:16
 * @description:
 */
public class P1631_最小体力消耗路径 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int minimumEffortPath(int[][] heights) {
        // BFS + 二分
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 999999, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{0, 0});
            boolean[] seen = new boolean[m * n];
            seen[0] = true;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                        queue.offer(new int[]{nx, ny});
                        seen[nx * n + ny] = true;
                    }
                }
            }
            if (seen[m * n - 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    // 并查集
//        int m = heights.length;
//        int n = heights[0].length;
//        List<int[]> edges = new ArrayList<int[]>();
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                int id = i * n + j;
//                if (i > 0) {
//                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
//                }
//                if (j > 0) {
//                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
//                }
//            }
//        }
//        Collections.sort(edges, Comparator.comparingInt(edge -> edge[2]));
//
//        UnionFind uf = new UnionFind(m * n);
//        int ans = 0;
//        for (int[] edge : edges) {
//            int x = edge[0], y = edge[1], v = edge[2];
//            uf.unite(x, y);
//            if (uf.connected(0, m * n - 1)) {
//                ans = v;
//                break;
//            }
//        }
//        return ans;
//    }
}

//// 并查集模板
//class UnionFind {
//    int[] parent;
//    int[] size;
//    int n;
//    // 当前连通分量数目
//    int setCount;
//
//    public UnionFind(int n) {
//        this.n = n;
//        this.setCount = n;
//        this.parent = new int[n];
//        this.size = new int[n];
//        Arrays.fill(size, 1);
//        for (int i = 0; i < n; ++i) {
//            parent[i] = i;
//        }
//    }
//
//    public int findset(int x) {
//        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
//    }
//
//    public boolean unite(int x, int y) {
//        x = findset(x);
//        y = findset(y);
//        if (x == y) {
//            return false;
//        }
//        if (size[x] < size[y]) {
//            int temp = x;
//            x = y;
//            y = temp;
//        }
//        parent[y] = x;
//        size[x] += size[y];
//        --setCount;
//        return true;
//    }
//
//    public boolean connected(int x, int y) {
//        x = findset(x);
//        y = findset(y);
//        return x == y;
//    }
//}
