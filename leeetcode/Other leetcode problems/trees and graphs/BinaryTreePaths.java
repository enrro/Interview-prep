/**
Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/280/
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
solution with stringbuilder
 */

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList();
        StringBuilder sb = new StringBuilder();
        if(root != null) recursiveString(root, list, sb);
        return list;
    }
    
    public void recursiveString(TreeNode root, List<String> list, StringBuilder sb){
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) list.add(sb.toString());
        sb.append("->");

        if(root.left !=null) recursiveString(root.left, list, sb);
        if(root.right != null) recursiveString(root.right, list, sb);
        sb.setLength(len);

    }
}


/**
solution with string concatenation
 */

 class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList();
        if(root != null) binaryPath(root, "", list);
        return list;
    }
    
    public void binaryPath(TreeNode root, String s, List<String> list){
        if(root.left == null && root.right == null) list.add(s + root.val);
        if(root.left != null) binaryPath(root.left, s + root.val + "->", list);
        if(root.right != null) binaryPath(root.right, s + root.val + "->", list);
    }
}