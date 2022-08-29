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
    int level = 0;
    StringBuffer upath; // Path to go Up
    StringBuffer dpath; // Path to go Down
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = findLCA(root, startValue, destValue);
        //System.out.println(LCA.val);
        upath = new StringBuffer();
        dpath = new StringBuffer();
        buildPathFromStart(LCA, startValue);
        buildPathFromEnd(LCA, destValue);
        return upath.toString() + dpath.reverse().toString();
    }   
    public TreeNode findLCA(TreeNode root, int startValue, int destValue)
    {
        if(root==null)
            return null;
        
        if(root.val == startValue)
            return root;
        if(root.val == destValue)
            return root;
        
        TreeNode leftLCA = findLCA(root.left, startValue, destValue);
        TreeNode rightLCA = findLCA(root.right, startValue, destValue);
        
        if(leftLCA == null && rightLCA == null)
            return null;
        if(leftLCA==null)
            return rightLCA;
        else if(rightLCA==null)
            return leftLCA;
        else return root;
    }
    public boolean buildPathFromStart(TreeNode node, int value)
    {
        if(node==null)
            return false;
        if(node.val == value)
            return true;
        if(buildPathFromStart(node.left, value))
        {
            upath.append('U');
            return true;
        }
            
        if(buildPathFromStart(node.right, value))
        {
            upath.append('U');
            return true;
        }
        return false;
        
    }
    public boolean buildPathFromEnd(TreeNode node, int value)
    {
        if(node==null)
            return false;
        if(node.val == value)
            return true;
        if(buildPathFromEnd(node.left, value))
        {
            dpath.append('L');
            return true;
        }
            
        if(buildPathFromEnd(node.right, value))
        {
            dpath.append('R');
            return true;
        }
        return false;
    }
}