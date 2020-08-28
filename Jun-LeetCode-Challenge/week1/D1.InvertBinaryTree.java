/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.

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
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode otherRoot = new TreeNode();
        createInvertTree(root,otherRoot);
        return otherRoot;
    }
    
    public void createInvertTree(TreeNode root,TreeNode otherRoot){
        if(root == null) return;
        otherRoot.val = root.val;
        if(root.left != null){
            otherRoot.right = new TreeNode();
            createInvertTree(root.left, otherRoot.right);
        }
        if(root.right != null){
            otherRoot.left = new TreeNode();
            createInvertTree(root.right, otherRoot.left);
        }
    }
}