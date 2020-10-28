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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int len = 0;
        ListNode curr = head;
        while(curr != null)
        {
            curr = curr.next;
            len++;
        }
        k %= len;
        
        if(k == 0)
            return head;
        
        ListNode newHead;
        k = len - k;
        curr = head;
        for(int i = 0; i < (k-1); i++)
        {
            curr = curr.next;
        }
        
        newHead = curr.next;
        curr.next = null;
        curr = newHead;
        while(curr.next != null)
        {
            curr = curr.next;
        }
        curr.next = head;
        
        return newHead;
    }
}