/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

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
 https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/2980/
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q1 = new LinkedList();
        List<List<Integer>> completeList = new LinkedList<>();
        boolean left = true;
        
        if(root == null) return completeList;
        
        q1.add(root);
        
        while(!q1.isEmpty()){
            List<Integer> levelList = new ArrayList();
            int queueSize = q1.size();
            
            for(int i = 0; i < queueSize; i++){
                TreeNode temp = q1.poll();
                if(left){
                    levelList.add(temp.val);
                }else{
                    levelList.add(0,temp.val);
                }
                if(temp.left != null) q1.add(temp.left);
                if(temp.right != null) q1.add(temp.right);
                
            }
            completeList.add(levelList);
            left = !left;
        }
        
        return completeList;
    }
}