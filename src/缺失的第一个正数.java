public class 缺失的第一个正数 {
    public static void main(String[] args){
        System.out.println(firstMissingPositive(new int[] {-1,3,3,4}));
    }
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            //注意：这里的第二个判断条件不能是nums[i] != i+1;
            //因为果有重复的在1~N范围内的某个数，就会出现死循环。
            //例如[3,3,4,-1]当交换至[-1,3,3,4]时i=1，无论交换多少次nums[i]都永远只会是3。
            //所以应该是nums[i] != nums[nums[i] - 1]。
            //判断该值有没有放到该放的位置。不应该判断该位置有没有该放的值。
            while(nums[i] > 0 && nums[i] != nums[nums[i] - 1] && nums[i] <= len){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }

        for(int j = 0; j < len; j++){
            if(nums[j] != j+1) return j+1;
        }
        return len+1;
    }
}
