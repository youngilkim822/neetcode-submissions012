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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        temp = head;
        ListNode current = new ListNode(-1);
        ListNode prev = current;
        current.next = temp;
        // int count = 0;
        // while(count != size-n){
        //     current = current.next;
        //     count++;
        // }
        for(int i=0; i<size-n; i++){
            current = current.next;
        }
        current.next = current.next.next;
        return prev.next;

    }
}
