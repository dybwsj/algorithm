import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class 两数相除 {
    public int divide(int dividend, int divisor) {
        if(divisor == -1 && dividend == Integer.MIN_VALUE)  return Integer.MAX_VALUE;
        if(divisor == 1)    return dividend;
        if(divisor == -1)    return -dividend;
        int make = 1;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)  make = -make;
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        if(dividend > divisor) return 0;
        int result = sum(dividend, divisor);
        return result*make;
    }

    private int sum(int a, int b){
        if(a > b) return 0;
        int c = 1;
        int d = b;
        while(b+b >= a && b+b < 0){
            b+=b;
            c+=c;
        }

        return c+sum(a-b,d);
    }
}
