import java.util.HashMap;

public class 排序算法 {

    public static void main(String[] args){
        int[] arr = { 2,4,9,7 };
        排序算法 s = new 排序算法();
        HashMap hm = new HashMap();
        hm.put(1, 2);
        hm.put(1, 3);
        s.kuaipai(arr, 0, arr.length - 1);
    }
    /**
     * 冒泡排序
     * 思路：外层循环从1到n-1，内循环从当前外层的元素的下一个位置开始，依次和外层的元素比较，
     * 出现逆序就交换，通过与相邻元素的比较和交换来把小的数交换到最前面。
     * @param nums
     */
    public void maopao(int[] nums){
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i; j < nums.length-1-i; j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

    }

    /**
     * 选择排序
     * 思路：冒泡排序是通过相邻的比较和交换，每次找个最小值。
     * 选择排序是：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     *
     */
    public void xuanze(){

    }

    /**
     * 插入排序
     * 思路：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 可以理解为玩扑克牌时的理牌；
     */
    public void charu(){

    }

    /**
     * 希尔排序
     * 思路：希尔排序是插入排序的一种高效率的实现，也叫缩小增量排序。
     * 先将整个待排记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录基本有序时
     * 再对全体记录进行一次直接插入排序。
     *
     * 问题：增量的序列取法？
     * 关于取法，没有统一标准，但最后一步必须是1；因为不同的取法涉及时间复杂度不一样，
     * 具体了解可以参考《数据结构与算法分析》；一般以length/2为算法。（再此以gap=gap*3+1为公式）
     */
    public void xier(){

    }

    /**
     * 归并排序
     * 思路：将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     * 若将两个有序表合并成一个有序表，称为2-路归并。它使用了递归分治的思想；相当于：左半边用尽，
     * 则取右半边元素；右半边用尽，则取左半边元素；右半边的当前元素小于左半边的当前元素，
     * 则取右半边元素；右半边的当前元素大于左半边的当前元素，则取左半边的元素。
     */
    public void guibing(){

    }

    /**
     * 快速排序
     * 思路：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序
     */
    public void kuaipai(int arr[], int low, int high){
        int l = low;
        int h = high;
        int k = arr[low];
        while (l < h) {
            // 从后往前比较
            while (l < h && arr[h] >= k ){ // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                h--;// h=6
            }
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                //进行过一次替换后，没必要将替换后的两值再次比较，所以i++直接下一位与k对比
                l++;
            }
            // 从前往后比较
            while (l < h && arr[l] <= k) { // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                l++;
            }
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
            // 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        print(arr);
        System.out.print("l=" + l + "h=" + h + "k=" + k + "\n");
        // 递归
        if (l > low)//先判断l>low再次经行左边排序
            kuaipai(arr, low, l - 1);// 左边序列。第一个索引位置到关键值索引-1
        if (h < high)//左边依次排序执行完递归后，弹栈进行右边排序
            kuaipai(arr, l + 1, high);// 右边序列。从关键值索引+1到最后一个
    }
    private static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != (arr.length - 1)) {
                System.out.print(arr[i] + ",");
                } else {
                System.out.print(arr[i] + "]");
                System.out.println();
                }
            }
    }

    /**
     * 堆排序(最大堆、最小堆)
     * 思路：堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
     */
    public void duipaixu(){

    }

}
