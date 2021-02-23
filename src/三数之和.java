import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class 三数之和 {
}

class Solution16 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] > 0){
                break;
            }
            if (nums[i] == nums[i+1]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            int sum = -nums[i];
            while (start < end){
                if (sum + nums[start] + nums[end] == 0){
                    list.add(new ArrayList<>(Arrays.asList(nums[i],nums[start],nums[end])));
                    start++;
                    end++;
                    while (start < end && nums[start] == nums[start+1]) start++;
                    while (start < end && nums[end] == nums[end-1]) end--;
                } else if(nums[start] + nums[end] + sum < 0){
                    start++;
                } else {
                    end--;
                }
            }
        }
        return list;
    }
}