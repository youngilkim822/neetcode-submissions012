class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> hashMap = new HashMap<>();
        for(String str : strs){ // "abcaaa"
            int[] count = new int[26];
            for(Character c : str.toCharArray()){
                count[c-'a']++; // [4,1,1,0000000000000]
            }

            String key = Arrays.toString(count);
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
