import java.util.PriorityQueue;

/**
 * 优先队列——小根堆，第K大元素： 1、2、3，3为第一大元素。维护一个K大小的小根堆
 */
public class P703_数据流中的第K大元素 {
    PriorityQueue<Integer> pq;
    int k;

    public void KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
