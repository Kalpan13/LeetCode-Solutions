/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(p, q, root);
        
    }
    public TreeNode findLCA(TreeNode p, TreeNode q, TreeNode root)
    {
        if(root==null)
            return null;
        if(root==p)
            return p;
        if(root==q)
            return q;
        
        TreeNode leftLCA = findLCA( p, q, root.left);
        TreeNode rightLCA = findLCA( p, q, root.right);
        
        if(leftLCA==null && rightLCA==null)
            return null;
        
        if(leftLCA==null)
            return rightLCA;
        else if(rightLCA==null)
            return leftLCA;
        else
            return root;
    }
}