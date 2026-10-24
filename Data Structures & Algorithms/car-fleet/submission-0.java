class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         Stack<Double> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        int fleet = 0 ;
        for(int i = position.length - 1; i >= 0; i--){
            double time  = (double) (target - position[i])/map.get(position[i]) ;
            if (st.isEmpty() || time > st.peek()) {
            st.push(time);
            fleet++;
             }
        }
        return fleet ;
    }
}
