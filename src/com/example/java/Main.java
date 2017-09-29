package com.example.java;

public class Main {

    public static void main(String[] args) {

        /*
            This program is a solution to CCI book problem 5.1. This program will invoke the updateBits
            method and pass two 32 bit number N2, and M2. The method will insert M2 into N2 starting
            at bit j and ending at bit i.
         */
        int N2 = 0b10000000000;
        int M2 = 0b10011;

        int i = 2, j = 6, result, result2;

        result = updateBits(N2,M2,i,j);

//        The result will be 1100 decimal with bit representation 10001001100
        System.out.println("Result with passing binary data in the integer data as a parameter: " + result);
        System.out.println("Result in bit representation: " + Integer.toBinaryString(result));

    }

    static int updateBits(int n, int m, int i, int j){
//        Create a mask to clear bits i through j in n. EXAMPLE: i = 2, j = 4.
//        Result should be 11100011. For simplicity, we'll use just 8 bits for the example.

        int allOnes = ~0; // will equal sequence of all 1s
        System.out.println("allOnes output: " + Integer.toBinaryString(allOnes));

//        1s before position j, then 0s. left = 11100000
        int left = allOnes << (j + 1);
        System.out.println("left output: " + Integer.toBinaryString(left));

//        1's after position i. right =  00000011
        int right = ((1 << i) - 1);
        System.out.println("right output: " + Integer.toBinaryString(right));

//        All 1s, except for 0s between i and j. mask = 11100011
        int mask = left | right;
        System.out.println("mask output: " + Integer.toBinaryString(mask));

//        Clear bits j through i then put m in there.
        int n_cleared = n & mask;   //Clear bits j and i.
        int m_shifted = m << i;     //Move m into correct position.
        System.out.println("n_cleared output: " + Integer.toBinaryString(n_cleared));
        System.out.println("m_shifted output: " + Integer.toBinaryString(m_shifted));

        return n_cleared | m_shifted;       // OR them, and we're done.


    }

}
