package com.whut.util.Qunar;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String string=input.nextLine();
        String[] str =string.split(" ");
        int num=Integer.parseInt(str[0]);
        int[] values=new int[num];
        Map<Integer,Integer> map=new HashMap<>();
        boolean[][] line=new boolean[num][num];
        for (int i=0;i<num;i++){
            str=input.nextLine().split(" ");
            values[i]=Integer.parseInt(str[1]);
            map.put(values[i],Integer.parseInt(str[0]));
        }
        while (input!=null){
            str=input.nextLine().split(" ");
            line[Integer.parseInt(str[0])-1][Integer.parseInt(str[1])-1]=true;
        }
        Arrays.sort(values);
        for (int i=num-1;i>=0;i--){
            System.out.print(map.get(values[i])+" ");
        }
    }
}
