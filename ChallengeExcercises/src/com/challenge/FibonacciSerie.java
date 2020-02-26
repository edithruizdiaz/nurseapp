package com.challenge;

import java.util.Scanner;

public class FibonacciSerie {
//    public static long fibonacciArray[];

    public static void main(String[] args) {
        System.out.println("Enter fibonacci array size: ");
        Scanner in = new Scanner(System.in);
        String s = in. nextLine();
        int num = 0;
        if(s != null && !s.isEmpty()){
            num = Integer.valueOf(s);
        }

        long fibonacciArray[] = new long[num];
//        fibonacciArray[0]=0;
//        fibonacciArray[1]=1;
        fibonacci(num-1, fibonacciArray);
        for(int i= 0; i < num; i++){
            System.out.println(String.format("%d. %d", i+1, fibonacciArray[i]));
        }
    }

    public static long fibonacci(long n, long[] arr) {
        long fibValue = 0;
        if (n == 0) {
            arr[(int) n] = 0;
            return 0;
        } else if (n == 1) {
            arr[(int) n] = 1;
            return 1;
        } else if (arr[(int) n] != 0) {
            return arr[(int) n];
        } else {
            fibValue = fibonacci(n - 1, arr) + fibonacci(n - 2, arr);
            arr[(int) n] = fibValue;
            return fibValue;
        }
    }

}
