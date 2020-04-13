package com.leetcode;

public class MergeTwoSortedLists {

    public static void main(String...args){
        var i = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode result = i.mergeTwoLists(l1,l2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static class  ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null, current = new ListNode(-1);


        while(l1 != null || l2 !=null){
            if(l1 == null){
                current.next = l2;
                l2 = l2.next;

            } else if(l2 == null){
                current.next = l1;
                l1 = l1.next;

            } else if(l1.val <= l2.val){
                current.next  = l1;
                l1 =l1.next;
            } else {
                current.next  = l2;
                l2 = l2.next;
            }
            if(root == null){
                root = current;
            }

           //System.out.println(current.val);
            current = current.next;
        }

        if(root == null){
            return null;
        } else {
            return root.next;
        }

    }
}

