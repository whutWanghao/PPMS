package com.whut.util;

public class QueueByArray {
    private Object elements[];
    private int size;
    private int end;
    public QueueByArray(){
        elements=new Object[10];
        size=10;
        end=-1;
    }
    public boolean isEmpty(){
        return end==-1;
    }
    public void push(Object element){
        if (end+1<size){
            end++;
            elements[end]=element;
        }else {
            System.out.println("队列已经满");
        }
    }
    public Object poll(){
        Object res=elements[0];
        for (int i=0;i<end;i++){
            elements[i]=elements[i+1];
        }
        end--;
        return res;
    }
}
