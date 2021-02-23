/**
 * @author: duyubo
 * @date: 2021年01月08日, 0008 10:51
 * @description:
 */
public class P189_旋转数组 {
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int num = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, num - 1);
        reverse(nums, num, length - num - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        for (int i = start, j = end; i <= mid && j >= mid; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
