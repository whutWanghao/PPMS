package com.whut.util;

public class StackByList {
    //用链表实现栈
    private Node header;
    private int end;
    private int index;
    public StackByList(){
        header=null;
        end=-1;
        index=0;
    }
    public boolean isEmpty(){
        return index==0;
    }
    public void push(Node node){
        if (end==0){
            header=node;
        }else {
            Node current= header;
            while (index!=end){
                index++;
                current=current.next;
            }
            current.next=node;
            end++;
            index=0;
        }
    }
    public Node pop(){
        Node current=header;
        Node prev=null;
        if (end==-1){
            return null;
        }else if (end==0){
            header=null;
            end=-1;
            return current;
        }else {
            while (index!=end){
                prev=current;
                index++;
                current=current.next;
            }
            prev.next=null;
            end--;
            index=0;
            return current;
        }

    }
    private class Node<E>{
        private E data;
        private Node next;
        public Node(E data,Node next){
            this.data=data;
            this.next=next;
        }
    }
}
