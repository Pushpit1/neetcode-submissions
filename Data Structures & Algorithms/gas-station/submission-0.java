class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int fuel = 0;
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];

            fuel += net;
            total += net;

            if (fuel < 0) {
                start = i + 1;
                fuel = 0;
            }
        }

        return total < 0 ? -1 : start;
    }
}