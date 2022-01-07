/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 

Follow up: Can you flatten the tree in-place (with O(1) extra space)?
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

https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/322/
 */

 


/*
approach explanation.

from the original tree:

    1
   / \
  2   5
 / \   \
3   4   6
this is a post order traversal in which you navigate right -> left -> root.

If we traverse the flattened tree in the reverse way, we would notice that [6->5->4->3->2->1]
 is in (right, left, root) order of the original tree. So the reverse order after flattening 
 is post order traversal in (right, left, root) order like [6->5->4->3->2->1].

The idea is to traverse the original tree in this order by

public void flatten(TreeNode root) {
    if (root == null)
        return;
    flatten(root.right);
    flatten(root.left);
}

and then set each node's right pointer as the previous one in [6->5->4->3->2->1],
 as such the right pointer behaves similar to a link in the  
 flattened tree(though technically, it's still a right child reference from the tree data structure's perspective) 
 and set the left child as null before the end of one recursion by
private TreeNode prev = null;

public void flatten(TreeNode root) {
    if (root == null)
        return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
}

*/

/**
approach with no globlal variable
 */
class Solution {
    public void flatten(TreeNode root) {
        flatten(root,null);
    }


    private TreeNode flatten(TreeNode root, TreeNode prev) {
        if(root==null) return prev;
        prev=flatten(root.right,prev);    
        prev=flatten(root.left,prev);
        root.right=prev;
        root.left=null;
        return prev;
    }
}

/**
this is a similar approach but with a global variable.

 */
private TreeNode prev = null;

public void flatten(TreeNode root) {
    if (root == null)
        return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
}

/*approach
    1
   / \
  2   5
 / \   \
3   4   6
-----------        
pre = 5
cur = 4

    1
   / 
  2   
 / \   
3   4
     \
      5
       \
        6
-----------        
pre = 4
cur = 3

    1
   / 
  2   
 /   
3 
 \
  4
   \
    5
     \
      6
-----------        
cur = 2
pre = 3

    1
   / 
  2   
   \
    3 
     \
      4
       \
        5
         \
          6
-----------        
cur = 1
pre = 2

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/