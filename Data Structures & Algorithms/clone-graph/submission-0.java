/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        HashMap<Node, Node> hashMap = new HashMap<>();
        return recurse(node, hashMap);
    }

    private Node recurse(Node node, HashMap<Node, Node> hashMap){
        if(node == null) return null;
        if(hashMap.containsKey(node)) return hashMap.get(node);

        Node copy = new Node(node.val, new ArrayList<>());
        hashMap.put(node, copy);

        for(Node neighbor : node.neighbors){
            copy.neighbors.add(recurse(neighbor, hashMap));
        }
        return copy;
    }
}
















