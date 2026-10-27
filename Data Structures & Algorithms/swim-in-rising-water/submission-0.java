class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<List<Integer>>q =  new PriorityQueue<>((a,b)->Integer.compare(a.get(0) , b.get(0))) ;
        q.offer(Arrays.asList(grid[0][0] , 0 , 0));

        int [][] visited = new int [grid.length][grid[0].length] ;
        for(int i = 0 ;  i<grid.length ; i++){
            Arrays.fill(visited[i] , 0 ) ;
        }
        int [] dr = {0 , 1 , -1 , 0} ;
        int [] dc = {1 , 0 , 0 , -1 } ;

        while(!q.isEmpty()){
             List<Integer> cur = q.poll() ;
             int prevTime = cur.get(0);
             int row = cur.get(1) ;
             int col = cur.get(2) ;
             if (row == grid.length - 1 && col == grid.length - 1){
                return prevTime;
             }
             if(visited[row][col]==1){
                continue ;
             }
             visited[row][col] = 1 ;

             // i know we save the row and column
             for(int i = 0 ; i<4 ; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr>=grid.length || nr<0 ||nc>=grid[0].length || nc<0 ||visited[nr][nc]==1){
                    continue ;
                }
                int newtime = Math.max(prevTime , grid[nr][nc]);
                q.offer(Arrays.asList(newtime ,nr , nc )) ;

               
             }

        }
    return 0 ;

    }
}
