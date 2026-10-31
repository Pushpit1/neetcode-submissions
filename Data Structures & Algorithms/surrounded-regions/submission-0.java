class Solution {
    public void solve(char[][] board) {
        int n =  board.length ;
        int m = board[0].length ;

        Queue<int []> q =  new LinkedList<>() ;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(board[i][j] == 'O'){
                    q.offer(new int []{i , j }) ;
                    board[i][j] = '#';
                    }
                }
               
            }
        }
        int [] dr = {-1 , 1 , 0 , 0} ;
        int [] dc = {0 , 0 , -1 , 1} ;
        while(!q.isEmpty()){
            int [] cur = q.poll() ;
            int row = cur[0] ;
            int col = cur[1] ;

            for(int i = 0 ; i<4 ; i++){
                int nr = row + dr[i] ;
                int nc =  col + dc[i] ;
                if(nr>=n || nr<0 || nc>=m || nc<0 || board[nr][nc] != 'O'){
                    continue ;
                }
                board[nr][nc] = '#' ;
                q.offer(new int []{nr , nc}) ;
            }
        }

        for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        if (board[i][j] == 'O') {
            board[i][j] = 'X';
        } else if (board[i][j] == '#') {
            board[i][j] = 'O';
        }
    }
}

    }
}
