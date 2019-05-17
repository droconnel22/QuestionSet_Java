package com.crackingcodeinterview;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class LinkedListCycle {

    @Setter
    @Getter
    @AllArgsConstructor
    private class Node {
        public  Integer Value;

        public Node Next;
    }

    private Node root;

    public void ScenarioWithCycle(){

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for(int i : arr){
            if(root== null){
                root    = new Node(i,null);
            } else {
                Node current = root;
                while(current.Next != null){
                    current = current.Next;
                }

                current.Next = new Node(i, null);
            }
        }
        // Add known loop

        Node end = root;
        while(end.Next != null){
            end = end.Next;
        }
        end.Next = root;

        boolean result = CheckCycle();
        System.out.println("LL has cycle?: "+ result + " !");
    }

    public boolean CheckCycle(){
        //Fast pointer
        Node fast = root.Next.Next;
        Node slow = root.Next;

        while(fast != slow && fast != null && slow != null){
            fast = fast.Next.Next;
            slow  = slow.Next;
        }

        if(fast == null || slow == null ) return false;
        return true;
    }
}
