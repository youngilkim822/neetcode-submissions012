class Solution {

    public String encode(List<String> strs) { // {"4%abc","a%a"}
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append('%').append(str); // 5%4%abc    3%a%a
        }
        return sb.toString();
    }

    public List<String> decode(String str) { // str = "5%4%abc3%a%a"
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            StringBuilder lengthNum = new StringBuilder();
            while(str.charAt(i) != '%'){
                lengthNum.append(str.charAt(i));
                i++;
            }
            int len = Integer.parseInt(lengthNum.toString());
            i++;

            String subString = str.substring(i,i+len);
            list.add(subString);
            i=i+len;
        }
        return list;
    }
}

/*
List<String> strs = ["a","aa","aaa"]
String encodedString = encode(strs); // encodedString = "aaaaaa"
List<String> decodedStrings = decode(encodedString); // ["a","aa","aaa"]

Q1) strs // char


*/
