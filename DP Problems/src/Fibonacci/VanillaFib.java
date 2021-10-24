package Fibonacci;

public class VanillaFib {
    public static void main(String args[]){
        VanillaFib vanillaFib = new VanillaFib();
        System.out.println(vanillaFib.fib(7)); //13
        System.out.println(vanillaFib.fib(70)); //?
    }

    int fib(int n){
        if(n < 1) return -1;
        if(n == 1 || n== 2) return 1;
        return fib(n-1) + fib(n-2);
    }
}
//T = O(2^n)
//S = O(n), as n is the height of the recursion tree
