/**
 * @author: duyubo
 * @date: 2021年01月25日, 0025 09:33
 * @description:
 */
public class P959_由斜杠划分区域 {
    public int regionsBySlashes(String[] grid) {
        int length = grid.length;
        int num = length + 1;
        int total = num * num;
        Union union = new Union(total);

        for (int i = 0; i < total; i++) {
            if (i / num == 0 || i / num == num - 1 || i % num == 0 || i % num == num - 1) {
                union.union(num, i);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i].charAt(j) == '/') {
                    union.union((i + 1) * num + j, i * num + j + 1);
                } else if (grid[i].charAt(j) == '\\') {
                    union.union(i * num + j, (i + 1) * num + j + 1);
                }
            }
        }
        return union.size;
    }

    class Union {
        private int size;
        private int[] parent;
        public Union(int size) {
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
            } else {
                size++;
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
