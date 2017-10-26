package com.whut.util;

public class BinarySearchTree {
    private Node root;
    private class Node{
        private int value;
        private Node left,right;
        public Node(){

        }
        public Node(int value,Node left,Node right){
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }
    //查找
    public boolean get(int key){
        Node current=root;
        while (current!=null){
            if (key==current.value) return true;
            else if (key<current.value) current=current.left;
            else current=current.right;
        }
        return false;
    }
    //插入
    public void put(Node node){
        Node current=root;
        Node prev=null;
        while (current!=null){
            prev=current;
            if (node.value<current.value) {
                current=current.left;
            }else if (node.value>current.value){
                current=current.right;
            }else return ;
        }
        if (node.value<prev.value) prev.left=node;
        else prev.right=node;
    }
    //删除
    public boolean delete(int key){
        Node current=root;
        Node prev=root;
        while (current!=null){
            prev=current;
            if (key<current.value) current=current.left;
            else if (key>current.value) current=current.right;
            else break;
        }
        if (prev.value==key) {
            delete(prev);
            return true;
        }else return false;
    }
    public void delete(Node node){
        if (node.left==null){
            node=node.right;
        }else if (node.right==null){
            node=node.left;
        }else {

        }
    }
}
