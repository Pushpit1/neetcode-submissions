class CountSquares {

    HashMap<Integer, HashMap<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x, new HashMap<>());

        map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        int ans = 0;

        for (int x2 : map.keySet()) {

            int d = x2 - x;

            if (d == 0) continue;

            int y1 = y + d;
            int y2 = y - d;

            ans += get(x2, y) * get(x, y1) * get(x2, y1);

            ans += get(x2, y) * get(x, y2) * get(x2, y2);
        }

        return ans;
    }

    public int get(int x, int y) {

        if (!map.containsKey(x)) return 0;

        return map.get(x).getOrDefault(y, 0);
    }
}