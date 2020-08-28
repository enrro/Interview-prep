/*
excersice
https://app.codesignal.com/interview-practice/task/BG94ZFECSNo6Kv7XW
*/

int kthLargestElement(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
    int temp = 0;
    for(int num : nums){
        pq.add(num);
    }
    for(int i = 0; i < k; i++){
        temp  = pq.poll();
    }
    return temp;
}
