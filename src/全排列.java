import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        boolean[] m = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        back(nums, 0, path, res, m);

        return res;
    }
    private void back(int[] nums, int mark, List<Integer> path, List<List<Integer>> res,boolean[] m){
        if(mark == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!m[i]){
                m[i] = true;
                path.add(nums[i]);
                back(nums, mark+1, path, res, m);
                m[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
