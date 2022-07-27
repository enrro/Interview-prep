/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
https://leetcode.com/explore/interview/card/microsoft/31/trees-and-graphs/152/
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
    // int max = Integer.MIN_VALUE;
    
        public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
    
    
    // inorder iterative aproach
    class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode previous = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(previous != null && previous.val >= root.val) return false;
            previous = root;
            root = root.right;
        }
        
        return true;
    }
}
    
    
    // public boolean isValidBST(TreeNode root) {
    //     List<Integer> list = new ArrayList();
    //     list.add(Integer.MIN_VALUE);
    //     return inOrderTraverse(root, list);
    //     // return inOrderTraverse(root, max);
    // }
    
    
    
// public boolean inOrderTraverse(TreeNode root, List<Integer> max){
//     if(root == null) return true;
//     boolean left = inOrderTraverse(root.left, max);
//     if(max.get(0) >= root.val)return false;
//     else max.add(0,root.val);
//     boolean right = inOrderTraverse(root.right, max);
//     return left && right;
// }
//     public boolean inOrderTraverse(TreeNode root, int max){
//         if(root == null) return true;
        
//         boolean left = inOrderTraverse(root.left, max);
//         if(max >= root.val)return false;
//         boolean right = inOrderTraverse(root.right, root.val);
//         return left && right;
//     }
}