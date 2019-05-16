package com.crackingcodeinterview;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedNode<T> {

    private T value;

    private LinkedNode<T> next;

    public LinkedNode(T value) {
        this.value = value;
    }
}
