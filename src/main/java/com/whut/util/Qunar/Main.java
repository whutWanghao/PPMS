package com.whut.util.Qunar;

import java.util.Scanner;

public class Main {
    //贪心算法 求最少硬币数量
    static int[] money = {1, 5, 10, 50, 100, 500};
    static int[] count = new int[6];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i=0; i<6; i++){
            count[i] = in.nextInt();
        }
        int allMoney = in.nextInt();

        int ans = 0;
        int index = 5;
        while (allMoney != 0 && index >= 0){
            if (allMoney >= money[index] && count[index]>0){
                allMoney -= money[index];
                count[index] = count[index] - 1;
                ans++;
            } else {
                index--;
            }
        }
        if (allMoney == 0){
            System.out.println(ans);
        } else {
            System.out.println("NOWAY");
        }
    }
}