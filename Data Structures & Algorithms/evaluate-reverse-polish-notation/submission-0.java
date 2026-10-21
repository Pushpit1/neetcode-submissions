class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String x : tokens) {
            if (x.equals("+") || x.equals("-") ||
                x.equals("*") || x.equals("/")) {

                int b = st.pop();
                int a = st.pop();

                if (x.equals("+")) {
                    st.push(a + b);
                } else if (x.equals("-")) {
                    st.push(a - b);
                } else if (x.equals("*")) {
                    st.push(a * b);
                } else {
                    st.push(a / b);
                }

            } else {
                st.push(Integer.parseInt(x));
            }
        }

        return st.pop();
    }
}