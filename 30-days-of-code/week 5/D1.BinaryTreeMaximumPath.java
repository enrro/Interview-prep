/**
https://leetcode.com/explore/other/card/30-day-leetcoding-challenge/532/week-5/3314/
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
//         if(root == null ) return 0;
        
//         int rootDiameter = height(root.left) + height(root.right) + 1;
//         int leftDiameter = diameter(root.left);
//         int rightDiameter = diameter(root.right);
//         return Math.max(rootDiameter, Math.max(leftDiameter,rightDiameter));
class Solution {
    int maxSum;
public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxOfTree(root);
        return maxSum;
    }
    
    // maxSum is the sum of the path with the highest value
    // Math.max(left,right) + root.val on the other hand is for the upper layer int maxLeft and maxRight. because we cannot choose both of them
    public int maxOfTree(TreeNode root){
        if(root == null) return 0;
        int maxLeft = Integer.max(0,maxOfTree(root.left));
        int maxRight = Integer.max(0, maxOfTree(root.right));
        
        maxSum = Integer.max(maxSum, maxLeft + maxRight + root.val);
        
        return Integer.max(maxLeft, maxRight) + root.val;
    }
}