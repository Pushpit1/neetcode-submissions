class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int sum = 0 ;
      for(int x : piles){
        sum+=x ;
      }
      Arrays.sort(piles) ;
      int left = 1 ;
      int right = piles[piles.length-1];
    
      while(left<right){
      int total = 0 ;
      int k = left + (right-left)/2 ;
      for(int z : piles){
        
        int hour = (z + k - 1)/k ;

        total+=hour ;
        
      }
      
        if(total<=h){
          right = k ;
        }
        else{
            left = k+1;
        }

    
      }
      return left ;
      }
      
    }

