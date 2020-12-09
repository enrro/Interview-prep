/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* first solution*/
public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length ==0) return null;
        TreeNode head = new TreeNode(preorder[0]);
        TreeNode root;
        
        for(int i = 1; i < preorder.length; i++){
            TreeNode temp = new TreeNode(preorder[i]);
            root = head;
            while(true){    
                if(temp.val < root.val){
                    if(root.left == null){
                        root.left = temp;
                        break;
                    }else{
                        root = root.left;   
                    }
                }else if(temp.val > root.val){
                    if(root.right == null){
                        root.right = temp;
                        break;
                    }else{
                        root = root.right;
                    }
                }
            }
        }
        
        return head;
    }
}

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
     return helper(preorder, 0, preorder.length - 1);   
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) return null;
        System.out.println("start: " + start + " end: "+ end);
        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for(i=start;i<=end;i++) {
        if(preorder[i] > node.val)
            break;
        }
        System.out.println("start: " + start + " end: " + end + " i:" + i);
        node.left = helper(preorder, start+1, i-1);
        node.right = helper(preorder, i, end);
        return node;
        
        
        
    }
    
}