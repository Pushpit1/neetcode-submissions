class Solution {
    public String multiply(String num1, String num2) {
        // 1. Convert strings to BigInteger
        java.math.BigInteger a = new java.math.BigInteger(num1);
        java.math.BigInteger b = new java.math.BigInteger(num2);

        // 2. Multiply them
        java.math.BigInteger product = a.multiply(b);

        // 3. Return the result as a String
        return product.toString();
    }
}
