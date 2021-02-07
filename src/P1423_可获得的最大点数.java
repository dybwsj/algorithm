/**
 * @author: duyubo
 * @date: 2021年02月06日, 0006 09:13
 * @description:
 */
public class P1423_可获得的最大点数 {
    public static void main(String[] args) {
        P1423_可获得的最大点数 s = new P1423_可获得的最大点数();
        s.maxScore(new int[]{1,2,3,4,5,6,1},3);
    }
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int length = cardPoints.length;
        int window = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int total = 0;
        for (int temp : cardPoints) {
            total += temp;
        }
        if (length == k) return total;
        for (; right < length; right++) {
            window += cardPoints[right];
            if (length - right - 2 < k) {
                max = Math.max(max, total - window);
                window -= cardPoints[left];
                left++;
            }
        }
        return max;
    }
}
