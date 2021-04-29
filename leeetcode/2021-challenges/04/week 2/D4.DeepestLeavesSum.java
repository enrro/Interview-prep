/*
Given the root of a binary tree, return the sum of values of its deepest leaves.
 

Example 1:


Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3704/
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
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList();
        Deque<TreeNode> buffer = new LinkedList();
        int sum = 0;
        if(root == null) return 0;
        
        stack.offer(root);
        
        while(!stack.isEmpty()){
            
            for(int i = stack.size(); i > 0; i--){
                TreeNode temp = stack.poll();
                buffer.offer(temp);
                if(temp.left != null) stack.offer(temp.left);
                if(temp.right!= null) stack.offer(temp.right);
            }
            if(!stack.isEmpty()) buffer.clear();
            
        }
        
        while(!buffer.isEmpty()){
            sum += buffer.poll().val;
            
        }
        return sum;
    }
}