/*
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].
https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3449/
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();

        while(!stack1.isEmpty() || root1 != null || !stack2.isEmpty() || root2 != null){
            while(root1 != null){
                stack1.push(root1);
                root1 = root1.left;
            }
            
            while(root2 != null){
                stack2.push(root2);
                root2 = root2.left;
            }
            
            if(stack2.isEmpty() || !stack1.isEmpty() && stack1.peek().val < stack2.peek().val){
                root1 = stack1.pop();
                list.add(root1.val);
                root1 = root1.right;
            }else{
                root2 = stack2.pop();
                list.add(root2.val);
                root2 = root2.right;
            }
            
        }
        
        return list;
    }
}

// approach. we follow the inorder non recursive traversal method  and extend it to work for 2 trees at the same time
// normal inorder traversal looks like this
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack1 = new Stack();
        
        while(!stack1.isEmpty() || root1 != null){
            while(root1 != null){
                stack1.push(root1);
                root1 = root1.left;
            }
            

            
            root1 = stack1.pop();
            System.out.println(root1.val);
            root1 = root1.right;
            
        }
        
        return list;
    }
}