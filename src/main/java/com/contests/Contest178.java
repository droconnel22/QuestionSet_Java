package com.contests;

import java.util.*;

// finish at 830 pm
public class Contest178 {

    public static void main(String...args) {
        var c = new Contest178();
        String[]  votes = {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(c.rankTeams(votes));
        String[] votes2 = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        System.out.println(c.rankTeams(votes2));
    }

    // 1365. How Many Numbers Are Smaller Than the Current Number
    /*
    Input: nums = [8,1,2,2,3]
    Output: [4,0,1,1,3]
    Explanation:
    For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
    For nums[1]=1 does not exist any smaller number than it.
    For nums[2]=2 there exist one smaller number than it (1).
    For nums[3]=2 there exist one smaller number than it (1).
    For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] result = new int[nums.length];
        for(int i =0; i < nums.length; i++) {
            result[i] = 0;
            for(int y = 0; y <nums.length; y++) {
                if(y != i && nums[i] > nums[y]) {
                    result[i]++;
                }
            }
        }
        return result;
    }

    // 1366. Rank Teams by Votes
    /*
    // In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.
    The ordering of teams is decided by who received the most position-one votes

     If two or more teams tie in the first position, we consider the second position to resolve the conflict

, if they tie again, we continue this process until the ties are resolved

If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.

Return a string of all teams sorted by the ranking system.

Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
Team B was ranked second by 2 voters and was ranked third by 3 voters.
Team C was ranked second by 3 voters and was ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team and team B is the third.

Input: votes = ["WXYZ","XYZW"]
Output: "XWYZ"
Explanation: X is the winner due to tie-breaking rule.
X has same votes as W for the first position
but X has one vote as second position
while W doesn't have any votes as second position.

Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
Explanation: Only one voter so his votes are used for the ranking.

Input: votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
Output: "ABC"
Explanation:
Team A was ranked first by 2 voters, second by 2 voters and third by 2 voters.
Team B was ranked first by 2 voters, second by 2 voters and third by 2 voters.
Team C was ranked first by 2 voters, second by 2 voters and third by 2 voters.
There is a tie and we rank teams ascending by their IDs.
     */
    public String rankTeams(String[] votes) {

        final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // seed election
        int numberOfCandidates = votes[0].length();
        int[][] election = new int[alpha.length()][numberOfCandidates];

        for(int submission = 0; submission < votes.length; submission++) {
            for(int vote = 0; vote < votes[submission].length(); vote++) {
                election[alpha.indexOf(votes[submission].charAt(vote))][vote]++;
            }
        }

        // array used to sort and build answer
        Character[] buffer = new Character[numberOfCandidates];
        for(int i = 0; i < buffer.length; i++){
            buffer[i] = votes[0].charAt(i);
        }

        Arrays.sort(buffer, (a,b) -> {
            for(int y =0; y < election[0].length;y++) {
                if(election[alpha.indexOf(a)][y] != election[alpha.indexOf(b)][y]) {
                    return election[alpha.indexOf(b)][y] - election[alpha.indexOf(a)][y];
                }
            }
            return a-b;
        });

        StringBuilder ans = new StringBuilder();
        for(int i =0; i <votes[0].length(); i++) {
            ans.append(buffer[i]);
        }

        return ans.toString();
    }

    // 1367. Linked List in Binary Tree
    /*
    Given a binary tree root and a linked list with head as the first node

    Return True if all the elements in the
    linked list starting from the head
    correspond to some downward path
    connected in the binary tree
    otherwise return False.

    In this context downward path means a
    path that starts at
    some node and goes downwards.

     Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     Output: true
    Explanation: Nodes in blue form a subpath in the binary Tree.
     */

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val=x;}
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val =x;}
    }

    // recrusion fun fun
    public boolean isSubPath(ListNode listNode, TreeNode treeNode) {
        // run out space
       if(treeNode == null)
           return false;

       return investigate(listNode,treeNode) ||
               isSubPath(listNode,treeNode.left) ||
               isSubPath(listNode,treeNode.right);
    }

    private boolean investigate(ListNode listNode, TreeNode treeNode) {

        // nothing left in list all done
        if(listNode == null)
            return true;

        // ran out of nodes int ree
        if(treeNode ==null)
            return false;

        // bad luck stop!
        if(listNode.val != treeNode.val)
            return false;

        // all equal keep going
        return investigate(listNode.next,treeNode.left) ||
                investigate(listNode.next,treeNode.right);
    }

    // 1368. Minimum Cost to Make at Least One Valid Path in a Grid

    public int minCost(int[][] grid) {
        return -1;
    }



}