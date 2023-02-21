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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right)
    {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(left!=null && right!=null)
        {
            if(left.val<right.val)
            {
                cur.next = left;
                left = left.next;
                cur = cur.next;
            }
            else
            {
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }
        cur.next = left==null?right:left;
        return dummy.next;
            
    }
    
    public ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;
        while(fast!=null && fast.next!=null)
        {
            slowPrev = slow;
            slow = slow.next;
            
            fast = fast.next.next;
        }
        slowPrev.next = null;
        return slow;
    }
}