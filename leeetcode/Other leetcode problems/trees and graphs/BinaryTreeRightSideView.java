/**
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/3023/

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

/*
Approach
level order traversal with right to left traverse
(1) the traverse of the tree is NOT standard pre-order traverse. It checks the RIGHT node first and then the LEFT
(2) the line to check currDepth == result.size() makes sure the first element of that level will be added to the result list
(3) if reverse the visit order, that is first LEFT and then RIGHT, it will return the left view of the tree.


*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightView(root, list, 0);
        return list;
    }
    
    // this preordertraversal with right first approach
    // Draw a preorder traversal. Now draw one in which you do it the right side first.
    public void rightView(TreeNode root, List<Integer> list, int level){
        if(root == null) return;
        
        if(level == list.size()) list.add(root.val);
        
        rightView(root.right, list, level + 1);
        rightView(root.left, list, level + 1);
        
    }
}