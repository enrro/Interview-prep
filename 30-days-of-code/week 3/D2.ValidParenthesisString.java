class Solution {
    public boolean checkValidString(String s) {
        if(s.length() == 0){
            return true;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '('){
                stack1.push(i);
            }
            else if(c == ')'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
                else if(!stack2.isEmpty()){
                    stack2.pop();
                }
                else{
                    return false;
                }
            }
            else if(c == '*'){
                stack2.push(i);
            }
            i++;
        }
        while(!stack1.isEmpty()){
            if(stack2.isEmpty()){
                return false;
            }
            int index = stack2.pop();
            if(index > stack1.peek()){
                stack1.pop();
            }
        }
        return true;
    }
}