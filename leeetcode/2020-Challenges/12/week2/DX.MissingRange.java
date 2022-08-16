/*
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"
Example 2:

Input: nums = [], lower = 1, upper = 1
Output: ["1"]
Explanation: The only missing range is [1,1], which becomes "1".
Example 3:

Input: nums = [], lower = -3, upper = -1
Output: ["-3->-1"]
Explanation: The only missing range is [-3,-1], which becomes "-3->-1".
Example 4:

Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.
Example 5:

Input: nums = [-1], lower = -2, upper = -1
Output: ["-2"]
 

Constraints:

-109 <= lower <= upper <= 109
0 <= nums.length <= 100
lower <= nums[i] <= upper
All the values of nums are unique.
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3558/
*/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i : nums) {
            if(i > lower) res.add(lower+((i-1 > lower)?"->"+(i-1):""));
            if(i == upper) return res; // Avoid overflow
            lower = i+1;
        }
        if(lower <= upper) res.add(lower + ((upper > lower)?"->"+(upper):""));
        return res;
    }
}

// not so clean but better interview wise cause you are more likely to come across this ans
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int l = 0, r = 0;
        List<Pair<Integer,Integer>> list = new ArrayList();
        List<String> out = new ArrayList<>();
        int n = nums.length;
        if(n == 0){
            list.add(new Pair(lower,upper));
            return format(list);
        }
        if(nums[0] > lower){
            list.add(new Pair(lower, nums[0] - 1));
        }
        for(int i = 1; i < n; i++){
            int curr = nums[i];
            if(curr - 1 != nums[i - 1]){
                l = nums[i - 1] + 1;
                r = curr -1;
                list.add(new Pair(l, r));
            }
        }
        
        if(nums[n-1] < upper){
            list.add(new Pair(nums[n-1] + 1, upper));
        }
        
        return format(list);
    }
    
    public List<String> format(List<Pair<Integer, Integer>> list){
        List<String> out = new ArrayList<>();
        
        for(var pair : list){
            if(pair.getKey() == pair.getValue()){
                out.add("" + pair.getKey());
            } else{
                out.add(pair.getKey() + "->" + pair.getValue());
            }
        }
        return out;
    }
}