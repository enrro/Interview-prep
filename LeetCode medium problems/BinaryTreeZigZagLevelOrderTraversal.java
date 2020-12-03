/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q1 = new LinkedList();
        Deque<TreeNode> q2 = new LinkedList();
        List<List<Integer>>  out = new LinkedList();
        if(root == null) return out;
        q1.addFirst(root);
        while(!q1.isEmpty()){
            List<Integer> list = new LinkedList();
            
            while(!q1.isEmpty()){
                TreeNode n = q1.removeFirst();
                list.add(n.val);
                if(n.left != null)  q2.addFirst(n.left);
                if(n.right != null) q2.addFirst(n.right);
            }
            
            out.add(list);
            if(q2.isEmpty()) break;
            list = new LinkedList();
            while(!q2.isEmpty()){
                TreeNode n = q2.removeFirst();
                list.add(n.val);
                if(n.right != null)q1.addFirst(n.right);
                if(n.left != null) q1.addFirst(n.left);
            }
            
            out.add(list);
        }
        
        
        return out;
    }
}