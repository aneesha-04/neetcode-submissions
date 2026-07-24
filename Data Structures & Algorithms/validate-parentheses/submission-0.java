class Solution {
    public boolean isValid(String s) {
        
        char[] stack = new char[s.length()];
        int top = -1;  // stack pointer

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If opening bracket → push
            if(ch == '(' || ch == '{' || ch == '[') {
                top++;
                stack[top] = ch;
            }
            else {
                // If stack empty
                if(top == -1) {
                    return false;
                }

                char last = stack[top];
                top--;   // pop

                if((ch == ')' && last != '(') ||
                   (ch == '}' && last != '{') ||
                   (ch == ']' && last != '[')) {
                    return false;
                }
            }
        }

        // If stack empty → valid
        return top == -1;
    }
}
