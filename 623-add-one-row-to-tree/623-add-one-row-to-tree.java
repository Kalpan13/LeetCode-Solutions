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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth==1)
        {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        // return root;
        helper(root, val, depth, 1);
        return root;
    }
    public void helper(TreeNode root, int val, int depth, int curDepth)
    {
        curDepth++;
        
        if(root==null)
            return;
        if(curDepth==depth)
        {
            TreeNode newNodeLeft = new TreeNode(val);
            if(root.left!=null)
                newNodeLeft.left = root.left;
            
            TreeNode newNodeRight = new TreeNode(val);
            if(root.right!=null)
            newNodeRight.right = root.right;
            
            root.left = newNodeLeft;
            root.right = newNodeRight;
            return;
        }
        helper(root.left, val, depth, curDepth);
        helper(root.right, val, depth, curDepth);
        
    }
}