/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return head;
        ListNode sp = head;
        ListNode fp = head;
        
        while(fp != null && fp.next != null)
        {
            fp = fp.next.next;
            sp = sp.next;
            if(sp == fp)
            {
                fp = head;
                while(sp != fp)
                {
                    sp = sp.next;
                    fp = fp.next;
                }
                return sp;
            }
        }
        return null;
    }
}