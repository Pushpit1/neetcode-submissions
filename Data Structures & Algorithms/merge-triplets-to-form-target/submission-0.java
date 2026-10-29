class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length ;
        int maxA = 0 ;
        int maxB = 0 ; 
        int maxC = 0 ;
        for(int i = 0 ; i<n ; i++){
            int a = triplets[i][0] ;
            int b = triplets[i][1] ;
            int c =  triplets[i][2] ;
            if(a <= target[0] && b <= target[1] && c<=target[2]){
                maxA = Math.max(maxA , a) ;
                maxB = Math.max(maxB , b) ;
                maxC = Math.max(maxC , c) ;
            }
           
        }
        if(maxA == target[0] && maxB == target[1] && maxC == target[2] ){
            return true ;
        }

        return false ;

    }
}
