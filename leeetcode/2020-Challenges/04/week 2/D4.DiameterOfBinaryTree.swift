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
    func diameterOfBinaryTree(_ root: TreeNode?) -> Int {
        guard root != nil else{return 0}
        return diameter(root: root)
    }
    func diameter(root: TreeNode?) -> Int {
        guard root != nil else{return 0}
        var rootDiameter:Int = heightOfBinaryTree(root: root?.left) + heightOfBinaryTree(root: root?.right) + 1
        print("\(rootDiameter)")
        var leftDiameter:Int = diameter(root: root?.left)
        var rightDiameter:Int = diameter(root: root?.right)

        return max(rootDiameter, max(leftDiameter, rightDiameter))
    }
    
    func heightOfBinaryTree(root: TreeNode?) -> Int {
        if(root == nil){
            return 0
        }else{
            return max(heightOfBinaryTree(root: root?.left), heightOfBinaryTree(root: root?.left)) + 1
        }
    }
    
}