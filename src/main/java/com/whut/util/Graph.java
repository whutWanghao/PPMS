package com.whut.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private Vertex[] vertexList;    //顶点数组
    private int[][] adjMat;     //邻接矩阵
    private int maxSize=20;    //顶点的最大数目
    private int nVertex;    //当前顶点


    public Graph(){
        vertexList=new Vertex[maxSize];
        adjMat=new int[maxSize][maxSize];
        for (int i=0;i<maxSize;i++){
            for (int j=0;j<maxSize;j++){
                adjMat[i][j]=0;
            }
        }
        nVertex=0;
    }

    //添加顶点
    public void addVertex(char label){
        vertexList[nVertex++]=new Vertex(label);
    }
    //添加边
    public void addEdge(int start,int end){
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }
    //寻找一个临接的访问过的顶点
    public int getAdjUnvisitedVertex(int v){
        for (int i=0;i<nVertex;i++){
            if (adjMat[i][v]==1&&!vertexList[i].wasVisited){
                return i;
            }
        }
        return -1;
    }
    //显示顶点名
    public void display(int val){
        System.out.print(vertexList[val].label);
    }

    //深度优先搜索
    public void depthFirstSearch(){
        Stack<Integer> myStack=new Stack<>();     //栈
        //访问0号顶点
        vertexList[0].wasVisited=true;
        display(0);
        myStack.push(0);
        while (!myStack.isEmpty()){
            int v=getAdjUnvisitedVertex(myStack.peek());
            if (v==-1){
                //弹出一个顶点
                myStack.pop();
            }else {
                display(v);
                vertexList[v].wasVisited=true;
                myStack.push(v);
            }
        }
        //将访问信息删除
        for (int i=0;i<nVertex;i++){
            vertexList[i].wasVisited=false;
        }
    }
    public void breadthFirstSearch(){
        Queue<Integer> queue=new LinkedList<>();
        vertexList[0].wasVisited=true;
        queue.add(0);
        display(0);
        while (!queue.isEmpty()){
            //标记当前的节点
            int v=queue.peek();
            for (int j=0;j<nVertex;j++){
                if (!vertexList[j].wasVisited&&adjMat[v][j]==1){
                    vertexList[j].wasVisited=true;
                    queue.add(j);
                    display(j);

                }
            }

            queue.remove();
        }
        //将访问信息删除
        for (int i=0;i<nVertex;i++){
            vertexList[i].wasVisited=false;
        }
    }

    public static void main(String[] args) {
        //测试
        Graph g=new Graph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(0,3);
        g.addEdge(3,4);

        g.depthFirstSearch();
        System.out.println();
        g.breadthFirstSearch();
    }

}
class Vertex{
    public char label;
    public boolean wasVisited;
    public Vertex(char label){
        this.label=label;
    }

}
