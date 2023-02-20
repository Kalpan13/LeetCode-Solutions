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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        
        int curSum = findMaxSum(root);
        // System.out.println("curSum : "+curSum);
        return Math.max(maxSum, curSum);
    }
    public int findMaxSum(TreeNode root)
    {
        if(root==null)
            return 0;
        
        
        int leftSum = Math.max(findMaxSum(root.left),0);
        int rightSum = Math.max(findMaxSum(root.right),0);
        int curSum = leftSum + rightSum + root.val;
        // System.out.println("root : "+root.val);
        // System.out.println("curSum : "+curSum);
        
        maxSum = Math.max(curSum, maxSum);
        // maxSum = Math.max(root.val, maxSum);
        // maxSum = Math.max(root.val+leftSum, maxSum);
        // maxSum = Math.max(root.val+rightSum, maxSum);
        
        return root.val + Math.max(leftSum, rightSum);
    }
}