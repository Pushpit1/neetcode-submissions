class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>( (a,b) ->Integer.compare(b , a));
        for(int x :stones){
            pq.offer(x);
        }
        while(pq.size()>1){
            int a = pq.poll() ;
            int b = pq.poll();
            if(a!=b){
                pq.offer(a-b);
            }
           
        }
        if(pq.size()==1){
            return pq.peek();
        }
        return 0 ;
    }
}
