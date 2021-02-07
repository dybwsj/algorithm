import java.util.HashMap;
import java.util.Queue;

public class 寻找两个正序数组的中位数 {

}

class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;   //算出每次迭代后数组剩余的长度
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        //当len1的长度为0时，中位数一定在len2里面，位置就是剩下的数组的起始位+K值（因为数组每次迭代都会确定一些不是中位数的值
        //所以k值每次迭代都会减少）
        if (len1 == 0) return nums2[start2 + k - 1];

        //当k等于1时表示寻找两个数组合并后的第一个数，所以可以取两个数组中的第一个数的最小值。
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        //找到k值的一半所对应的数组下标的值，可能会出现数组长度小于k值一半的情况，所以取两者最小值。
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}