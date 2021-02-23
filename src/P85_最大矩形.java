public class P85_最大矩形 {
    public static void main(String[] args) {
        maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
    public static int maximalRectangle(char[][] matrix) {
        int area = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1' && j != 0) {
                    matrix[i][j] = (char) (matrix[i][j-1] + 1);
                }
                int minWidth = matrix[i][j] - '0';
                //向上扩展行
                for (int up_row = i; up_row >= 0; up_row--) {
                    int height = i - up_row + 1;
                    //找最小的数作为矩阵的宽
                    int aboveWidth = matrix[up_row][j] - '0';
                    minWidth = Math.min(minWidth, aboveWidth);
                    //更新面积
                    area = Math.max(area, height * minWidth);
                }
            }
        }
        return area;
    }
}
