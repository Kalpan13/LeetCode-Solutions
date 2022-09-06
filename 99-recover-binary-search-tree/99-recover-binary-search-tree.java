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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode middle = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        
         prev = new TreeNode(Integer.MIN_VALUE);
         inorder(root);
         if(second!=null)
         {
             int tp = first.val;
             first.val = second.val;
             second.val = tp;
         }
        else
        {
            int tp = first.val;
            first.val = middle.val;
            middle.val = tp;
        }
    }
    
    public void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        
        if(prev.val>root.val)
        {
            if(first==null)
            {
                first = prev;
                middle = root;
            }
            else
            {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    /*
    O(N) Solution
    
    public void recoverTree(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        buildInorder(root, inorder);
        int[] swapped = findSwappedElements(inorder);
        recoverSwapped(root, 0, swapped[0], swapped[1]);
    }
    public void buildInorder(TreeNode root, List<Integer> inorder)
    {
        
        if(root == null)
            return;
        
        buildInorder(root.left, inorder);
        inorder.add(root.val);
        buildInorder(root.right, inorder);
    }
    public int[] findSwappedElements(List<Integer> inorder)
    {
        int n = inorder.size();
        boolean firstSwappedFound = false;
        int x = -1;
        int y = -1;
        for(int i=0;i<n-1;i++)
        {
            if(inorder.get(i+1)<inorder.get(i))
            {
                y = inorder.get(i+1);
                if(firstSwappedFound)
                {
                    break;
                }
                else
                {
                    x = inorder.get(i);      
                    firstSwappedFound = true;
                }
            }
        }
        return new int[]{x,y};
    }
    public void recoverSwapped(TreeNode root, int recoveredCount, int x, int y)
    {
        if(root==null)
            return;
        if(root.val==x || root.val==y)
        {
            root.val = root.val==x?y:x;
            recoveredCount++;
            if(recoveredCount==2)
                return;
        }
        recoverSwapped(root.left, recoveredCount, x, y);
        recoverSwapped(root.right, recoveredCount, x, y);
        
    }
    */
    
}