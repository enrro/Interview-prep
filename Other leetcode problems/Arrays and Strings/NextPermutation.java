/**
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3050/
 */
/*
I don't know how many guys come up this solution only by himself. At least I cannot, I even don't know what is the next permutation. I stole this solution from somewhere to here because I don't see a clear explanation in LeetCode discussion. I think the biggest problem of this community is people here are too smart. They like writing "short code", they like using annotations like nums[k] < nums[k + 1], they don't like to give example. Even when a problem as abstract as this one.

I don't think any one can understand this solution without seeing an example, here is an example:
2,3,6,5,4,1

Solution:
Step1, from right to left, find the first number which not increase in a ascending order. In this case which is 3.
Step2, here we can have two situations:

We cannot find the number, all the numbers increasing in a ascending order. This means this permutation is the last permutation, we need to rotate back to the first permutation. So we reverse the whole array, for example, 6,5,4,3,2,1 we turn it to 1,2,3,4,5,6.

We can find the number, then the next step, we will start from right most to leftward, try to find the first number which is larger than 3, in this case it is 4.
Then we swap 3 and 4, the list turn to 2,4,6,5,3,1.
Last, we reverse numbers on the right of 4, we finally get 2,4,1,3,5,6.

Time complexity is: O(3*n)=O(n).
*/
class Solution {
    public void nextPermutation(int[] nums) {
      int n = nums.length - 1, p = -1, pv = 0;

      for(int i = n - 1; i >= 0; i--){
        if(nums[i] < nums[i + 1]) {
            p = i;
            pv = nums[i];
            break;
        }
      }    
      
      if(p == -1) {
        reverse(nums, 0, n);
        return;
      }
      
      for(int i = n; i >= 0; i--){
        if(nums[i] > pv){
          swap(nums, p, i);
          break;
        }
      }
      
      reverse(nums, p + 1, n);
    }
    
    void reverse(int[] nums, int s, int e){
      while(s < e){
        swap(nums, s, e);
        s++;
        e--;
      }
    }
    
    void swap(int[] nums, int s, int e){
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;     
    }
}