package com.whut.util.Qunar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        String[] str=input.nextLine().split(" ");
        LRUCache cache=new LRUCache(Integer.parseInt(str[0]));
        int num=Integer.parseInt(str[1]);
        for (int i=0;i<num;i++){
            String[] commands=input.nextLine().split(" ");
            if (commands[0].equals("put")){
                Node node=new Node(commands[1],commands[2]);
                cache.put(commands[1],commands[2]);
            }
            if(commands[0].equals("get")){
                System.out.println(cache.get(commands[1]));
            }
        }
    }
}
class LRUCache{
    int capacity;
    Map<String,Node> map=new HashMap<>();
    Node head=null;
    Node end=null;
    public LRUCache(int capacity){
        this.capacity=capacity;
    }
    public String get(String key){
        if (map.containsKey(key)){
            Node n=map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return "null";
    }
    public void put(String key,String value){
        if (map.containsKey(key)){
            Node oldNode=map.get(key);
            oldNode.value=value;
            remove(oldNode);
            setHead(oldNode);
        }else {
            Node node=new Node(key,value);
            if (map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(node);
            }else {
                setHead(node);
            }
            map.put(key,node);
        }
    }
    public void remove(Node n){
        if (n.pre!=null){
            n.pre.next=n.next;
        }else {
            head=n.next;
        }
        if (n.next!=null){
            n.next.pre=n.pre;
        }else {
            end=n.pre;
        }
    }
    public void setHead(Node n){
        n.next=head;
        n.pre=null;
        if (head!=null){
            head.pre=n;
        }
        head=n;
        if (end==null) end=head;
    }
}
class Node{
    String key;
    String value;
    Node pre;
    Node next;
    public Node(String key,String value){
        this.key=key;
        this.value=value;
    }
}