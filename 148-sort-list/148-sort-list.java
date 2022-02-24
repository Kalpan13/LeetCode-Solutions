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
        
        // No need to sort
        if(head==null || head.next==null)
            return head;
        return mergeSort(head);
    }
    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode merged = null;
        
        if(l1==null)
            return merged = l2;
        if(l2==null)
            return merged = l1;
        
        if(l1.val <= l2.val)
        {
            merged = l1;
            merged.next = merge(l1.next, l2);
        }
            
        else
        {
            merged = l2;
            merged.next = merge(l1, l2.next);
        }
        
        return merged;
    }
    public ListNode mergeSort(ListNode head)
    {
        if(head.next==null)
            return head;
        
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(middleNext);
        ListNode tp = merge(l1, l2);
        return tp;
    }
    public ListNode findMiddle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}