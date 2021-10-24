package Fibonacci;

import java.util.HashMap;
import java.util.Map;

public class DynamicFib {
    Map<Integer, Long> memoizedFib = new HashMap<>();
    public static void main(String args[]) {
        DynamicFib dynamicFib = new DynamicFib();
        System.out.println(dynamicFib.fib(7)); //13
        System.out.println(dynamicFib.fib(50)); //?
    }

    Long fib(int n){
        if (n < 1) return -1L;
        if (n == 1 || n == 2) return 1L;

        if (memoizedFib.containsKey(n)){
            return memoizedFib.get(n);
        }

        memoizedFib.put(n, fib(n - 1) + fib(n - 2));
        return memoizedFib.get(n);
    }
}
//T = O(2n) = O(n)
//S = O(n)
