import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: duyubo
 * @date: 2021年02月03日, 0003 13:47
 * @description:
 */
public class P480_滑动窗口中位数 {
    public static void main(String[] args) {
        P480_滑动窗口中位数 s = new P480_滑动窗口中位数();
        s.medianSlidingWindow(new int[]{1, 4, 2, 3}, 4);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        //大顶堆用于存放小于中位数的值
        PriorityQueue<Long> bigHeap = new PriorityQueue<>((o1, o2) -> {
            if (o2 - o1 > 0) return 1;
            if (o2.equals(o1)) return 0;
            return -1;
        });
        //小顶堆用于存放大于等于中位数的值
        PriorityQueue<Long> smallHeap = new PriorityQueue<>();
        //初始化 两个堆
        for (int i = 0; i < k; i++) {
            smallHeap.add((long) nums[i]);
        }
        int half = k / 2;
        while (half > 0) {
            bigHeap.add(smallHeap.poll());
            half--;
        }
        double[] res = new double[nums.length - k + 1];
        // 根据k值来得到第一个窗口的中位数
        if (k % 2 == 0) res[0] = (double) (smallHeap.peek() + bigHeap.peek()) / 2;
        else res[0] = smallHeap.peek();
        for (int i = k; i < nums.length; i++) {//从k开始遍历数字
            int curNumber = nums[i];//当前遍历的数字
            int removeNumber = nums[i - k];//滑动窗口移除的数字

            if (!bigHeap.isEmpty() && removeNumber <= bigHeap.peek())//如果移除的数字小于等于大顶堆的堆顶，那么从大顶堆中移除
                bigHeap.remove(Long.valueOf(removeNumber));
            else smallHeap.remove(Long.valueOf(removeNumber));//否则从小顶堆中移除

            if (smallHeap.size() != 0 && curNumber >= smallHeap.peek()) {//若当前的数字大于小顶堆的堆顶，那么就加入小顶堆中
                smallHeap.add((long) curNumber);
            } else bigHeap.add((long) curNumber);//否则加入大顶堆

            //维护两个堆的大小，小顶堆的大小 = 大顶堆的大小 或者 小顶堆的大小 = 大顶堆的大小 + 1
            while (bigHeap.size() > smallHeap.size()) smallHeap.add(bigHeap.poll());
            while (smallHeap.size() > bigHeap.size() + 1) bigHeap.add(smallHeap.poll());
            // 根据k值来得到中位数
            if (k % 2 == 0) res[i - k + 1] = (double) (smallHeap.peek() + bigHeap.peek()) / 2;
            else res[i - k + 1] = smallHeap.peek();
        }
        return res;
    }

}
