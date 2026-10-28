class Solution {
    int f( int []memo , int n){
        if(n==0){
          return 1 ;
        }
        if(n<0){
            return 0 ;
        }
        if(memo[n]!=-1){
            return memo[n] ;
        }

        memo[n] = f(memo , n-1) + f(memo , n-2) ;

        return memo[n] ;
    }
    public int climbStairs(int n) {
        int [] memo =  new int [n+1] ;
        Arrays.fill(memo , -1);

        return f(memo , n) ;
    }
}
