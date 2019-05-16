package com.hackerrank.bitmath;

import java.util.BitSet;
import java.util.Scanner;

public class BitArrayDemo {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int bitSetLength = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        BitSet b1 = new BitSet(bitSetLength);
        BitSet b2 = new BitSet(bitSetLength);
        for(int i = 0; i < M; i++){

            String command = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            switch(command){
                case "AND":
                    if(a == 1){
                        b1.and(b2);
                    } else {
                        b2.and(b1);
                    }
                    break;
                case "SET":
                    if (a == 1){
                        b1.set(b);
                    } else {
                        b2.set(b);
                    }
                    break;
                case "FLIP":
                    if (a == 1){
                        b1.flip(b);
                    } else {
                        b2.flip(b);
                    }
                    break;

                case "OR":
                    if (a == 1){
                        b1.or(b2);
                    } else {
                        b2.or(b1);
                    }
                    break;
                case "XOR":
                    if (a == 1){
                        b1.xor(b2);
                    } else {
                        b2.xor(b1);
                    }
                    break;
                default:
                    break;
            }

            System.out.println(b1.cardinality() + " " + b2.cardinality() );

        }
    }
}
