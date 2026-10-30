class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp =  new int [m+1][n+1] ;
        for(int i = 0 ; i<m ; i++){
            Arrays.fill(dp[i] , 0);
        }
        for(int i = m-1 ; i>=0 ; i--){
            for(int j = n-1 ; j>=0 ; j--){
                if(i>=m || i<0 || j>=n || j<0){
                    dp[i][j] = 0 ;
                }
                if(i==m-1 && j==n-1){
                    dp[i][j] = 1 ;
                    continue ;
                }

                dp[i][j] = dp[i][j+1] + dp[i+1][j] ;

            }
        }
    return dp[0][0] ;
        
    }
}
