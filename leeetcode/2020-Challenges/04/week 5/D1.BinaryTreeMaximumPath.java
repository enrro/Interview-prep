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

/**
approach
post order traversal sum up 
 */
class Solution {
    int maxSum;
public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxOfTree(root);
        return maxSum;
    }
    
    // maxSum is the sum of the path with the highest value
    // Math.max(left,right) + root.val on the other hand
    // is for the upper layer int maxLeft and maxRight. because we cannot choose both of them
    public int maxOfTree(TreeNode root){
        if(root == null) return 0;
        int maxLeft = Integer.max(0,maxOfTree(root.left)); //postorder sum-up
        int maxRight = Integer.max(0, maxOfTree(root.right));
        
        maxSum = Integer.max(maxSum, maxLeft + maxRight + root.val);
        
        return Integer.max(maxLeft, maxRight) + root.val;
    }
}

/**
The most tricky point is the global variable maxValue in the following sentence:

maxValue = Math.max(maxValue, left + right + node.val);
The second maxValue contains the bigger between the left sub-tree and right sub-tree.
if (left + right + node.val < maxValue ) then the result will not include the parent node which means the maximum path is in the left branch or right branch. */