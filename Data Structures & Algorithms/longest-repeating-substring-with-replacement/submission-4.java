class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while(left < s.length() && right < s.length()){
            char c = s.charAt(right);
            hashMap.put(c, hashMap.getOrDefault(c,0)+1);

            int max = Collections.max(hashMap.values());
            int temp = (right - left + 1) - max;
            if(temp <= k){
                ans = Math.max(ans, right-left+1);
                right++;
            }else{
                hashMap.put(c, hashMap.get(c)-1);
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left))-1);
                left++;
            }
        }
        return ans;
    }
}