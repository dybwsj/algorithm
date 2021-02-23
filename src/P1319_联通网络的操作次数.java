public class P1319_联通网络的操作次数 {
    public int makeConnected(int n, int[][] connections) {
        int length = connections.length;
        if (length < n - 1) {
            return -1;
        }
        Union union = new Union(n);
        for (int i = 0; i < length; i++) {
            union.union(connections[i][0], connections[i][1]);
        }
        return union.size - 1;
    }

    class Union {
        private int[] parent;
        private int size;
        public Union(int size) {
            this.size = size;
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            int a = find(i);
            int b = find(j);
            if (a != b) {
                parent[a] = b;
                size--;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
    }
}
