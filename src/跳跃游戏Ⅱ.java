import java.util.ArrayList;
import java.util.Arrays;

public class 跳跃游戏Ⅱ {

    public static void main(String[] args){
        System.out.println(jump(new int[] {2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;        //2
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);   //2  4  4
            if (i == end) {
                end = maxPosition;      //2 4
                steps++;        //1 2
            }
            if(end >= length-1) return steps;
        }
        return steps;
    }
}
