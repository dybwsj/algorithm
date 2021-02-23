import java.util.LinkedList;
import java.util.List;

public class 计算x的n次幂函数 {

    //递归
//    public double myPow(double x, int n) {
//        long m = (long)n;
//        if(n < 0) return 1.0/digui(x, -m);
//        return digui(x, m);
//    }
//
//    private double digui(double x, long n){
//        if(n == 0) return 1.0;
//        double res = digui(x, n/2);
//        return n % 2 == 1 ? x * res * res : res * res;
//    }

    //迭代
    public double myPow(double x, int n) {
        long N = n;
        int mark = 0;
        if(N < 0){
            mark = 1;
            N = -N;
        }
        double ans = 1.0;
        double x_contribute = x;
        while(N > 0){
            if(N % 2 == 1)
                ans *= x_contribute;
            x_contribute*=x_contribute;
            N/=2;
        }
        if(mark == 1) return 1.0/ans;

        return ans;
    }
}
