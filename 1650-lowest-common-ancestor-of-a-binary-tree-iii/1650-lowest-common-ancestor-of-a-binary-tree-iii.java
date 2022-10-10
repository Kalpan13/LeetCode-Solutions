/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int d1 = depth(p);
        int d2 = depth(q);
        
        if(d1<d2)
        {
            Node tp = p;
            p = q;
            q = tp;
            
            int t = d1;
            d1 = d2;
            d2 = t;
        }
        int diff = d1-d2;
        while(diff-->0)
        {
            p = p.parent;
        }
        
        while(p!=null && q!=null)
        {
            if(p==q)
                return p;
            if(p.parent==q.parent)
                return p.parent;
            p = p.parent;
            q = q.parent;
        }
        return null;
    }
    public int depth(Node root)
    {
        if(root.parent==null)
            return 0;
        return depth(root.parent)+1;
    }
    
}