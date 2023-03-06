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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode cur = head;
        ListNode newHead = null;
        ListNode ktail = null;
        while(cur!=null)
        {
            int count = 0;
            
            while(count<k && cur!=null)
            {
                cur = cur.next;
                count++;
            }
            if(count==k)
            {
                ListNode revHead = reverseK(head, k);
                if(newHead==null)
                    newHead = revHead;
                if(ktail!=null)
                    ktail.next = revHead;
                
                ktail = head;
                head = cur;
            }
        }
        if(ktail!=null)
            ktail.next = head;
        return newHead;
        
    }
    public ListNode reverseK(ListNode head, int k)
    {
        ListNode cur = head;
        ListNode prev = null;
        
        while(k-->0)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}