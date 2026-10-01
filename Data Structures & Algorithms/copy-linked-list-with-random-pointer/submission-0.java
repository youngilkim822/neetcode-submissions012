/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node newNode = new Node(-1);
        Node current = newNode;

        Node original = head;
        HashMap<Node,Node> hashMap = new HashMap<>();

        while(head != null){
            current.next = new Node(head.val);
            hashMap.put(head, current.next);

            head = head.next;
            current = current.next;
        }

        current = newNode.next;
        while(original != null){
            current.random = hashMap.get(original.random);
            original = original.next;
            current = current.next;
        }

        return newNode.next;
    }
}
