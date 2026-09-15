class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(Character c : s.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c,0)+1);
        }

        for(Character c : t.toCharArray()){
            if(!hashMap.containsKey(c)) return false;
            hashMap.put(c, hashMap.get(c)-1);
            if(hashMap.get(c) < 0) return false;
        }
        
        return true;
    }
}
