class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>>adj =  new ArrayList<>() ;
        for(int i=0; i<numCourses ; i++){
           adj.add(new ArrayList<>());
        }
        int [] indegree = new int [numCourses] ;
        for(int []edges : prerequisites){
            int u = edges[0] ;
            int v = edges[1] ;
            adj.get(v).add(u) ;
            indegree[u]++;
        }
        Queue<Integer>q = new LinkedList<>() ;
        for(int i = 0 ;  i<numCourses ; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int completed = 0 ;
        while(!q.isEmpty()){
            int curr = q.poll() ;
            completed ++;
            for(int node : adj.get(curr)){
                indegree[node]--;

                if(indegree[node]==0){
                    q.offer(node) ;
                }
            }
        }
        return completed == numCourses ;

    }
}
