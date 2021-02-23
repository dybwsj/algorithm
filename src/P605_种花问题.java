public class P605_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flag = -2;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                count += (i - flag - 2) / 2;
                flag = i;
            }
            if (count == n) return true;
        }
        count += ( flowerbed.length - flag -1) / 2;
        return count >= n;
    }
}
