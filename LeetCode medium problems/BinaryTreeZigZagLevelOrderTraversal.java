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
        List<List<Integer>> slist = new ArrayList<List<Integer>>();
        if(root == null) return slist;
        TreeNode currentNode;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> clist;
        s1.push(root);
        
        while(!s1.isEmpty()){
            clist = new ArrayList<Integer>();
            while(!s1.isEmpty()){
                currentNode = s1.pop();
                clist.add(currentNode.val);
                if(currentNode.left != null){
                    s2.push(currentNode.left);
                }
                if(currentNode.right != null){
                    s2.push(currentNode.right);
                }
            }
            slist.add(clist);
            clist = new ArrayList<Integer>();

            while(!s2.isEmpty()){
                currentNode = s2.pop();
                clist.add(currentNode.val);

                if(currentNode.right != null){
                    s1.push(currentNode.right);
                }
                if(currentNode.left != null){
                    s1.push(currentNode.left);
                }
            }
            if(clist.size() > 0){
                slist.add(clist);
            }
        }
        return slist;
    }
}