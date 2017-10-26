package com.whut.util.meituan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=Integer.parseInt(scanner.nextLine());
        String[] s=scanner.nextLine().split(" ");
        boolean[] b=new boolean[s.length];
        for (int i=0;i<s.length;i++){
            if (s[i]=="0") b[i]=false;
            else b[i]=true;
        }
        int num=0;
        for (int i=0;i<b.length;i++){
            if (b[i]=true){
                b[i]=false;
                num++;
                change(b,i+1);
            }
        }
        if (num%2==1) System.out.println("Alice");
        else System.out.println("Bob");

    }
    public static void change(boolean[] b,int i){
        for (int k=i;k<b.length;k++){
            b[k]=!b[k];
        }
    }
}
