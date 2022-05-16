
public class RemoveDuplicatesFromSortedArray {

}
class Solution {
    // Given nums = [1,1,2],
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        int fast = 0;
        
        while(fast < nums.length){
            if(nums[fast] != nums[slow]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        
        System.out.println(Arrays.toString(nums));
        return slow+1;
    }
}


// other approach
// very similar to the last one. Slightly easier to read
// 2 pointers, faster pointer updates the slowest one once it founds a 
// number different to the previous one. since they are in order this works to detect duplicates.
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int l = 1, r = 1;
        for(; r < nums.length; r++){
            if(nums[r] != nums[r - 1]){
                nums[l++] = nums[r];
            }
        }
        
        return l;
    }
}