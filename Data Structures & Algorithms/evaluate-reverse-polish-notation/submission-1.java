class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;

        Stack<String> stack = new Stack<>();
        int ans = 0;
        for(String token : tokens){
            if(token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")){
                helper(stack, token);
            }else{
                stack.push(token);
            }
        }
        if(stack.isEmpty()) return 0;
        return Integer.valueOf(stack.pop());
    }

    private void helper(Stack<String> stack, String operator){
        Integer temp1 = 0;
        Integer temp2 = 0;
        if(!stack.isEmpty()){
            temp1 = Integer.valueOf(stack.pop());
        }
        if(!stack.isEmpty()){
            temp2 = Integer.valueOf(stack.pop());
        }   
        int ans = 0;
        if(operator.equals("+")){
            ans = temp1 + temp2;
        }else if(operator.equals("*")){
            ans = temp1 * temp2;
        }else if(operator.equals("-")){
            ans = temp2 - temp1;
        }else if(operator.equals("/")){
            ans = temp2 / temp1;
        }
        stack.push(Integer.toString(ans));
    }
}