package com.crackingcodeinterview;

import java.security.MessageDigest;
import java.util.Scanner;


public class MD5HashAlgo {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            Scanner scanner = new Scanner(System.in);
            MessageDigest md = MessageDigest.getInstance("MD5");

            String input = scanner.nextLine();
            byte[] bytesOfMessage = input.getBytes();
            md.update(input.getBytes());
            byte[] thedigest = md.digest();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < thedigest.length; i++){
                sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
            }
            System.out.println(sb.toString());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}