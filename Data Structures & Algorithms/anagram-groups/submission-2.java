class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> hashMap = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(Character c : str.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                sb.append(count[i]).append('#');
            }
            String key = sb.toString();
            hashMap.putIfAbsent(key, new ArrayList<>());
            hashMap.get(key).add(str);
        }

        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String, List<String>> entrySet : hashMap.entrySet()){
            list.add(entrySet.getValue());
        }
        return list;
        
    }
}
