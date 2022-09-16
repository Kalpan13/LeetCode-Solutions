/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null)
            return root;
        q.offer(root);
        
        Node prev = null;
        while(!q.isEmpty())
        {
            int qSize = q.size();
            while(qSize-->0)
            {
                Node cur = q.poll();
                if(cur.right!=null)
                    q.offer(cur.right);
                if(cur.left!=null)
                    q.offer(cur.left);
                if(prev!=null)
                    cur.next=prev;
                prev = cur;
            }
            prev = null;
        }
        return root;
    }
}