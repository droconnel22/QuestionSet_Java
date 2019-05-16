package com.hackerrank.regex;

import java.util.HashMap;

public class IPAddressMatcher {

    public static String pattern ="^([01]?\\d\\d|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d|2[0-4]\\d|25[0-5])$";


    public static void main(String...args){

        String example = "266";
        String example2 = "12";

        //[01]?\\d\\d?|2[0-4]\\d|25[0-5]
        String rangepattern = "([01]?\\d\\d|2[0-4]\\d|25[0-5])";

        System.out.println(example.matches(rangepattern));
        System.out.println(example2.matches(rangepattern));


        String[] ips = {
                "12.12.12.12",
                "13.13.13.112",
                "VUUT.12.12",
                "111.111.11.111",
                "1.1.1.1.1.1.1",
                ".....",
                "1...1..1..1",
                "0.0.0.0",
                "255.0.255.0",
                "266.266.266.266",
                "00000.000000.0000000.00001",
                "0023.0012.0012.0034"
        };

        boolean[] expected = {
                true,
                true,
                false,
                true,
                false,
                false,
                false,
                true,
                true,
                false,
                false,
                false
        };


        for(int i = 0; i < ips.length && i < expected.length; i++){
            if(ips[i].matches(pattern) != expected[i]){
                System.out.println(ips[i]);
                System.out.println("Actual:" + ips[i].matches(pattern) + " Expected: " + expected[i]);
            }
        }
    }
}
