import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args){
        System.out.println(Arrays.toString((combinationSum(new int[]{2, 2, 2, 2}, 8)).toArray()));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }


    private static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;
            //选择当前节点，类似于从当前节点开始往下遍历
            cur.add(candidates[i]);
            getResult(result, cur, candidates, target - candidates[i], i);
            //回到当前节点的时候我们把当前节点给移除,
            // 然后通过循环走同一层的其他节点。
            //举个例子，比如上面图中，最开始的时候
            // 我们先选择2，然后沿着这个分支走下去，
            //当回到当前分支的时候我们把2给移除，然后
            // 选择同一层的下一个3，沿着这个节点
            //分支走下去……
            cur.remove(cur.size() - 1);
        }
    }
}
