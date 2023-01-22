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
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        boolean found = helper(root, p, q);
        return this.ans;
    }
    public boolean helper(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null)
            return false;
        
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        boolean current = (root==p || root==q);
        
        if((left && right) || (left && current) || (right && current))
            this.ans = root;
        
        if(left||right||current)
            return true;
        return false;
    }
}