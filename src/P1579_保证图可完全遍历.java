import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author: duyubo
 * @date: 2021年01月27日, 0027 09:40
 * @description:
 */
public class P1579_保证图可完全遍历 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (edges.length < n - 1) return -1;
        Union union = new Union(n);
        Arrays.sort(edges, (int[] a, int[] b) -> b[0] - a[0]);
        for (int[] edge : edges) {
            union.union(edge[0], edge[1] - 1, edge[2] - 1);
        }
        return union.aliceSize == 1 && union.bobSize == 1 ? union.size : -1;
    }

    class Union {
        int size;
        int[] parentAlice;
        int[] parentBob;
        int aliceSize;
        int bobSize;
        Union(int size) {
            parentAlice = new int[size];
            parentBob = new int[size];
            aliceSize = size;
            bobSize = size;
            for (int i = 0; i < size; i++) {
                parentAlice[i] = i;
                parentBob[i] = i;
            }
        }
        void union(int z, int i, int j) {
            if (z == 3) {
                int a = findAlice(i);
                int b = findAlice(j);
                int c = findBob(i);
                int d = findBob(j);
                if (a == b && c == d) {
                    size++;
                    return;
                }
                parentAlice[a] = b;
                aliceSize--;
                parentBob[c] = d;
                bobSize--;
            }
            if (z == 1) {
                int a = findAlice(i);
                int b = findAlice(j);
                if (a != b) {
                    parentAlice[a] = b;
                    aliceSize--;
                } else {
                    size++;
                }
            }
            if (z == 2) {
                int c = findBob(i);
                int d = findBob(j);
                if (c != d) {
                    parentBob[c] = d;
                    bobSize--;
                } else {
                    size++;
                }
            }
        }

        int findAlice(int i) {
            if (parentAlice[i] != i) {
                parentAlice[i] = findAlice(parentAlice[i]);
            }
            return parentAlice[i];
        }
        int findBob(int i) {
            if (parentBob[i] != i) {
                parentBob[i] = findBob(parentBob[i]);
            }
            return parentBob[i];
        }
    }
}
