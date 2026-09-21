class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(j < s.length()){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                j++;
                max = Math.max(max, (j-i));
                continue;
            }
            set.remove(s.charAt(i));
            i++;
        }
        return max;
    }
}
