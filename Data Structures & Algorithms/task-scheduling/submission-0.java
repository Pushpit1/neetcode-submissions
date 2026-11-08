class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character , Integer > mp =  new HashMap<>() ;
        for(char x : tasks){
           if(mp.containsKey(x)){
            mp.put(x , 1 +  mp.get(x)) ;
           }
           else{
           mp.put(x , 1) ;
           }
        }
        PriorityQueue<Integer>pq =  new PriorityQueue<>(Collections.reverseOrder());
        for(int x : mp.values()){
            pq.offer(x) ;
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        // 4. Scheduling
        while (!pq.isEmpty() || !q.isEmpty()) {

            // Release tasks from cooldown
            if (!q.isEmpty() && time >= q.peek()[1]) {
                int[] temp = q.poll();
                pq.offer(temp[0]);
            }

            // Execute available task
            if (!pq.isEmpty()) {
                int freq = pq.poll();
                freq--;

                if (freq > 0) {
                    q.offer(new int[]{freq, time + n + 1});
                }
            }

            time++;
        }

        return time;
    }
}
