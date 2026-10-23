class LRUCache {
    private LinkedHashMap<Integer, Integer> hashMap;
    private int size;

    public LRUCache(int capacity) {
        this.hashMap = new LinkedHashMap<>();
        this.size = capacity;
    }
    
    public int get(int key) {
        if(hashMap.containsKey(key)){
            int value = hashMap.get(key);
            hashMap.remove(key);
            hashMap.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
            hashMap.remove(key);
        }else{
            if(hashMap.size() >= this.size){
                int oldestKey = -1;
                for(int k : hashMap.keySet()){
                    oldestKey = k;
                    break;
                }
                hashMap.remove(oldestKey);
            }
        }
        hashMap.put(key,value);
    }
}