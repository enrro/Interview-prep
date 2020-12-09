
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