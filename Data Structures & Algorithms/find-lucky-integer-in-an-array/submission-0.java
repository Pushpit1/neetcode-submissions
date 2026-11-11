class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        int max = -1;
        for (int key : mp.keySet()) {
            if (key == mp.get(key)) {
                max = Math.max(max, key);
            }
        }

        return max;
    }
}
