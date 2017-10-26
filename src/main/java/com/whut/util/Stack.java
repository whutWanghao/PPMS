package com.whut.util;

public class Stack {
    //用数组实现栈
    private Object[] data;
    private int maxSize;
    private int top=-1;
    public Stack(){
        this.maxSize=10;
        data=new Object[maxSize];
        top=-1;
    }
    public Stack(int maxSize){
        this.maxSize=maxSize;
        data=new Object[maxSize];
        top=-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int value) throws Exception{
        if (top+1<maxSize) {
            top++;
            data[top]=value;
        }else{
            throw new Exception("堆栈已满");
        }
    }
    public Object pop(){
        Object res=data[top];
        top--;
        return res;
    }
    public Object peek(){
        return data[top];
    }
}
