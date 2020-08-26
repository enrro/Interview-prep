class Solution {
    public int countElements(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            hs.add(arr[i]);
        }
        
        for(int i = 0; i < arr.length; i++){
            if(hs.contains(arr[i]+1)){
                ans++;
            }
        }
        
        System.out.println(hs);
        return ans;
    }
}