import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 合并区间 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= intervals[i-1][1]){
                intervals[i] = new int[]{intervals[i-1][0], Math.max(intervals[i][1],intervals[i-1][1])};
            } else{
                result.add(new int[]{intervals[i-1][0], intervals[i-1][1]});
            }
            if(i+1 > intervals.length-1){
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return result.toArray(new int[0][]);
    }
}
