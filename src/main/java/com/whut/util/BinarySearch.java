package com.whut.util;

public class BinarySearch {
    //二分查找首先要求得是顺序存储的
    //循环实现二分查找
    public static int binarySearch(int[] arr,int x){
        int low=0;
        int high=arr.length-1;
        while (low<high){
            int mid=(low+high)/2;
            if (x<arr[mid]) high=mid-1;
            if (x>arr[mid]) low=mid+1;
            if (x==arr[mid]) return mid;
        }
        return -1;
    }
    //递归实现二分查找
    public static int binarySearch(int[] a,int low,int high,int x){
        if(low<high){
            int mid=(low+high)/2;
            if (x==a[mid]){
                return mid;
            }else if (x<a[mid]){
                return binarySearch(a,low,mid-1,x);
            }else {
                return binarySearch(a,mid+1,high,x);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,3,5,6,7,10,21,34,51};
        System.out.println(binarySearch(a,7));
        System.out.println(binarySearch(a,0,a.length-1,4));
    }

}
