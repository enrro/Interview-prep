/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
 
Constraints:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/
// The idea behind this approach is as follows: If the cumulative sum up to two indices is the same, the sum of the elements lying in between those indices is zero
// Extending the same thought further, if the cumulative sum upto two indices, say ii and jj is at a difference of kk i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k,
// the sum of elements lying between indices ii and jj is kk.

//  HashSet<CurrentSum, NumberOfOcurrancesBefore>
//  have we seen our sum - k before? 

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
                totalways += hm.get( sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        
        return totalways;
    }
}
