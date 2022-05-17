// "static void main" must be defined in a public class.
// A farmer uses pivot irrigation to water a circular field of crops. Due to varying conditions, the field does not produce consistently. The farmer wants to achieve maximum profit using limited resources for harvest. The field is segmented into a number of equal segments, and a profit is calculated for each segment. This profit is the cost to harvest versus the sale price a the produce. The farmer will harvest a number of contiguous segments along with those opposite. Determine the maximum profit the farmer can achieve. For example, the field is divided into n = 6 sections and will select k = 2 contiguous sections and those opposite for harvest. The profit estimates are profit = [1, 5, 1, 3, 7.-3) respectively. The diagrams below show the possible choices with profits(0) at the 9 o'clock position and filling counterclockwise. -3 The profit levels, from left to right, are 1 + 5+7 + 3 - 16,5+1 +7 +-3-10, and 1 + 3+3+1 -2. The maximum profit is 16. Function Description Complete the function maxProfit in the editor below. The function must return the maximum profit achievable. maxProfit has the following parameters: k an integer denoting the half of the needed amount of pieces of the field. profit[profit[0],..profit[n-1].
// https://leetcode.com/discuss/interview-question/1321204/efficient-harvest-faang-oa-question-2021

public class Main {
    public static void main(String[] args) {
        
        int[] t1 = {1,3,7,-3,1,5};
        int[] t2 = {3, -5};
        int[] t3 = {-6,3,6,-3};
        int[] t4 = {3, -5};
        
        System.out.println(maxHarverst(t1, 2));
        System.out.println(maxHarverst(t2, 2));
        System.out.println(maxHarverst(t3, 2));
        System.out.println(maxHarverst(t4, 1));
    }
    
    public static int maxHarverst(int[] arr, int k){
        int res = Integer.MIN_VALUE; 
        int n = arr.length;
        for(int i = 0; i < n / 2; i++){ // traverse half the array
            int profit = 0;
            for(int j = 0; j < k; j++){
                int corIndex = i + j;
                int opositeIndex = complementaryIndex(corIndex, n);
                profit += arr[corIndex] + arr[opositeIndex];
            }
            res = Math.max(res, profit);
        }
        return res;
    }
    
    public static int complementaryIndex(int i, int n){
        return (i + n / 2) % n; // gets the oposite slice. module keep it within the bound when last slice reached
    }
}