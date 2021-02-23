import java.util.Arrays;

public class 螺旋矩阵Ⅱ {
    public static void main(String[] args){
        System.out.println(generateMatrix(3));
    }

    public static int[][] generateMatrix(int n) {
        int[][] resule = new int[n][n];
        if (n <= 0) return resule;

        int left = 0;
        int right = n;
        int top = 0;
        int bottom = n;
        int i = 1;
        while (top <= bottom-1 && left <= right-1) {
            for (int j = left; j < right; j++) {
                resule[top][j] = i++;
            }
            Arrays.fill(resule[0], 1);
            top++;
            for (int j = top; j < bottom; j++) {
                resule[j][right - 1] = i++;
            }
            right--;
            for (int j = right-1; j >= left; j--) {
                resule[bottom - 1][j] = i++;
            }
            bottom--;
            for (int j = bottom-1; j >= top; j--) {
                resule[j][left] = i++;
            }
            left++;
        }
        return resule;
    }
}
