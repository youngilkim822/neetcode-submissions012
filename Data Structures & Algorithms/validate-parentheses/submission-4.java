class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() %2 == 1) return false;
        
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if(stack.isEmpty()) return false;
                if(c == ')'){
                    if(stack.pop() != '('){
                        return false;
                    }
                }else if(c == '}'){
                    if(stack.pop() != '{'){
                        return false;
                    }
                }else if(c == ']'){
                    if(stack.pop() != '['){
                        return false;
                    }
                }   
            }
            
            
        }
        return stack.isEmpty();
    }
}
/*

([{}])
)
]
}
{
[
(
*/