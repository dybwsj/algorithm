public class 接雨水 {
    public int trap(int[] height) {
        int length = height.length;     //3
        int total = 0;
        for(int i = 0; i < length; i++){
            int left = findLeft(height, i);
            int right = findRight(height, i);
            int min = Math.min(left,right);
            if(min > height[i])
                total = total + min - height[i];   //0
        }
        return total;
    }
    private int findLeft(int[] height, int i){
        int left = 0;
        while(--i >= 0){
            if(height[i] > left) left = height[i];
        }
        return left;
    }
    private int findRight(int[] height, int i){
        int right = 0;
        while(++i < height.length){
            if(height[i] > right) right = height[i];
        }
        return right;
    }
}
