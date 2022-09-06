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
    public TreeNode pruneTree(TreeNode root) {
        boolean result = pruneNonOne(root);
        if(!result)
            return null;
        return root;
    }
    public boolean pruneNonOne(TreeNode root)
    {
        
        if(root==null)
            return false;
        
        boolean leftOne = pruneNonOne(root.left);
        boolean rightOne = pruneNonOne(root.right);
        
        if(!leftOne)
            root.left = null;
        if(!rightOne)
            root.right = null;
        if(root.val==1)
        {
            return true;
        }
        else
        {
            return leftOne || rightOne;
        }
    }
}