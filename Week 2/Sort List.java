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
    
    private ListNode merge(ListNode first, ListNode second)
    {
        ListNode dum = new ListNode();
        ListNode curr = dum;
        while(first != null && second != null)
        {
            if(first.val < second.val)
            {
                curr.next = first;
                first = first.next;
            }
            else
            {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        if(first == null)
        {
            curr.next = second;
        }
        else
        {
            curr.next = first;
        }
        return dum.next;
    }
    
    private ListNode mid(ListNode head)
    {
        ListNode mid = head;
        ListNode prev = null;
        while(head != null && head.next != null)
        {
            prev = mid;
            mid = mid.next;
            head = head.next.next;
        }
        if(prev != null)
            prev.next = null;
        return mid;        
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode m = mid(head);
        head = sortList(head);
        m = sortList(m);
        return merge(head, m);
    }
}