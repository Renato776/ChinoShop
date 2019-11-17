package com.edd;

public class Node {
    public Node next;
    public  Node prev;
    public RData data;
    public  Node(){
        prev = null;
        next = null;
        data = null;
    }
    public Node(RData d){
        data = d;
        next = null;
        prev = null;
    }
}
