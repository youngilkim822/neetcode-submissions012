class Node{
    private Node[] node;
    private boolean isEnd;

    Node(){
        this.node = new Node[26];
        this.isEnd = false;
    }

    private Node getNode(Character c){
        return node[c-'a'] != null ? node[c-'a'] : null;
    }

    private void setNode(Character c){
        node[c-'a'] = new Node();
    }

    private void setIsEnd(){
        this.isEnd = true;
    }

    private boolean isEnd(){
        return isEnd;
    }

}   
class PrefixTree {
    private Node head;

    public PrefixTree() {
        this.head = new Node();
    }

    public void insert(String word) {
        Node current = head;
        for(Character c : word.toCharArray()){
            if(current.getNode(c) == null){
                current.setNode(c);
            }
            current = current.getNode(c);
        }
        current.setIsEnd();
    }

    public boolean search(String word) {
        Node current = head;
        for(Character c : word.toCharArray()){
            if(current.getNode(c) == null){
                return false;
            }
            current = current.getNode(c);
        }
        return current.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node current = head;
        for(Character c : prefix.toCharArray()){
            if(current.getNode(c) == null){
                return false;
            }
            current = current.getNode(c);
        }
        return true;
    }
}
/*
    length 26   apple apb apc ap
    [a, b, c, ..., x, y, z]
     |
     p 
     |\
     p b
     |
     l
     |
     e    
*/
