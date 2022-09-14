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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1!=null)
        {
            st1.push(p1.val);
            p1 = p1.next;
        }
        while(p2!=null)
        {
            st2.push(p2.val);
            p2 = p2.next;
        }
        
        boolean carry = false;
        ListNode prev = null;
        while(!st1.isEmpty() || !st2.isEmpty())
        {
            int sum = (st1.isEmpty()?0:st1.pop()) + (st2.isEmpty()?0:st2.pop());
            sum+= carry?1:0;
            ListNode cur = new ListNode(sum%10);
            cur.next = prev;
            carry = (sum/10)>0;
            prev = cur;
        }
        if(carry)
        {
            ListNode additional = new ListNode(1);
            additional.next = prev;
            return additional;
        }
        return prev;
    }
    
}