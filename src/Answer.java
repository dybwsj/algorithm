import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author duyubo
 * @date 2021/1/13
 */
public class Answer {
    public static void main(String[] args) {
//        merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        antiClockwiseTraverse(new int[][]{{1,2,3},{4,5,6},{20,21,22}});
    }

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        List<List<Integer>> result = new LinkedList<>();
        int begin = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < length; i++) {
            List<Integer> one = new ArrayList<>(2);
            if (intervals[i][0] <= end) {
                end = intervals[i][1];
            } else {
                one.add(begin);
                one.add(end);
                result.add(one);
                begin = intervals[i][0];
                end = intervals[i][1];
            }
            if (i == length - 1) {
                List<Integer> two = new ArrayList<>(2);
                two.add(begin);
                two.add(end);
                result.add(two);
            }
        }
        int[][] test = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            test[i][0] = result.get(i).get(0);
            test[i][1] = result.get(i).get(1);
        }
        return test;
    }

    public static int[] antiClockwiseTraverse(int[][] array) {
        int length = array.length;
//        for (int i = 0; i < length/2; i++) {
//            for (int j = 0; j < length; j++) {
//                int temp = array[i][j];
//                array[i][j] = array[length - i - 1][j];
//                array[length - i - 1][j] = temp;
//            }
//        }
        int left = 0;
        int right = length;
        int top = 0;
        int bottom = length;
        int[] result = new int[length*length];
        int z = 0;
        while (top <= bottom-1 && left <= right-1) {
            for (int j = left; j < right; j++) {
                result[z++] = array[bottom - 1][j];
            }
            bottom--;
            for (int j = bottom-1; j >= top; j--) {
                result[z++] = array[j][right - 1];
            }
            right--;
            for (int j = right-1; j >= left; j--) {
                result[z++] = array[top][j];
            }
            top++;
            for (int j = top; j < bottom; j++) {
                result[z++] = array[j][left];
            }
            left++;
        }
        return result;
    }
}
