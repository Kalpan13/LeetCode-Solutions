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
    Set<Integer> hs;
    public boolean findTarget(TreeNode root, int k) {
        hs = new HashSet<>();
        return helper(root, k);
    }
    public boolean helper(TreeNode root, int k)
    {
        if(root==null)
            return false;
        
        if(hs.contains(k-root.val))
            return true;
        hs.add(root.val);
        return helper(root.left, k) || helper(root.right, k) ;
    }
}