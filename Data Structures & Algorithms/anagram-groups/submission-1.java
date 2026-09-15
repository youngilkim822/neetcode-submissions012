class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> hashMap = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(Character c : str.toCharArray()){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            hashMap.putIfAbsent(key, new ArrayList<>());
            hashMap.get(key).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }
}
