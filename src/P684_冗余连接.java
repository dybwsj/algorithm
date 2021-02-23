public class P684_冗余连接 {

    public static void main(String[] args) {
        P684_冗余连接 n = new P684_冗余连接();
        n.findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});
    }

    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        UnionFind unionFind = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            boolean union = unionFind.union(edges[i][0] - 1, edges[i][1] - 1);
            if (!union) {
                return new int[] {edges[i][0], edges[i][1]};
            }
        }
        return new int[]{};
    }

    class UnionFind {
        private int size;
        private int[] parent;
        public UnionFind(int size) {
            this.size = size;
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int i, int j) {
            int m = find(i);
            int n = find(j);
            if (m != n) {
                parent[m] = n;
                return true;
            }
            return false;
        }

        public int find(int i) {
            if (parent[i] == i) {
                return parent[i];
            }
            return parent[i] = find(parent[i]);
        }
    }
}
