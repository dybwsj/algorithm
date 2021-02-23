import java.util.Arrays;

/**
 * @author: duyubo
 * @date: 2020年12月24日, 0024 09:52
 * @description:
 */
public class P135_分发糖果 {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,3,4,5,2}));
    }
    public static int candy(int[] ratings) {
        int[] candyNum = new int[ratings.length];
        Arrays.fill(candyNum, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                candyNum[i + 1] = candyNum[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candyNum[i - 1] = Math.max(candyNum[i - 1], candyNum[i] + 1);
            }
        }
        return Arrays.stream(candyNum).sum();
    }
}
