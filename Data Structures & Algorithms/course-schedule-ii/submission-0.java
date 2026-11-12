class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>() ;
        for(int i =0 ; i<numCourses ; i++){
            ls.add(new ArrayList<>());
        }
        int [] indegree =  new int [numCourses] ;
        for(int [] a : prerequisites){
            int u =  a[0] ;
            int v =  a[1] ;
            ls.get(v).add(u) ;
            indegree[u]++;           
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<indegree.length ; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        int [] ans = new int [numCourses] ;
        int b = 0 ;
        while(!q.isEmpty()){
            int top =  q.poll();
            ans[b] =  top ;
            for(int x : ls.get(top)){
                indegree[x]--;
                if(indegree[x]==0){
                q.offer(x);
                }
            }
            b++;
        }
        if(b==numCourses){
    return ans ;
        }

        return new int []{} ;
    }
}
