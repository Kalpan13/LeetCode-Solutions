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
    List<List<Integer>> leaves;
    public List<List<Integer>> findLeaves(TreeNode root) {
        leaves = new ArrayList<>();
        findLeavesHelper(root);
        return leaves;
    }
    public int findLeavesHelper(TreeNode root)
    {
        if(root==null)
            return -1;
        
        int leftLevel = findLeavesHelper(root.left);
        int rightLevel = findLeavesHelper(root.right);
        
        int nodeLevel = Math.max(leftLevel,rightLevel)+1;
        
        if(leaves.size()<=nodeLevel)
            leaves.add(new ArrayList<>());
        leaves.get(nodeLevel).add(root.val);
        root.left = root.right = null;
        return nodeLevel;
    }
}