/*
You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

 

Example 1:


Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:


Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
Node.val == 0
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3745/
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
/*https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3745/discuss/211180/JavaC++Python-Greedy-DFS*/

class Solution {
    private static final int NO_COVERED = 0, CAMERA_COVERED = 1, HAS_CAMERA = 2;
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) == NO_COVERED ? 1 : 0) + cameras;
    }

    private int dfs(TreeNode root) {
        if (root == null) return CAMERA_COVERED;
        if (root.left == null && root.right == null) return NO_COVERED;

        int left = dfs(root.left), right = dfs(root.right);
        if (left == NO_COVERED || right == NO_COVERED) {
            cameras++;
            return HAS_CAMERA;
        }

        return left == HAS_CAMERA || right == HAS_CAMERA ? CAMERA_COVERED : NO_COVERED;
    }
}