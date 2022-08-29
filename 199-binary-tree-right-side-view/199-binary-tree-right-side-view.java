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
    List<Integer> rightView;
    public List<Integer> rightSideView(TreeNode root) {
        rightView = new ArrayList<>();
        
        getRightView(root, 0);
        return rightView;
    }
    public void getRightView(TreeNode root, int depth)
    {
        if(root==null)
            return;
        if(rightView.size()<=depth)
            rightView.add(root.val);
        getRightView(root.right,depth+1);
        getRightView(root.left,depth+1);
    }
}