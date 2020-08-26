class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null) return;
        int current = 0, lastCero = 0;
        
        //override every 0 value in the array with its next non cero value
        while(current < nums.length){
            if(nums[current] != 0){
                nums[lastCero++] = nums[current];
            }
            current++;
        }
        //fill the rest of the array with ceroes.
        System.out.println(lastCero);
        for(; lastCero < nums.length; lastCero++){
            nums[lastCero] = 0;
        }
    }
}