package com.whut.util;

public class Game {
    public static void main(String[] args) {
        int i=0;
        //System.out.println(i=i+move(18,18));
        int j=3;
        int k=5;
        swap(j,k);
        System.out.println("j="+j+",k="+k);
        String s1="我是左边的字符串";
        String s2="我是右边的字符串";
        swap(s1,s2);
        System.out.println("s1="+s1+",s2="+s2);
        Point p1=new Point(1);
        Point p2=new Point(2);
        swap(p1,p2);
        System.out.println("p1="+p1.val+",p2="+p2.val);
        StringBuilder sb1=new StringBuilder("Hello");
        StringBuilder sb2=new StringBuilder("World");
        swap(sb1,sb2);
        System.out.println(sb1.toString()+sb2.toString());
    }
    public static int move(int i,int j){
        if (i==0&&j==0)
            return 0;
        if (i==1&&j==0)
            return 1;
        if (i==0&&j==1)
            return 1;
        if (i==0)
            return move(0,j-1);
        if (j==0)
            return move(i-1,0);
        return move(i-1,j)+move(i,j-1);
    }
    public static void swap(int a,int b){
        a++;
        b++;
    }
    public static void swap(String str1,String str2){
        str2=str1+str2;
    }
    public static void swap(Point p1,Point p2){
        Point temp=p2;
        p2=p1;
        p1=temp;
    }
    public static void swap(StringBuilder sb1,StringBuilder sb2){
        sb1.append(sb2);
    }
}
class Point{
    int val;
    public Point(int val){
        this.val=val;
    }
}
