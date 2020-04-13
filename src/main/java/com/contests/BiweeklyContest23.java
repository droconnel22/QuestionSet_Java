package com.contests;

import java.util.*;

public class BiweeklyContest23 {

    public static void main(String...args) {
        var contest = new BiweeklyContest23();
        int problem = 2;
        switch (problem){
            case 1 -> {

                System.out.println(contest.countLargestGroup(13));
                System.out.println(contest.countLargestGroup(2));
                System.out.println(contest.countLargestGroup(15));
                System.out.println(contest.countLargestGroup(24));
            }
            case 2-> {
                System.out.println(contest.canConstruct("yzyzyzyzyzyzyzy",2));
            }
            default ->  System.out.println("Wrong");
        }
    }

    /*
    Given an integer n.
    Each number from 1 to n is grouped according to the sum of its digits.
    Return how many groups have the largest size.
    Input: n = 13
    Output: 4
    Explanation: There are 9 groups in total,
    they are grouped according sum
    of its digits of numbers from 1 to 13:
    [1,10], [2,11], [3,12], [4,13],
    [5], [6], [7], [8], [9].
    There are 4 groups with largest size.

    Input: n = 2
    Output: 2
    Explanation: There are 2 groups [1], [2] of size 1.
     */
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        int i = 1;
        while (i <= n) {
            final String[] digits = Integer.toString(i).split("");
            int tempSum = 0;
            for (String d : digits) {
                tempSum += Integer.parseInt(d);
            }
            if (map.containsKey(tempSum)) {
                map.put(tempSum, map.get(tempSum) + 1);
            } else {
                map.put(tempSum, 1);
            }

            i++;
        }

        int largestCount = Integer.MIN_VALUE;
        int largetSize = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> es : map.entrySet()) {
            if(es.getValue() > largetSize){
                largestCount = 1;
                largetSize = es.getValue();
            } else if(es.getValue() == largetSize){
                largestCount++;
            }
        }

        return largestCount;
    }

    // 1400. Construct K Palindrome Strings
    /*
    Given a string s and an integer k. You should construct
    k non-empty palindrome strings using all the characters in s.

    Return True if you can use all the characters in s to
    construct k palindrome strings or False otherwise.

    Input: s =
    "annabelle", k = 2
    Output: true
    Explanation: You can construct
    two palindromes using all characters in s.
    Some possible constructions "anna" +
    "elble",
    "anbna" + "elle",
    "anellena" + "b"

    1 <= s.length <= 10^5
    All characters in s are lower-case English letters.
    1 <= k <= 10^5

    Input: s = "leetcode", k = 3
    Output: false
    Explanation: It is impossible to construct 3
     palindromes using all the characters of s.

     Input: s = "true", k = 4
    Output: true
    Explanation: The only possible solution
    is to put each character in a separate string.

    Input: s = "yzyzyzyzyzyzyzy", k = 2
    Output: true
    Explanation: Simply you can put all z's in one string
    and all y's in the other string.
    Both strings will be palindrome.Input: s = "cr", k = 7
    Output: false
    Explanation: We don't have enough characters in s to
    construct 7 palindromes.

     */
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        // K has to be less than N because
        // at max we can make N palindromes from a String of length N
        // eg. if all characters represent one palindrome, then we would have
        // N palindromes
        // since in all other scenarios at least one of the palindrome
        // can have more then 1 character
        // hence max limit to number of palindromes generated in this case
        // is N
        if(k > n){
            return false;
        }

        // We need to count odd numbered characters. Why?
        // Since any palindrome can contain at max 1 odd numbered char
        // that too in the cneter
        // if there are more odd numbered characters (o = k + c) then the
        // number of palidromes the given string can be broken into (k)
        // then those etra odd numbered characters can not be accomodated

        int odds = 0;
        int[] counts = new int[26]; // alphabet
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i)-'a']++;
        }
        for(int i : counts) {
            odds += i%2;
        }

        return odds <=k;

    }

    // 1401. Circle and Rectangle Overlapping
    /*
        Given a circle represented as (radius, x_center, y_center)
        and an axis-aligned rectangle represented as
        (x1, y1, x2, y2), where (x1, y1) are
        the coordinates of the bottom-left corner,
        and (x2, y2) are the coordinates of the top-right
        corner of the rectangle.

        Return True if the circle and rectangle
        are overlapped otherwise return False.

        /***
        In other words, check if there are any point (xi, yi) such
        that belongs to the circle and the rectangle at the same time.
        /***

        Input: radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
        Output: true
        Explanation: Circle and rectangle share the point (1,0)

        at least one square point must be less then or equal
        to circle

        Simply checking the that
     */




    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        // Find the closest point to the circle within the rectangle
        int closestX = calc(x_center, x1, x2);
        int closestY = calc(y_center, y1, y2);

        // Calculate the distance between the circle's center and this closest point
        int distanceX = x_center - closestX;
        int distanceY = y_center - closestY;

        // If the distance is less than the circle's radius, an intersection occurs
        int distanceSquared = (distanceX * distanceX) + (distanceY * distanceY);
        return distanceSquared <= (radius * radius);
    }
    public int calc(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }
}
