class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char x : s.toCharArray()) {
            if (x == '(' || x == '{' || x == '[') {
                st.push(x);
            } else {
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.peek();

                if ((top == '(' && x == ')') ||
                    (top == '{' && x == '}') ||
                    (top == '[' && x == ']')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
