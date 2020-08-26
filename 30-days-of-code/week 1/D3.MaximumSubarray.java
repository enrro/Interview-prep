class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, candidate = 0;
        if(nums == null) return -1;
        for(int i = 0; i < nums.length; i++){
            candidate += nums[i];
            if(candidate > max){
                max = candidate;
            }
            
            if(candidate < 0){
                candidate = 0;
            }
        }
    return max;
    }
}