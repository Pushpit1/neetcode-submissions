class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> h = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int fixed = nums[i];
            int l = i+1 ;
            int r = nums.length -1 ;
            while(l<r){
                    int sum = fixed + nums[l] + nums[r];
                    if (sum == 0) {
                        List<Integer> sm = new ArrayList<>();
                        sm.add(fixed);
                        sm.add(nums[l]);
                        sm.add(nums[r]);

                        Collections.sort(sm);
                        h.add(sm);
                        l++;
                        r--;
                    }
                    else if(sum>0){
                        r--;
                    }
                    else{
                        l++;
                    }

                }
        }
        return new ArrayList<>(h);
    }
}
