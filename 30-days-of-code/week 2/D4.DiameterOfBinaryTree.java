/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return diameter(root)-1;
    }
    
    public int diameter(TreeNode root){
        if(root == null ) return 0;
        
        int rootDiameter = height(root.left) + height(root.right) + 1;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(rootDiameter, Math.max(leftDiameter,rightDiameter));
    }
    
    public int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.right), height(root.left)) + 1; 
    }
}