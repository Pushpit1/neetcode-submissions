class Solution {
    public int rob(int[] nums) {
        int [] dp =  new int [nums.length+2] ;
    
        for(int i = nums.length -1 ; i>=0 ; i--){
            int take = dp[i+2] + nums[i] ;
            int skip = dp[i+1] ;

            dp[i] =  Math.max(take , skip) ;
        }
        return dp[0] ;
    }
}
