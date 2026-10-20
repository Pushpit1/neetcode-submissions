class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer , Integer > mp = new HashMap<>() ;
        for(int x : nums){
            mp.put(x , mp.getOrDefault(x,0) + 1);
             if (mp.get(x) > 1) {
                return x;
            }
        }
        
        return -1 ;
        
    }
}
