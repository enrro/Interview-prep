/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * https://leetcode.com/explore/featured/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3435/
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        int res = 0;
        sumOfLeftLeaves(root,list,'r');
        for(int i : list){
            res += i;
        }
        return res;
    }
    
    // preorder traverse and send info about which side you're currently in.
    // check for left that have the dir(direction) set to l
    public void sumOfLeftLeaves(TreeNode root, List<Integer> list, char dir){
        if(root == null)return;
        if(root.left == null  && root.right == null && dir == 'l'){
            list.add(root.val);
        }
        sumOfLeftLeaves(root.left, list, 'l');
        sumOfLeftLeaves(root.right, list,'r');
    }
}