import java.util.PriorityQueue;

/**
 * @author: duyubo
 * @date: 2020年12月30日, 0030 10:20
 * @description: 最大堆
 */
public class P1046_最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int i = pq.poll();
            int j = pq.poll();
            if (i > j) {
                pq.add(i - j);
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();

//        for (int i = (length >> 1) - 1; i >= 0; i--) {
//            heapUp(stones, i, length);
//        }
    }


    /**
     * 数组不好实现删除
     */
//    private void heapUp(int[] stones, int i, int length) {
//        int left = (i << 1) + 1;
//        int right = (i << 1) + 2;
//        int max = i;
//        if (left < length && stones[left] > stones[i]) {
//            max = left;
//        }
//        if (right < length && stones[right] > stones[max]) {
//            max = right;
//        }
//        if (max == i) {
//            return;
//        }
//        swag(stones, i, max);
//        heapUp(stones, max, length);
//    }
//
//    private void swag(int[] stones, int i, int max) {
//        int temp = stones[i];
//        stones[i] = stones[max];
//        stones[max] = temp;
//    }
//
//    private void remove(int[] stones, int length) {
//        swag(stones, 0, length - 1);
//        heapUp(stones, 0, length - 1);
//    }
}
