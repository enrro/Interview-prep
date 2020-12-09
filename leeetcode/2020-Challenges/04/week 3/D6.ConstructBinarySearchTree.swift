
/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
*/
/*couldnt find the bug */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
class Solution {
    func bstFromPreorder(_ preorder: [Int]) -> TreeNode? {
        return createbst(preorder, 0, preorder.count-1);
    }
    
    func createbst(_ preorder:[Int],_ start:Int,_ end:Int) -> TreeNode? {
        print("start of funct start: \(start) end \(end)")
        guard start <= end else {return nil}
        var root = TreeNode(preorder[start])
        var i: Int = start
        
        for j in start...end{
            if preorder[j] > root.val  {
                i = j
                break;
            }
        }
        print("start: \(start) end \(end) i \(i)")
        root.left = createbst(preorder, start + 1, i - 1)
        root.right = createbst(preorder, i, end)
        return root
    }
}
