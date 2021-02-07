import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

public class 两数之和 {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{1,3,5,6,8},7)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            } else {
                hashMap.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("no match");
    }
}