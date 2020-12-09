/*Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

 

Example 1:



Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 

Note:

The number of nodes in the tree is between 1 and 1000.
node.val is 0 or 1.
The answer will not exceed 2^31 - 1.
https://leetcode.com/explore/featured/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3453/
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
    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new LinkedList();
        int sum = 0;
        preorder(root, list,"");
        
        for(String s : list){
            sum += Integer.parseInt(s,2); 
        }
        return sum;
    }
    
    public void preorder(TreeNode root, List<String> list, String s){
        if(root == null){
            return;
        }
        s += root.val;
        if(root.left == null && root.right == null){
            list.add(s);
            return;
        }
        preorder(root.left,  list,s);
        preorder(root.right, list,s);
    }
}

// second improved
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
    public int sumRootToLeaf(TreeNode root) {
        return preorder(root, "");
    }
    
    public int preorder(TreeNode root, String s){
        if(root == null){
            return 0;
        }
        s += root.val;
        if(root.left == null && root.right == null){
            return Integer.parseInt(s,2);
        }
        return preorder(root.left, s) + preorder(root.right, s);
    }
}
