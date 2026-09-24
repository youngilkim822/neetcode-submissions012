
class TrieNode{
    private TrieNode[] array;
    private boolean isEnd;
    
    TrieNode(){
        this.array = new TrieNode[26];
        this.isEnd = false;
    }

    public void setChild(Character c){
        array[c-'a'] = new TrieNode();
    }

    public TrieNode getChild(Character c){
        return array[c-'a'];
    }

    public void setIsEnd(boolean flag){
        this.isEnd = flag;
    }

    public boolean isEnd(){
        return this.isEnd;
    }
}
class PrefixTree {
    private TrieNode head;
    public PrefixTree() {
         this.head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = head;
        for(Character c : word.toCharArray()){
            if(current.getChild(c) == null){
                current.setChild(c);
            }
            current = current.getChild(c);
        }
        current.setIsEnd(true);
    }

    public boolean search(String word) {
        TrieNode current = head;
        for(Character c : word.toCharArray()){
            if(current.getChild(c) == null){
                return false;
            }
            current = current.getChild(c);
        }
        return current.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = head;
        for(Character c : prefix.toCharArray()){
            if(current.getChild(c) == null){
                return false;
            }
            current = current.getChild(c);
        }
        return true;
    }
}
