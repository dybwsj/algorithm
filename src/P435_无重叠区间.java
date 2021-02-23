import java.util.Arrays;

/**
 * @author: duyubo
 * @date: 2020年12月31日, 0031 08:51
 * @description: 排序+贪心
 */
public class P435_无重叠区间 {
    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][] {{1,2},{2,3}});
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        //前一个数减后一个数为升序排序，反之为降序排序
        Arrays.sort(intervals, (int[] a, int[ ] b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int count = 0;
        for (int i = 0, j = 1; i < length && j < length; i++, j++) {
            if (intervals[i][1] > intervals[j][0]) {
                count++;
                i = intervals[i][1] < intervals[j][1] ? i - 1 : j - 1;
            } else {
                i = j - 1;
            }
        }
        return count;
    }
}
