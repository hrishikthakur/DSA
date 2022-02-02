class Solution {
    public boolean isValid(String input) {

        Stack<Character> stk = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (ch == '[' || ch == '{' || ch == '(')
                stk.push(ch);

            else if (ch == ']') {
                if (stk.size() == 0 || stk.peek() != '[')
                    return false;
                stk.pop();
            }

            else if (ch == '}') {
                if (stk.size() == 0 || stk.peek() != '{')
                    return false;
                stk.pop();
            }

            else if (ch == ')') {
                if (stk.size() == 0 || stk.peek() != '(')
                    return false;
                stk.pop();
            }
        }

        return (stk.size() == 0) ? true : false;

    }
}
