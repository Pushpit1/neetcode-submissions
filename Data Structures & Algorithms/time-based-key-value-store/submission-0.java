class TimeMap {
    HashMap<String, ArrayList<Integer>> time;
    HashMap<String, ArrayList<String>> val;

    public TimeMap() {
        time = new HashMap<>();
        val = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!time.containsKey(key)) {
            time.put(key, new ArrayList<>());
            val.put(key, new ArrayList<>());
        }
        time.get(key).add(timestamp);
        val.get(key).add(value);
    }

    public String get(String key, int timestamp) {
        if (!time.containsKey(key)) {
            return "";
        }

        int left = 0;
        int right = time.get(key).size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (time.get(key).get(mid) <= timestamp) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (ans == -1) {
            return "";
        }

        return val.get(key).get(ans);
    }
}