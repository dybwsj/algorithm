public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int max = 0;
        for(int i = 0; i < length; i++){
            if(i <= max){
                max = Math.max(max, i + nums[i]);
            }
            if(max >= length-1) return true;
        }
        return false;
    }
}
