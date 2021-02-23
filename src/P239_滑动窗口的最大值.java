import java.util.Arrays;
import java.util.LinkedList;

public class P239_滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * 暴力——超时
         */
//        int length = nums.length;
//        int[] res = new int[length];
//        int j = 0;
//        for (int i = 0; i <= length - k; i++) {
//            res[j++] = findMaxValue(nums, i, i + k);
//        }
//        return Arrays.copyOf(res, j);
//    }
//
//    private int findMaxValue(int[] nums, int start, int end) {
//        int max = nums[start];
//        for (int i = start + 1; i < end; i++) {
//            if (nums[i] > max) max = nums[i];
//        }
//        return max;
//    }

        /**
         * 单调栈
         */
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
