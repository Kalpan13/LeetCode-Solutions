/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        Node lastNode = flattenChild(head);
       
        return head;
    }
    public Node flattenChild(Node head)
    {   
        if(head==null)
            return null;
        if(head.child==null)
            if(head.next==null)
                return head;
            else
                return flattenChild(head.next);
        
        Node cur = head;
        Node child = cur.child;
        cur.child = null;
        Node childLast = flattenChild(child);
        Node next = cur.next;

        child.prev = cur;
        cur.next = child;
        if(next!=null)
        {
            childLast.next = next;
            next.prev = childLast;
            return flattenChild(next);
        }
        return childLast;
        
     
        
    }
}