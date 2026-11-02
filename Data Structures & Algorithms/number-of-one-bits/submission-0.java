class Solution {
    public int hammingWeight(int n) {
    int count  = 0 ;
    for(int i  = 0 ; i<32 ; i++){
        int result = n&(1<<i) ;
        if(result!=0){
            count++ ;
        }
    } 
    return count ; 
    }
}
