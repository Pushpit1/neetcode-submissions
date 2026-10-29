class Solution {
    public int countComponents(int n, int[][] edges) {
     ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
     for(int i = 0 ; i<n ; i++){
        adj.add(new ArrayList<>()) ;
     }
     for(int [] e : edges){
        int u = e[0] ;
        int v = e[1] ;
        adj.get(u).add(v) ;
        adj.get(v).add(u) ;
     }
     boolean [] visited = new boolean [n] ;

     int count = 0 ;
     Queue<Integer> q = new LinkedList<>() ;
    
    for (int i = 0; i < n; i++) {
    if (!visited[i]) {
        count++ ;
        visited[i] =true ;
        q.offer(i) ;

        while (!q.isEmpty()) {
            int node = q.poll() ;

            for(int x : adj.get(node)){
                if(visited[x]==true ){
                    continue ;
                }
                visited[x] = true ;
                q.offer(x) ;
                
            }
        }
    }
}
    return count ;

    }
}
