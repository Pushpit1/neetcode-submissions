class Solution {
    public double myPow(double x, int n) {
        long p = n;

        if (p < 0) {
            p = -p;
            x = 1 / x;
        }

        return find(p, x);
    }

    double find(long n, double x) {
        double ans = 1;

        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x;
            }

            x *= x;
            n /= 2;
        }
        return ans;
    }
}
