
# algorithms

| algorithm                                                                                                      | uses                                                                                           |
| -------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| [adjacency list](leeetcode/Other%20leetcode%20problems/trees%20and%20graphs/CourseSchedule.java)               | when edges between nodes are well defined we can use this to detecting cycle in directed graph |
| [top K frequent elements](leeetcode/Other%20leetcode%20problems/SortingandSearching/TopKFrequentElements.java) | transform list of Integer to array of integer                                                  |



# java syntax
## comparators
```java
// priority queue slow route
PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
    @Override
    public int compare(ListNode o1,ListNode o2){
        if (o1.val<o2.val)
            return -1;
        else if (o1.val==o2.val)
            return 0;
        else 
            return 1;
    }
});

// priority queue not as slow route
PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(list.length, new Comparator<>(
    @Override
    public int compare(ListNode l1, ListNode l2){
        return l1.val - l2.val;
    }
));

// priority queue fast route
PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a,b) -> a.val - b.val);
```


# vocabulary

| concept  | definition                    |
| -------- | ----------------------------- |
| vertices | a node in a tree              |
| edge     | a connection between vertices |
