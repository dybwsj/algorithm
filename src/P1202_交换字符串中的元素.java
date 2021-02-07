import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: duyubo
 * @date: 2021年01月11日, 0011 13:34
 * @description:
 */
public class P1202_交换字符串中的元素 {
    public static void main(String[] args) {

        Integer[] test1 = new Integer[]{2, 3, 1, 6, 4};
        Arrays.sort(test1, (o1, o2) -> o2 - o1);

        P1202_交换字符串中的元素 test = new P1202_交换字符串中的元素();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(3);
        res.add(list);
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        res.add(list1);
        List<Integer> list2 = new LinkedList<>();
        list2.add(0);
        list2.add(2);
        res.add(list2);
        test.smallestStringWithSwaps("dcab", res);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();
        UnionFind unionFind = new UnionFind(length);
        for (List<Integer> pair : pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }
        char[] chars = s.toCharArray();
        HashMap<Integer, PriorityQueue<Character>> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int parent = unionFind.find(i);
            PriorityQueue<Character> queue = hashMap.getOrDefault(parent, new PriorityQueue<>());
            queue.offer(chars[i]);
            hashMap.put(parent, queue);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            PriorityQueue<Character> characters = hashMap.get(unionFind.find(i));
            sb.append(characters.poll());
        }
        return sb.toString();
    }

    class UnionFind {
        private int size;
        private int[] parent;

        public UnionFind(int size) {
            this.size = size;
            this.parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            int a = find(i);
            int b = find(j);
            if (a == b) {
                return;
            }
            parent[find(i)] = find(j);
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
    }
}
//    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//        if (pairs.size() == 0) {
//            return s;
//        }
//
//        // 第 1 步：将任意交换的结点对输入并查集
//        int len = s.length();
//        UnionFind unionFind = new UnionFind(len);
//        for (List<Integer> pair : pairs) {
//            int index1 = pair.get(0);
//            int index2 = pair.get(1);
//            unionFind.union(index1, index2);
//        }
//
//        // 第 2 步：构建映射关系
//        char[] charArray = s.toCharArray();
//        // key：连通分量的代表元，value：同一个连通分量的字符集合（保存在一个优先队列中）
//        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
//        for (int i = 0; i < len; i++) {
//            int root = unionFind.find(i);
//            if (hashMap.containsKey(root)) {
//                hashMap.get(root).offer(charArray[i]);
//            } else {
//                // PriorityQueue<Character> minHeap = new PriorityQueue<>();
//                // minHeap.offer(charArray[i]);
//                // hashMap.put(root, minHeap);
//                // 上面三行代码等价于下面一行代码，JDK 1.8 以及以后支持下面的写法
//                hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(charArray[i]);
//            }
//        }
//
//        // 第 3 步：重组字符串
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < len; i++) {
//            int root = unionFind.find(i);
//            stringBuilder.append(hashMap.get(root).poll());
//        }
//        return stringBuilder.toString();
//    }
//
//    private class UnionFind {
//
//        private int[] parent;
//        /**
//         * 以 i 为根结点的子树的高度（引入了路径压缩以后该定义并不准确）
//         */
//        private int[] rank;
//
//        public UnionFind(int n) {
//            this.parent = new int[n];
//            this.rank = new int[n];
//            for (int i = 0; i < n; i++) {
//                this.parent[i] = i;
//                this.rank[i] = 1;
//            }
//        }
//
//        public void union(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            if (rootX == rootY) {
//                return;
//            }
//
//            if (rank[rootX] == rank[rootY]) {
//                parent[rootX] = rootY;
//                // 此时以 rootY 为根结点的树的高度仅加了 1
//                rank[rootY]++;
//            } else if (rank[rootX] < rank[rootY]) {
//                parent[rootX] = rootY;
//                // 此时以 rootY 为根结点的树的高度不变
//            } else {
//                // 同理，此时以 rootX 为根结点的树的高度不变
//                parent[rootY] = rootX;
//            }
//        }
//
//        public int find(int x) {
//            if (x != parent[x]) {
//                parent[x] = find(parent[x]);
//            }
//            return parent[x];
//        }
//    }