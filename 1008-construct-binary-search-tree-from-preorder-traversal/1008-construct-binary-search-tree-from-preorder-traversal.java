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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i=1;i<preorder.length;i++)
        {
            insertNode(root, preorder[i]);
        }
        return root;
    }
    public TreeNode insertNode(TreeNode root, int num)
    {
        if(root==null)
            return new TreeNode(num);
        else if(root.val>num)
            root.left = insertNode(root.left, num);
        else
            root.right = insertNode(root.right, num);
        
        return root;
    }
}