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
    Map<TreeNode, Set<TreeNode>> graph;
    Set<TreeNode> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        buildGraph(root, null);
        visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        findNodes(target, ans, k);
        return ans;
    }
    public void buildGraph(TreeNode root, TreeNode parent)
    {
        if(root==null)
            return;
        if(!graph.containsKey(root))
        {
            graph.put(root, new HashSet<>());
            if(root.left!=null)
            {
                graph.get(root).add(root.left);    
            }
            if(root.right!=null)
            {
                graph.get(root).add(root.right);
            }
            if(parent!=null)
            {
                graph.get(root).add(parent);
            }
            buildGraph(root.left, root);
            buildGraph(root.right, root);    
        }
        
    }
    public void findNodes(TreeNode root, List<Integer> ans, int k)
    {
        if(visited.contains(root))
            return;
        
        if(k==0)
        {
            if(!visited.contains(root))
                ans.add(root.val);
            return;
        }
        visited.add(root);
        
        for(TreeNode neigh: graph.get(root))
        {
            findNodes(neigh,ans,k-1);
        }
    }
}