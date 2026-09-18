class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length() <= 1) return true;
        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')){
                sb.append(c);
            }
        }
        String str = sb.toString().toLowerCase();
        int i=0;
        int j=str.length()-1;
        
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
