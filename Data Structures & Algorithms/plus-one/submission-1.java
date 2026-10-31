class Solution {
    public int[] plusOne(int[] digits) {
        long x = 1 ;
        long sum = 0 ;
        for(int i = digits.length-1 ; i>=0 ; i--){
            sum += digits[i]*x ;
            x = x*10 ;
        }
        ArrayList<Integer> ar = new ArrayList<>() ;
        sum+=1 ;
        while(sum!=0){
             ar.add((int)(sum%10)) ;
             sum = sum/10;
        }
        Collections.reverse(ar);

        int [] result = new int [ar.size()];
        for (int i=0 ; i<ar.size() ; i++){
        result[i] = ar.get(i);
        }

        return result;

        
    }
}
