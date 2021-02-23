import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args){
        在排序数组中查找元素的第一个和最后一个位置 s = new 在排序数组中查找元素的第一个和最后一个位置();
        System.out.println(Arrays.toString(s.searchRange(new int[]{1},1)));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int left = findLeft(nums,target);
        if(left == nums.length || nums[left] != target) return result;
        result[0] = left;
        result[1] = findRight(nums,target)-1;

        return result;
    }
    private int findLeft(int[] nums, int target){
        int start = 0;
        int end = nums.length;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= target) end = mid;
            else start = mid+1;
        }
        return start;

    }
    private int findRight(int[] nums, int target){
        int start = 0;
        int end = nums.length;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] <= target) start = mid+1;
            else end = mid;
        }
        return end;
    }
}
