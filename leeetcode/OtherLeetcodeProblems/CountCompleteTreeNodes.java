/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3071/
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
 premium problem
 first approach. this approach is probably not completely right
*/
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int height = 0;
        TreeNode left = root.left, right = root.right;
        while(left != null && right != null) {
            height++; 
            left = left.left;
            right = right.right;
        }

        return left == right ? (1 << height + 1) - 1 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}

/*second approach*/
public int countNodes(TreeNode root) {

    int leftDepth = leftDepth(root);
	int rightDepth = rightDepth(root);

	if (leftDepth == rightDepth)
		return (1 << leftDepth) - 1;
	else
		return 1+countNodes(root.left) + countNodes(root.right);

}

private int rightDepth(TreeNode root) {
	// TODO Auto-generated method stub
	int dep = 0;
	while (root != null) {
		root = root.right;
		dep++;
	}
	return dep;
}

private int leftDepth(TreeNode root) {
	// TODO Auto-generated method stub
	int dep = 0;
	while (root != null) {
		root = root.left;
		dep++;
	}
	return dep;
}
