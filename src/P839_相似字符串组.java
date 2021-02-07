/**
 * @author: duyubo
 * @date: 2021年01月31日, 0031 14:00
 * @description: 并查集
 */
public class P839_相似字符串组 {
    public int numSimilarGroups(String[] strs) {
        int length = strs.length;
        Union union = new Union(length);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                union.union(i, j, strs);
            }
        }
        return union.size;
    }

    class Union {
        private int[] parent;
        private int size;
        public Union(int size) {
            parent = new int[size];
            this.size = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j, String[] strs) {
            int a = find(i);
            int b = find(j);
            if (a != b && check(i, j, strs)) {
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

        private boolean check(int i, int j, String[] strs) {
            int n = 0;
            for (int m = 0; m < strs[i].length(); m++) {
                if (strs[i].charAt(m) != strs[j].charAt(m)) {
                    n++;
                }
                if (n > 2) {
                    return false;
                }
            }
            return true;
        }
    }
}
