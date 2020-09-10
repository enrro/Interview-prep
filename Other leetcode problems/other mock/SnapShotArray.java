/*
1146. Snapshot Array
Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 

Example 1:

Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation: 
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
https://leetcode.com/problems/snapshot-array/
*/
/*
approach
For this problem we need to optimize on space so we can't tradeoff memory for time. If you save the whole array for every snapshot there will be "Memory limit exceeded" error.

Essentially we are interested only in history of changes for the index, and it could be only few changes of one index. This means we need to lookup effectively value by index and save only those that changed. We can use Map for this, use index as key, value as a value.

We keep such map for every snapshot, each consequence change will override previous value but this is perfectly fine - we care only about last value. We keep maps in a list, index of the element is a snapshot index.

On value lookup we start scanning list elements starting from the passed snapshot_id back to 0. Return first value for the index that we found - this means the most recent change up to this snapshot_id. If we haven't found anything it means there were no changes and we can return initial value which is 0 for all elements.
*/
class SnapshotArray {
    List<Map<Integer, Integer>> list;
    
    public SnapshotArray(int length) {
        list = new ArrayList();
        list.add(new HashMap());
    }
    
    public void set(int index, int val) {
        int snapId = list.size() - 1;
        list.get(snapId).put(index, val);
    }
    
    public int snap() {
        list.add(new HashMap());
        return list.size() - 2;
    }
    
    public int get(int index, int snap_id) {
        for (int snap = snap_id; snap >= 0; snap--) {
            if (list.get(snap).containsKey(index))
                return list.get(snap).get(index);
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */