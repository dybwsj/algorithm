public class P765_情侣牵手 {
    public int minSwapsCouples(int[] row) {
        // 贪心
//        int length = row.length;
//        int num = 0;
//        for (int i = 0; i < length - 1; i+=2) {
//            int other = row[i] ^ 1;
//            if (other == row[i+1]) {
//                continue;
//            }
//            for (int j = i; j < length; j++) {
//                if (row[j] == other) {
//                    int temp = row[i+1];
//                    row[i+1] = row[j];
//                    row[j] = temp;
//                }
//            }
//            num++;
//        }
//        return num;

        // 贪心优化，预处理数据，省去循环寻找另一个数
        int length = row.length;
        int num = 0;
        int[] arr = new int[length];
        // 记录每个人对应的位置
        for (int i = 0; i < length; i++) {
            arr[row[i]] = i;
        }
        for (int i = 0; i < length - 1; i+=2) {
            int other = row[i] ^ 1;
            if (other == row[i+1]) {
                continue;
            }
            int temp = row[i+1];
            row[arr[other]] = temp;
            arr[row[i+1]] = arr[other];
            num++;
        }
        return num;

        // 还可以使用并查集解，情侣对数 N - 并查集节点个数 count = 需要交换的次数
    }
}
