/*
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q1 = new LinkedList();
        List<List<Integer>> completeList = new LinkedList<>();
        
        if(root == null) return completeList;
        q1.add(root);
        
        while(!q1.isEmpty()){
            List<Integer> levelList = new ArrayList();
            int queueSize = q1.size();
            
            for(int i = 0; i < queueSize; i++){
                TreeNode temp = q1.poll();
                levelList.add(temp.val);
                if(temp.left != null) q1.add(temp.left);
                if(temp.right != null) q1.add(temp.right);
                
            }
            completeList.add(levelList);
        }
        
        return completeList;
    }
}