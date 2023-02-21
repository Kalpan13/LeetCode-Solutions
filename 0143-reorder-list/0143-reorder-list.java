/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next =  null;
        ListNode reverse = reverseLL(midNext);
        merge(head, reverse);
    }
    public void merge(ListNode l1, ListNode l2)
    {
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1!=null && p2!=null)
        {
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;
            
            p1.next = p2;
            p2.next = p1Next;
            p1 = p1Next;
            p2 = p2Next;
        }
        // if(p1!=null)
            
    }
    public ListNode reverseLL(ListNode node)
    {
        ListNode prev = null;
        while(node!=null)
        {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    public ListNode findMid(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
}