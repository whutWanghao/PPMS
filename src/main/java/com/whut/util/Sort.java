package com.whut.util;

import java.util.Arrays;

public class Sort {
    public static void bubbleSort(int[] arr){
        //从后往前冒泡最小值，相邻两位交换。
        for (int i=0;i<arr.length-1;i++){
            for (int j=arr.length-1;j-1>=i;j--){
                if (arr[j]<=arr[j-1]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        //选择排序的循环结构有些像冒泡，但是选择排序内循环只是找出最小值的下标，然后每个位置在外循环进行一次交换
        //理论上交换的次数的冒泡少
        for (int i=0;i<arr.length-1;i++){
            int min=i;
            for (int j=i;j<arr.length;j++){
                if (arr[j]<arr[min]) min=j;
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }
    public static void insertSort(int[] a){
        for (int i=1;i<a.length;i++){
            int temp=a[i];
            int j=i-1;
            while (j>=0&&a[j]>temp){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
        }
    }
    public static void shellSort(int[] a){
        //基于插入排序
        int h=1;
        while (h<a.length/3){
            h=h*3+1;
        }
        while (h>=1){
            for (int i=h;i<a.length;i++){
                int temp=a[i];
                int j=i-h;
                while (j>=0&&a[j]>temp){
                    a[j+h]=a[j];
                    j-=h;
                }
                a[j+h]=temp;
            }
            h=h/3;
        }
    }
    public static void mergeTest(){
        //将两个有序数组归并
        int[] a=new int[]{1,4,5,7,9};
        int[] b=new int[]{-3,6,7,8,10,12,16};
        int[] c=new int[a.length+b.length];
        int i=0,j=0,k=0;
        while (i<a.length&&j<b.length){
            if (a[i]<=b[j]){
                c[k]=a[i];
                i++;
            }else {
                c[k]=b[j];
                j++;
            }
            k++;
        }
        if (i<a.length){
            System.arraycopy(a,i,c,k,a.length-i);
        }
        if (j<b.length){
            System.arraycopy(b,j,c,k,b.length-j);
        }
        System.out.println(Arrays.toString(c));
    }

    //归并排序
    public static int[] mergeSort(int[] a,int lo,int hi){
        int mid=(lo+hi)/2;
        if (lo<hi){
            mergeSort(a,lo,mid);//排序左边
            mergeSort(a,mid+1,hi);//排序右边
            merge(a,lo,mid,hi);
        }
        return a;
    }
    public static void merge(int [] a,int lo,int mid,int hi){
        int i=lo,j=mid+1;      //指针
        int k=0;
        int[] temp=new int[hi-lo+1]; //创建临时存放 lo~hi 的数组
        while (i<=mid&&j<=hi){
            if (a[i]<a[j]){
                temp[k]=a[i];
                i++;
            }else {
                temp[k]=a[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            temp[k++]=a[i++];
        }
        while (j<=hi){
            temp[k++]=a[j++];
        }
        for (int x=0;x<temp.length;x++){
            a[x+lo]=temp[x];
        }
    }
    //快速排序
    public static void quickSort(int[] a,int left,int right){
        if (left>=right) return;
        int i=left,j=right;
        int p=a[left];
        while (i<j){//移动首尾的指针，i指向的数大于p就停下，j指向小于p就停下，交换i、j所指的数字
            while (a[j]>=p&&i<j){//先移动j指针，这样结束一定是i去找j停下的位置，j停下的条件是a[j]<a[left]
                j--;
            }
            while (a[i]<=p&&i<j){
                i++;
            }
            if (i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        a[left]=a[i];
        a[i]=p;
        quickSort(a,left,i-1);
        quickSort(a,i+1,right);

    }
    //堆排序
    public static void heapSort(int[] a){
        //建立初始的堆
        for (int i=a.length/2;i>=0;i--){
            adjustHeap(a,i,a.length-1);
        }
        //n-1次循环完成排序
        for (int i=a.length-1;i>0;i--){
            int temp=a[i];
            a[i]=a[0];
            a[0]=temp;
            //重新调整堆
            adjustHeap(a,0,i);
        }

    }
    public static void adjustHeap(int[] a,int parent,int length){
        int temp=a[parent];
        int child=2*parent+1;
        while (child<length){
            if (child+1<length&&a[child]<a[child+1]){//检查是否有右子节点且大于左子节点
                child++;    //转换为右子节点
            }
            if(temp>a[child]){
                break;
            }
            a[parent]=a[child];
            //选取左子节点的值继续像下筛选
            parent=child;
            child=2*parent+1;
        }
        // 若发生交换，此时parent代表子节点索引，没有发生交换，此时parent仍旧代表父节点索引
        a[parent]=temp;
    }
    //层次遍历
    public static void layerTraversal(TreeNode root){

    }
    public static void main(String[] args){
        int[] testArrays=new int[]{3,5,10,7,1,8,6,2,9,-1,-5,50,38,55,61,32,44,12,51};
        //quickSort(testArrays,0,testArrays.length-1);
        heapSort(testArrays);
        System.out.println(Arrays.toString(testArrays));
        //mergeTest();
    }
}
