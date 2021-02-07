import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: duyubo
 * @date: 2021年02月01日, 0001 09:09
 * @description:
 */
public class P888_公平的糖果棒交换 {
    public int[] fairCandySwap(int[] A, int[] B) {
//        int diff = 0;
//        boolean[] flags = new boolean[100001];
//        for(int num: A)
//            diff -= num;
//        for(int num: B){
//            diff += num;
//            flags[num] = true;
//        }
//        diff /= 2;
//        for(int num: A){
//            int numB = num + diff;
//            if(numB > 0 && numB < 100001 && flags[numB])
//                return new int[]{num, num + diff};
//        }
//        return null;
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        Arrays.sort(B);
        int difference = (sumA - sumB) / 2;
        for (int a : A) {
            if (isExist(a - difference, B)) {
                return new int[]{a, a - difference};
            }
        }
        return new int[]{0, 0};
    }

    private boolean isExist(int value, int[] B) {
        int start = 0;
        int end = B.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (B[mid] == value) {
                return true;
            } else if (B[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return false;
    }
}
