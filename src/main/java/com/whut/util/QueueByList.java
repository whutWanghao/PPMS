package com.whut.util;

public class QueueByList {
    //基于链表来实现队列
    private Node head;
    private int index;
    private int size;
    public void push(Node node){
        Node current=head;
        Node prev=head;
        if (size==0){
            head=node;
            return;
        }
        while (index+1!=size){
            prev=current;
            index++;
            current=current.next;
        }
        prev.next=node;
        index=0;
        size++;
    }
    public Node poll(){
        Node current=head;
        if (size==0) return null;
        if (size==1) {
            head=null;
            return current;
        }
        head=current.next;
        size--;
        current.next=null;
        return current;
    }
    private class Node<E>{
        E data;
        Node next;
    }

}
