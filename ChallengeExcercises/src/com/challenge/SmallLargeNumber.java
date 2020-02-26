package com.challenge;

import java.io.IOException;
import java.util.Scanner;

public class SmallLargeNumber {

    public static void main(String[] args) {
        int min = 0;
        int max = 0;
        //Read from command line the size of numeric array
        System.out.println("Enter array size: ");
        Scanner in = new Scanner(System.in);
        String s = in. nextLine();
        int size = 0;
        if(s != null && !s.isEmpty()){
            size = Integer.valueOf(s);
        }
        //Create random numeric array
        int numberArray [] = new int[size];
        System.out.println("Numeric array: ");
        for(int i = 0; i < size; i++){
            numberArray[i] = (int) (Math.random()*100);
            System.out.print(" " + numberArray[i]);
        }
        System.out.println();
        min = numberArray[0];
        max = numberArray[0];
        for(int i = 0; i < size; i++){
            if(min > numberArray[i]){
                min = numberArray[i];
            }
            if(max < numberArray[i]){
                max = numberArray[i];
            }
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
