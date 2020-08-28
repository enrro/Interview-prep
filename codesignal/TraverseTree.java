/* https://app.codesignal.com/interview-practice/task/PhNPP45hZGNwpPchi/description */
public class TraverseTree {

}
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
int[] traverseTree(Tree<Integer> t) {
    if(t == null){
        return new int[0];
    }
    LinkedList<Integer> ll = new LinkedList<Integer>();
    Deque<Tree<Integer>> dq = new LinkedList<Tree<Integer>>();
    Tree<Integer> temp;
    dq.push(t);
    while(!dq.isEmpty()){
        temp = dq.removeFirst();
        System.out.println(temp.value);
        ll.add(temp.value);
        if(temp.left != null){
            dq.addLast(temp.left);
        }
        if(temp.right != null){
            dq.addLast(temp.right);
        }
    }
    int[] array = ll.stream().mapToInt(i->i).toArray();
    return array;
}
