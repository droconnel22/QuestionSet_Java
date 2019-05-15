package com.hackerrank.strings;

import java.util.regex.Pattern;

public class RegexCompile {
    public static void main(String... args) {
        String[] patterns  ={" ([A-Z])(.+)", "[AZ[a-z](a-z)", "batcatpat(nat" };


        for(String pat : patterns){
            try {
                Pattern.compile(pat);
                System.out.println("Valid");
            } catch (Exception ex){
                System.out.println("Invalid");
            }

        }


    }
}
