package com.whut.util.meituan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String line1=input.nextLine();
        String line2=input.nextLine();
        int cout=Integer.parseInt(line1);
        int[] data=new int[cout];
        String[] l2=line2.split(" ");
        for (int i=0;i<cout;i++){
            data[i]=Integer.parseInt(l2[i]);
        }
        int res=0;
        for (int i=0;i<data.length-1;i++){
            for (int j=i+1;j<data.length;j++){
                res+=calculate(data[i],data[j]);
                res+=calculate(data[j],data[i]);
            }
        }
        System.out.println(res);
    }
    public static int calculate(long a,long b){
        String s1=String.valueOf(a);
        String s2=String.valueOf(b);
        String s=s1+s2;
        long re=Long.parseLong(s);
        if (re%7==0) {
            return 1;
        }else return 0;
    }
}
