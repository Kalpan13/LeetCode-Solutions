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

class Node{
    TreeNode node;
    int v;
    int h;
    Node(TreeNode node, int v, int h)
    {
        this.node = node;
        this.v = v;
        this.h = h;
    }
}
class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<Node>> hm = new HashMap<>();
        Queue<Node> qNode = new LinkedList<>();
        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;
    
        qNode.offer(new Node(root, 0, 0));
        while(!qNode.isEmpty())
        {
            int qSize = qNode.size();
            while(qSize-->0)
            {
                Node cur = qNode.poll();
                TreeNode node = cur.node;
                int v = cur.v;
                int h = cur.h;
                hm.putIfAbsent(v, new ArrayList<>());
                hm.get(v).add(cur);
                minV = Math.min(minV,v);
                maxV = Math.max(maxV,v);
                if(node.left!=null)
                    qNode.offer(new Node(node.left, v-1, h+1));
                if(node.right!=null)
                    qNode.offer(new Node(node.right, v+1, h+1));
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=minV;i<=maxV;i++)
        {
            List<Node> level = new ArrayList<>(hm.get(i));
            Collections.sort(level, (a,b)->a.h==b.h?a.node.val-b.node.val:a.h-b.h);
            List<Integer> levelList = new ArrayList<>();
            for(Node cur : level)
                levelList.add(cur.node.val);
            ans.add(levelList);
        }
        return ans;
    }
}