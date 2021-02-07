public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) return -1;

        int start = 0;
        int end = length-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]) return mid;
            if(nums[start] <= nums[mid]){
                if(nums[mid] > target && nums[start] <= target)    end = mid - 1;
                else start = mid + 1;
            } else {
                if(nums[mid] < target && nums[end] >= target) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}
