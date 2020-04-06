package com.contests;

// A string is called happy if it does
// not have any of the strings 'aaa',
// 'bbb' or 'ccc' as a substring.
// Given three integers a, b and c, return any string s,
// which satisfies following conditions:
// s is happy and longest possible.
//s contains at most a occurrences of the letter 'a',
// at most b occurrences of the letter 'b'
// and at most c occurrences of the letter 'c'.
//s will only contain 'a', 'b' and 'c' letters.
//If there is no such string s return the empty string "".

import java.util.*;

/* Constraints:
    0 <= a, b, c <= 100
    a + b + c > 0
 */
public class LongestHappyString1405 {
    public String longestDiverseString(int a, int b, int c) {

        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> queue = new HashMap<>();
        queue.put('a',a);
        queue.put('b',b);
        queue.put('c',c);

        Character previous = null;
        while(!queue.isEmpty()) {

            var entrySet = queue.entrySet().stream()
                    .max((Map.Entry.comparingByValue()));

            var currentSet = entrySet.get();
            if(currentSet.getKey().equals(previous)){
                break;
            }
            previous = currentSet.getKey();
            int i = 2;
            int remainder = currentSet.getValue();
            while(i > 0 &&  remainder > 0) {
                sb.append(currentSet.getKey());
                i--;
                remainder--;
            }
            if(remainder == 0){
                queue.remove(currentSet.getKey());
            } else {
                queue.put(currentSet.getKey(),remainder);
            }
        }

        return sb.toString();
    }

    public static void main(String...args){
        var l = new LongestHappyString1405();
        System.out.println(l.longestDiverseString(1,1,7));
    }

}
/*
My explanation about the intuition of this approach.

First of all, it's just like playing a poker game with a greedy strategy.
Suppose you're a single player of this game, the goal is to escape as
 many cards in your hand as possible, with a restriction rule that you
  can't escape 3 same cards in a row. Now let's start playing the poker game,
   every round, you have to organize those cards in your hand (three types: 'a', 'b', 'c'),
    with an order of a >= b >= c.

    if (a < b) // this condition determines: a >= b
        return longestDiverseString(b, a, c, bb, aa, cc);
    if (b < c) // this condition determines: b >= c
        return longestDiverseString(c, b, a, cc, bb, aa);
    // with the two conditions above, we can confirm: a >= b >= c
After organizing the order of cards in your hand, you start escaping! There're theoretically 3 cases:
- Case 1: a > 0, b = 0, c = 0: now you only have the chance to escape min(a, 2)
cards, otherwise you break the 3-card-in-a-row rule;
- Case 2: a >= b >= 1, c whatever: now you have to escape min(a, 2) number of 'a'
cards first. After that, check if a >= b is satisfied, then you can follow another
'b' here. However, if a < b please don't escape 'b'. The reason is that if you do so,
 in the next round 'b' would be the one with the largest number (a simple proof: b > a && b >=c),
 then you'll get risk breaking the 3-card-in-a-row rule.

    // Case 1
    if (b == 0)
        return aa.repeat(Math.min(2, a));
    // Case 2
    int use_a = Math.min(2, a), use_b = a - use_a >= b ? 1 : 0;
    return aa.repeat(use_a) + bb.repeat(use_b) +
        generate(a - use_a, b - use_b, c, aa, bb, cc);
The only point is, the explained approach above can only
determine each round's best strategy, but not necessarily
 guaranteed to be the globally best strategy. That's why I
 feel like it's sort of greedy strategy. If someone is interested,
  please prove the correctness of this approach, I'll be very appreciated.
 */
 class LongestHappyString1405Answer {

    private String generate(int lg, int med, int sm, String aa, String bb, String cc) {
        if (lg < med) {
            return generate(med,lg,sm, bb,aa,cc);
        }
        if(med < sm) {
            return generate(lg,sm,med,aa,cc,bb);
        }

        if(med == 0){
            return aa.repeat(Math.min(2,lg));
        }

        int use_a = Math.min(2,lg),  use_b = lg - use_a >= med ? 1 : 0;
        return aa.repeat(use_a) + bb.repeat(use_b) +
                generate(lg - use_a, med- use_a,sm,aa, bb,cc);
    }

    public String longestDiverseString(int a, int b, int c) {
        return generate(a, b, c, "a", "b", "c");
    }
}
