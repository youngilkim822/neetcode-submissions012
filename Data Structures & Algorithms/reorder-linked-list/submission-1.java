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
        if(head == null) return;

        // 1. find mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        /*
        head   : 1>2>3>4
        second : 5>6>7
        */
        // 2. find second half
        ListNode second = slow.next;
        slow.next = null;

        // 3. reverse second half
        ListNode prev = null;
        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        /*
                 f   l1
        head   : 1 > 2 > 3 > 4
        second : 7 > 6 > 5
                 s   l2
        */
        // 4. connect head and second
        ListNode first = head;
        second = prev;
        while(second != null){
            ListNode l1 = first.next;
            ListNode l2 = second.next;

            first.next = second;
            second.next = l1;

            first = l1;
            second = l2;
        }
    }
}
