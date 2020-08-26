class LRUCache {
    int capacity;
    HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
    LinkedListNode head = new LinkedListNode();
    LinkedListNode tail = new LinkedListNode();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.next = head;
        
    }
    
    public int get(int key) {
        LinkedListNode node = map.get(key);
        if(node == null) return -1;
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        LinkedListNode node = map.get(key);
        if(node != null){
            node.value = value;
            remove(node);
            add(node);
        }else{
            if(map.size() == capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            LinkedListNode newNode = new LinkedListNode();
            newNode.key = key;
            newNode.value = value;
            
            map.put(key, newNode);
            add(newNode);
        }
    }
    
    public void add(LinkedListNode node){
        LinkedListNode  headNext = head.next;
        node.next = headNext;
        headNext.prev = node; 
        head.next = node;
        node.prev = head;
    }
    
    public void remove(LinkedListNode node){
        LinkedListNode nextNode = node.next;
        LinkedListNode prevNode = node.prev;
        
        nextNode.prev = prevNode;
        prevNode.next = nextNode;

    }
    
    class LinkedListNode{
        private LinkedListNode next, prev;
        public int key;
        public int value;
        public LinkedListNode(){}
        public LinkedListNode(int k, int v){
            key = k;
            value = v;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */