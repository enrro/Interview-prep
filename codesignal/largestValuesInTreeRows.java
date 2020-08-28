//
// Binary trees are already defined with this interface:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
int[] largestValuesInTreeRows(Tree<Integer> t) {
    if(t == null) return new int[0];

    Deque<Tree<Integer>> dq = new LinkedList<Tree<Integer>>();
    Deque<Tree<Integer>> aux = new LinkedList<Tree<Integer>>();
    LinkedList<Integer> maxResults = new LinkedList<Integer>();
    Tree<Integer> temp;
    int max;

    dq.addLast(t);
    
    while(!dq.isEmpty()){
        max = Integer.MIN_VALUE;
        while(!dq.isEmpty()){
            temp = dq.removeFirst();
            if(temp.value > max){
                max = temp.value;
            }
            if(temp.left != null){
                aux.addLast(temp.left);
            }if(temp.right != null){
                aux.addLast(temp.right);
            }
        }
        maxResults.add(max);

        max = Integer.MIN_VALUE;
        while(!aux.isEmpty()){
            temp = aux.removeFirst();
            if(temp.value > max){
                max = temp.value;
            }
            if(temp.left != null){
                dq.addLast(temp.left);
            }if(temp.right != null){
                dq.addLast(temp.right);
            }
        }
        if(max != Integer.MIN_VALUE){
            maxResults.add(max);
        }
    }
    
    return maxResults.stream().mapToInt(i->i).toArray();
}



/*second try*/
//
// Binary trees are already defined with this interface:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
int[] largestValuesInTreeRows(Tree<Integer> t) {
    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    auxFunction(t, map, 0);
    int[] solution = new int[map.keySet().size()];
    for(Integer key : map.keySet()){
        solution[key] = map.get(key);
    }
    return solution;
}

void auxFunction(Tree<Integer> t, HashMap<Integer,Integer> map, int level){
    if(t == null) return;

    
    if(!map.containsKey(level) || map.get(level) < t.value){
        map.put(level, t.value);
    }

    auxFunction(t.left, map, level + 1);
    auxFunction(t.right, map, level + 1);
}