package com.hackerrank.strings;

public class Program {

    public static void main(String... args){
        String A= "hello";
        String B= "java";
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.printf("%s %s", Capitalize(A), Capitalize(B));
    }

    private static String Capitalize(String s){
         return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
