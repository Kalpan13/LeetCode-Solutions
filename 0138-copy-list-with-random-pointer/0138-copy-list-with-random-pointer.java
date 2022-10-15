/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        if(head==null)
            return head;
        while(cur!=null)
        {
            Node copy = new Node(cur.val);
            Node next = cur.next;
            cur.next = copy;
            copy.next = next;
            cur = cur.next.next;
        }
        cur = head;
        while(cur!=null)
        {
            cur.next.random = (cur.random!=null)?cur.random.next:null;
            cur = cur.next.next;
        }
        cur = head; 
        Node headCopy = head.next; 
        Node curCopy = head.next; 
        while(cur!=null)
        {
            cur.next = cur.next.next;
            curCopy.next = (curCopy.next!=null)?curCopy.next.next:null;
            
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return headCopy;
    }
}