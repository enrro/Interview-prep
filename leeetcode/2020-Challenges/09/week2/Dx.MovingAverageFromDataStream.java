class MovingAverage {
    LinkedList<Integer> head;
    int sum;
    int size;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.head = new LinkedList();
        this.sum = 0;
    }
    
    public double next(int val) {
        head.add(val);
        sum += val;
        if(head.size() > size){
            sum -= head.poll();
        }
        
        return (double)sum/head.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */