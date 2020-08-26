// [1,1,1]
// the distance between 2 points 
// if you add a current sum and you have seen a sum in 2 different points at the array
// and you substract them, the total sums from those points at different index and they add up to k
// then the array between those points is size k.
    
//     have we seen our sum - k before.? 



class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null) return 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum = 0;
        int totalways = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(hm.containsKey(sum - k)){
                totalways += hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        
        return totalways;
    }
}
