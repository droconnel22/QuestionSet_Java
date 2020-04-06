package com.crackingcodeinterview;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256HashAlgo {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String result = no.toString(16);

            System.out.println(result);
        } catch(NoSuchAlgorithmException ex){
            System.out.println(ex);
        }

    }
}
