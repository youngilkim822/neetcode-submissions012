class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        for(Character c : s1.toCharArray()){
            arr[c-'a']++;
        }

        int m = s1.length();
        int n = s2.length();
        for(int i=0; i<n-m+1; i++){
            String str = s2.substring(i, i+m);
            if(check(str, arr.clone())) return true;
        }
        return false;
    }

    private boolean check(String str, int[] arr){
        for(Character c : str.toCharArray()){
            if(arr[c-'a'] <= 0){
                return false;
            }
            arr[c-'a']--;
        }
        return true;
    }
}
