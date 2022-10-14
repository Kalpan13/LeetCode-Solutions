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
    public ListNode deleteMiddle(ListNode head) {
        int n = findLen(head);
        int middle = n/2;
        if(head.next==null)
            return null;
        ListNode cur = head;
        while(middle-1>0)
        {
            cur = cur.next;
            middle--;
        }
        cur.next = cur.next.next;
        return head;
    }
    public int findLen(ListNode head)
    {
        int count = 0;
        ListNode cur = head;
        while(cur!=null)
        {
            cur = cur.next;
            count++;
        }
        return count;
    }
}