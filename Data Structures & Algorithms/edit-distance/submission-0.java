class Solution {
    int memo(int i , int j , String word1 , String word2 , int [][] memo){
       if(i==word1.length()){
            return word2.length()-j ;
       }
       if(j==word2.length()){
        return word1.length()-i ;
       }
       if(memo[i][j]!=-1){
        return memo[i][j] ;
       }
       if(word1.charAt(i)==word2.charAt(j)){
         return memo[i][j] = memo(i+1 , j+1 , word1 , word2 , memo);
       }
       int del =  memo(i+1 , j ,  word1 , word2 , memo);
       int repl = memo(i+1 , j+1 ,  word1 , word2 , memo);
       int ins = memo(i , j+1 ,  word1 , word2 , memo);

       memo[i][j] = 1+ Math.min(del , Math.min(repl , ins));

       return memo[i][j] ;
    }
    public int minDistance(String word1, String word2) {
        int [][]memo =  new int [word1.length()][word2.length()];
        for(int i = 0 ; i<memo.length ; i++){
            Arrays.fill( memo[i] , -1) ;
        }
        return memo(0 , 0 , word1 , word2 , memo);
    } 
}
