import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: duyubo
 * @date: 2021年01月15日, 0015 11:00
 * @description:
 */
public class P947_移除最多的同行或同列石头 {
    public static void main(String[] args) {
        P947_移除最多的同行或同列石头 m = new P947_移除最多的同行或同列石头();
        m.removeStones(new int[][]{{0,0},{0,1},{1,2},{2,1},{2,2}});
    }
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();

        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    private class UnionFind {

        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }

            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent.put(rootX, rootY);
            count--;
        }
    }
}
