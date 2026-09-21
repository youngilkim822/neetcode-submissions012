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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode temp = head;
        ListNode next = temp;
        ListNode nextNext = temp.next;

        while(next != null && nextNext != null){
            if(next.val == nextNext.val){
                return true;
            }
            next = next.next != null ? next.next : null;
            if(nextNext.next != null){
                if(nextNext.next.next != null){
                    nextNext = nextNext.next.next;
                }else{
                    nextNext = null;
                }
            }else{
                nextNext = null;
            }
        }
        return false;
    }
}
