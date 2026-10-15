class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(mp.get(b), mp.get(a))
        );

        for (int x : mp.keySet()) {
            pq.offer(x);
        }

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = pq.poll();
        }

        return arr;
    }
}
