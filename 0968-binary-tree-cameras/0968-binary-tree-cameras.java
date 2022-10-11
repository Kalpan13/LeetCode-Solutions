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
    final int HAS_CAMERA = 1;
    final int NEEDS_CAMERA = -1;
    final int NOT_NEEDED = 0;
    int ans = 0;
    public int minCameraCover(TreeNode root) {
        if (helper(root) == NEEDS_CAMERA) ans++;
        // helper(root);
        return ans;
    }
    public int helper(TreeNode root)
    {
        if(root==null)
            return NOT_NEEDED;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left==NEEDS_CAMERA || right==NEEDS_CAMERA)
        {
            ans++;
            return HAS_CAMERA;
        }
        if(left==HAS_CAMERA || right==HAS_CAMERA)
            return NOT_NEEDED;
    
        else
            return NEEDS_CAMERA;
        
    }
}