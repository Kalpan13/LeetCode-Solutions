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
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int L = dfs(root.left);
        int R = dfs(root.right);
        
        ans+= Math.abs(L) + Math.abs(R);
        return root.val + L + R - 1;
    }
}