/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 
Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
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
dfs approach
*/
class Solution {
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1, yDepth = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }
    //get both the depth and parent for x and y
    public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        }else{
            getDepthAndParent(root.left, x, y, depth + 1, root);
            getDepthAndParent(root.right, x, y, depth + 1, root);            
        }
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        AtomicInteger pX = new AtomicInteger();    //parent of x
        AtomicInteger pY = new AtomicInteger();    //parent of y
        AtomicInteger dX = new AtomicInteger(-1);  // depth of x
        AtomicInteger dY = new AtomicInteger(-1);  // depth of y
        recursiveCousins(root, x, y, 0, dX, dY, pX, pY);
        System.out.println("px: " + pX + " pY: " + pY + " dX: " + dX + " dY: " + dY);
        System.out.println("(dX == dY) " +(dX.get() == dY.get()));
        System.out.println("(pX != pY) " + (pX.get() != pY.get()));
        return ((dX.get() == dY.get()) && (pX.get() != pY.get()));
    }
    
    void recursiveCousins(TreeNode root, int x, int y, int d,
                                 AtomicInteger dX, AtomicInteger dY, 
                                 AtomicInteger pX, AtomicInteger pY){
        if(root == null) return;
        
        if(root.left != null){
            if(root.left.val == x){
                pX.set(root.val);
                dX.set(d + 1);
            } else if(root.left.val == y){
                pY.set(root.val);
                dY.set(d + 1);
            }
        }
        if(root.right != null){
            if(root.right.val == x){
                pX.set(root.val);
                dX.set(d + 1);
            }else if(root.right.val == y){
                pY.set(root.val);
                dY.set(d + 1);
            }
        }
        if(dX.get() != -1 && dY.get() != -1)return;
        recursiveCousins(root.left,  x, y, d+1, dX, dY, pX, pY);
        recursiveCousins(root.right, x, y, d+1, dX, dY, pX, pY);
    }
}