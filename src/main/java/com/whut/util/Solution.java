package com.whut.util;


import java.util.*;

public class Solution {
    public static void main(String[] args){
        int i=7;
        System.out.println(8/3);
    }
    public int count(){
        int j=0;
        for (int i=0;i<3;i++){
            return j=i;
        }
        return j;
    }
    /*
    *
    * */
    public int findLHS(int[] nums) {
        Map<Long,Integer> map=new HashMap<>();
        for (long num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            //map.getOrDefault 是JDK8新增的方法 取指定key的value
            // 如果为null则取defaultValue 这里的循环相当于给num值出现次数计数
        }
        int result=0;
        for (long key:map.keySet()){
            if (map.containsKey(key+1)){
                result=Math.max(result,map.get(key)+map.get(key+1));
            }
        }
        return result;
    }

    /*
    * Subtree of Another Tree
    * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
     * A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself
    * */
    public boolean isSubtree(TreeNode s,TreeNode t){
        if (s==null) return false;
        if (isSame(s,t)) return true;
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    private boolean isSame(TreeNode s,TreeNode t){
        if (s==null&&t==null) return true;
        if (s==null||t==null) return false;

        if (s.val!=t.val) return false;
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }

    /*
    * Majority Element
    *Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     You may assume that the array is non-empty and the majority element always exist in the array.
    * */
    public int majorityElement(int[] nums){
        HashMap<Long,Integer> map=new HashMap<>();
        for (long i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if (map.get(i)>(nums.length/2)) return (int) i;
        }
        return 0;
    }




    /*
    * Populating Next Right Pointers in Each Node
    * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    * Initially, all next pointers are set to NULL.
    * You may only use constant extra space.
    * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    * */
    public void connect(TreeLinkNode root){
        if (root==null) return;
        if (root.left!=null){
            root.left.next=root.right;
            if (root.next!=null)
                root.right.next=root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
    //Populating Next Right Pointers in Each Node II
    // is not perfect binary tree.
    public void connect1(TreeLinkNode root){
        if (root==null) return;
        TreeLinkNode rootNext=root.next;    //找到与root同一行的next
        TreeLinkNode next=null;             //下一个被连接的对象
        //与完美二叉树不同，这种情况要先填充右边的子树
        while (rootNext!=null){
            if (rootNext.left!=null){
                next=rootNext.left;
                break;
            }else if (rootNext.right!=null){
                next=rootNext.right;
                break;
            }else {
                rootNext=rootNext.next;
            }
        }

        if (root.right!=null){
            root.right.next=next;
        }
        if (root.left!=null){
            if (root.right!=null){
                root.left.next=root.right;
            }else root.left.next=next;
        }

        connect1(root.right);
        connect1(root.left);
    }
    /*
    * Palindrome Partitioning
    * Given a string s, partition s such that every substring of the partition is a palindrome.
    * Return all possible palindrome partitioning of s.
    *
    * */
    public List<List<String>> partition(String s){
        int len=s.length();
        List<List<String>>[] result=new List[len+1];
        result[0]=new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair=new boolean[len][len];
        for (int i=0;i<s.length();i++){
            result[i+1]=new ArrayList<List<String>>();
            for (int left=0;left<=i;left++){
                if (s.charAt(left)==s.charAt(i)&&(i-left<=1||pair[left+1][i-1])){
                    pair[left][i]=true;
                    String str=s.substring(left,i+1);
                    for (List<String> r:result[left]){
                        List<String> ri=new ArrayList<String>(r);
                        ri.add(str);
                        result[i+1].add(ri);
                    }
                }
            }

        }
        return result[len];
    }
    private boolean isPalindrome(String s,int i,int j){
        if (i==j) return true;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    /*
    * Count of Range Sum
    * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
    * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ? j), inclusive.
    * */
    public int countRangeSum(int[] nums, int lower, int upper) {
        return 0;
    }

    /*Print Binary Tree
    * The row number m should be equal to the height of the given binary tree.
    * The column number n should always be an odd number.
    * Each unused space should contain an empty string "".
    * */
    public List<List<String>> printTree(TreeNode root) {
        int height=root==null?1:getTreeHeight(root);
        int width=(int)(Math.pow(2,height)-1);//java ^是按位或 不是求指数幂 要在Math中找相应方法
        List<String> list=new ArrayList<>();
        List<List<String>> res=new ArrayList<>();
        for (int i=0;i<width;i++) list.add("");
        for (int i=0;i<height;i++) res.add(new ArrayList<>(list));
        populateRes(root,res,0,height,0,width-1);
        return res;
    }
    private void populateRes(TreeNode root,List<List<String>> res,int row,int totalRows,int head,int tail){
        if (row==totalRows||root==null) return;
        res.get(row).set((head+tail)/2,Integer.toString(root.val));
        populateRes(root.left,res,row+1,totalRows,head,(head+tail)/2-1);
        populateRes(root.right,res,row+1,totalRows,(head+tail)/2+1,tail);
    }
    private int getTreeHeight(TreeNode root){
        if (root==null) return 0;
        else return Math.max(getTreeHeight(root.left),getTreeHeight(root.right))+1;
    }
    /*
    * Binary Tree Level Order Traversal
    * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
    * 递归调用 深度优先搜索
    * */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        DFS(res,root,0);
        return res;
    }
    private void DFS(List<List<Integer>> res,TreeNode root,int height){
        if (root==null) return;
        if (height>=res.size()){
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        DFS(res,root.left,height+1);
        DFS(res,root.right,height+1);
    }
    /*
    * Two Sum
    * */
    public int[] twoSum(int[] nums,int target){
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    /*
    * Minimum Absolute Difference in BST
    * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
    * 二叉搜索树的特点是，小的值在左边，大的值在右边，严格 左<中<右
    * */
    List<Integer> list=new ArrayList<>();
    public int getMinimumDifference(TreeNode root){
        inOrder(root);
        int miniNum=list.get(1)-list.get(0);
        for (int i=0;i<list.size()-1;i++){
            int difference=list.get(i+1)-list.get(i);
            if (difference<=miniNum){
                miniNum=difference;
            }
        }
        return miniNum;
    }
    private void inOrder(TreeNode root){
        if (root.left!=null){
            inOrder(root.left);
        }
        list.add(root.val);
        if (root.right!=null){
            inOrder(root.right);
        }
    }
    /*
    * H-Index
    * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total
    * and each of them had received 3, 0, 6, 1, 5 citations respectively.
    * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
    * */
    public int hIndex(int[] citations){
        if (citations.length==0) return 0;
        Arrays.sort(citations);
        List<Integer> list=new ArrayList<>();
        if (citations[0]>=citations.length) return citations.length;
        if (citations[citations.length-1]==0) return 0;
        for (int i=1;i<citations.length;i++){
            if (citations[citations.length-i]>=i&&citations[citations.length-i-1]<i){
                list.add(i);
            }
        }
        return list.get(list.size()-1);
    }

}
class TreeNode{
    //Subtree of Another Tree
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
class  TreeLinkNode{
    int val;
    TreeLinkNode left,right,next;
    TreeLinkNode(int x){
        val=x;
    }
}