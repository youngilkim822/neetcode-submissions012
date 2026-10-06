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
        if(l1 == null && l2 == null) return null;
        if(l1 != null && l2 == null) return l1;
        if(l1 == null && l2 != null) return l2;

        ListNode newNode = new ListNode(-1);
        ListNode current = newNode;
        boolean flag = false;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val;
            sum += flag == true ? 1 : 0;

            if(sum < 10){
                current.next = new ListNode(sum);
                flag = false;
            }else{
                current.next = new ListNode(sum-10);
                flag = true;
            }
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sum = l1.val;
            sum += flag == true ? 1 : 0;

            if(sum < 10){
                current.next = new ListNode(sum);
                flag = false;
            }else{
                current.next = new ListNode(sum-10);
                flag = true;
            }

            l1 = l1.next;
            current = current.next;
        }

        while(l2 != null){
            int sum = l2.val;
            sum += flag == true ? 1 : 0;

            if(sum < 10){
                current.next = new ListNode(sum);
                flag = false;
            }else{
                current.next = new ListNode(sum-10);
                flag = true;
            }

            l2 = l2.next;
            current = current.next;
        }

        if(flag == true){
            current.next = new ListNode(1);
        }

        return newNode.next;
    }
}
