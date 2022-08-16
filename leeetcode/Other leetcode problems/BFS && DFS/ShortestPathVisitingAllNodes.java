/*
You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

 

Example 1:


Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
Example 2:


Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]
 

Constraints:

n == graph.length
1 <= n <= 12
0 <= graph[i].length < n
graph[i] does not contain i.
If graph[a] contains b, then graph[b] contains a.
The input graph is always connected.
https://leetcode.com/problems/shortest-path-visiting-all-nodes/
*/

/*
How one will approach in 45 min interview?
https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/549233/Breadth-First-Search(BFS)with-intuitive-approach-Thinking-process-or-13-ms
Very first thing comes in undirected graph for finding shortest path is bfs. Since, bfs ensures that a node at distance k will be visited first then a node at k+1 distance. But problem given here, is slightly different. Here in the problem it is given that we can visit any node any number of time, even we can use edge more than once.

This means that we can't use simple bfs (in which we maintain a visited set - to avoid cycle) because in the problem we can visit a node any number of time.
Take an example to understand why simple bfs will not work?

0 -- 1
| \
2  3
If we start bfs from 0,
{0} -> {0,1} -> stuck as we have visited 0 already.
If we start bfs from 1,
{1}->{1,0}->{1,0,3}-> Stuck as we already visited 0
You got the idea.

So, the point which I am trying to make here is this,

If we apply simple bfs starting from any node(say 0) where we also keep track of visited array (Consecutively meaning we can't visit them again) it will never lead us to the solution.
On the other hand if we apply bfs from any node (say 0) and don't keep the track of visited array, it will lead to cycle [ {0}->{0,1}->{0,1,0}->{0,1,0,1} and so on]
What if there is a way, in which we can visit the same node again and still avoid cycle. lets call this type of bfs as intelligent bfs.
that means,

If starting node is 0
{0}->{0,1}->{0,1,0}-{0,1,0,3}->{0,1,0,3,0,2}
If starting node is 1,
{1}->{1,0}->{1,0,2}->{1,0,3}->{1,0,3,0}->{1,0,3,0,2}

That means we still need to iterate this intelligent bfs from each node and see from which node we are getting minimum answer.

Now, lets assume that we have devised this intelligent bfs.

Simultaneously BFS
What if we apply bfs on every node in one go. In other words, start bfs on each node simulatneously? That is, Queue for bfs will now be

[ {0},{1},{2},{3} ] -> [ {0,1} ,{0,2},{0,3}, {1,0}, {2,0}, {3,0}  ] -> [...]
where each step(which is [...] ) in bfs will contains set of nodes or path visited in bfs fashion for each of the element in previous step.

The advantage (If we have that intelligent bfs) we will reach the answer fastly rather then applying bfs individually as in individual bfs we need to extend bfs unecessary for current starting node, while we would have reached to the answer earlier if we would have started using some other starting node.

Intelligent BFS

Intelligent bfs should be such which will able to detect if including current node will result into cycle or not.
Take an example,

Take individual bfs starting from 0
{0}->{0,1}->{0,1,0}->Now we should not got to {0,1,0,1}.

If you see we already visited set of nodes {0,1} while we are at 0. (bold above). So we must not include 1 again as resulting visited list will become {0,1} again.

Take another example,
Starting from 1,

{1}->{1,0}->{1,0,1} = (We should visited this as by visiting 1 again (currently current node is 1) this could lead to some other path which would have connected to 1 only)

{1}->{1,0}->{1,0,1} -> {1,0,1,0} = (This shouldn't be visited) as by including 0 again, this is just repetition of 0 and 1 again in other words, by including 0 again resulting visited set will become {0,1} which we already visited(bold above)

In nutshell, for each current head(or leading) node we must maintain a space where we can check whether we visited that set of path again or not).

We can use (dist) 2d matrix, dist[mask][lead] where mask is rows and lead are columns.
lead/colums will denote all nodes and mask/rows will denote all possible combination of set of nodes which is visited.

Mask - Example: 
0 0 0 1  => 0th node is visited
3 2 1 0 

0 1 1 0 => 1 & 2 nodes are visited
3 2 1 0

For bit masking,
[https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/]

Take 2D Matrix dist[][] where, dist[i][j] represent if jth node is the leading node(end of the path so far), then what is the path distance (min distance) we have covered if all set bits in i nodes are visited.

So We will implements simulatneously bfs starting from each node, and keep track of distance using dist 2d matrix.
Due to simulatneously bfs over all node, whenever we encouter that i where all bits are set, that will be the answer, as it is bfs in undirected graph which ensures that a node at distance k will be visited first then a node at k+1 distance.
*/

class Solution {
    public int shortestPathLength(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int n = graph.length;
        // Adjency list of graph
        for(int i=0;i<n;i++){
            if(!hm.containsKey(i)){
                hm.put(i, new ArrayList<Integer>());
            }
            
            int m = graph[i].length;
            for(int j=0;j<m;j++){
                hm.get(i).add(graph[i][j]);
            }
        }
        //dist 2d array
        //row: bitmask -> visited node set bits are 1
        //column: leading node
        int row = (int)Math.pow(2,n);
        int col = n;
        int dist[][] = new int[row][col];
        
        for(int i=0;i<row;i++){
            Arrays.fill(dist[i], -1);
        }
        
        
        //Queue: [{leading node 1, mask},{leading node 2, mask} ... ]
        LinkedList<int[]> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            int lead = i;
            int mask = setbit(0,i);
            
            q.add(new int[]{lead, mask});
            dist[mask][lead] = 0;
        }
        
        
        // Applying simulatneous BFS
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] path = q.remove();
                
                int lead = path[0];
                int mask = path[1];
                
                if(mask == row-1){   //all nodes visited
                    return dist[mask][lead];
                }
                
                // iterate over neighbours of lead
                if(hm.containsKey(lead)){
                    for(int child: hm.get(lead)){
                        int newlead = child;
                        int newmask = setbit(mask, newlead);
                        // avoid cycle: intelligent bfs : checking if this set is already visited 
                        // set : lead, mask(visited nodes)
                        if(dist[newmask][newlead]!=-1){
                            continue;
                        }

                        dist[newmask][newlead] = dist[mask][lead]+1;
                        q.add(new int[]{newlead, newmask});
                    }
                }
            }
        }
        return 1221; //magic - LOL
        
        
        
    }
    
    private int setbit(int mask, int i){
        return mask|(1<<i);
    }
    
    
}

// I like this approach the most

/**
The previous approach is comparatively slow but works because the bounds are small. The main problem is that we are working backwards and need a DFS starting from every node. The optimal path may end at node 0, but we still need to check all other nodes to make sure. As with any problem that asks us to find the shortest path, it may be more intuitive to approach this problem using BFS.

Because BFS guarantees the shortest path in an unweighted graph, as soon as we find an answer, we know it is the optimal one, unlike in the previous solution where we needed to explore all reachable states to make sure.

This approach is similar to the previous one in terms of logic. However, instead of using top-down dynamic programming in the form of DFS + memoization, we will perform BFS by implementing a queue. Instead of starting at endingMask, we will start at the base case masks - only having one bit set to 1, and then work our way towards endingMask.

Because we were working backwards in the previous approach, for all neighbors, we needed to check (neighbor, mask) and (neighbor, mask ^ (1 << node)). Now, since we're moving forwards, the state we should consider next from each (node, mask) is different. If we are at node A and move to node B, it doesn't matter if we go B -> A -> B or A -> B - in both cases, upon arriving at B, we want our mask to have the bit corresponding to node B set as 1. This is a nice improvement on the previous approach as for each neighbor, we only need to consider 1 possibility instead of 2. Since we always want the bit to be set to 1, we will use an OR operation with 1 << neighbor to make sure the bit is set to 1.

More formally, for any given state (node, mask), we can traverse to (neighbor, mask | (1 << neighbor)) for all neighbors in graph[node]. We will still need to use some space to ensure that we don't revisit states and create an infinite cycle, but this time we don't need to associate the states with any values, just a flag to indicate if it has been visited yet or not.

Algorithm

If graph only contains one node, then return 0 as we can start at node 0 and complete the problem without taking any steps.

Initialize some variables:

n, as the length of graph.
endingMask = (1 << n) - 1, a bitmask that represents all nodes being visited.
seen, a data structure that will be used to indicate if we have visited a state to prevent cycles.
queue, a data structure that implements an abstract queue used for our BFS.
steps, an integer that keeps track of which step we are on. Since BFS gaurantees a shortest path, as soon as we encounter endingMask, we can return steps.
Populate queue and seen with the base cases (starting at all nodes with the mask set to having only visited the given node). This is (i, 1 << i) for all i from 0 to n - 1.

Perform a BFS:

Initialize nextQueue, which will replace queue at the end of the current step.
Loop through the current queue. For each state (node, mask), loop through graph[node]. For each neighbor, declare a new state (neighbor, nextMask), where nextMask = mask | (1 << neighbor). If nextMask == endingMask, then that means taking one more step to the neighbor will complete visiting all nodes, so return 1 + steps. Otherwise, if this new state has not yet been visited, then add it nextQueue and seen.
After looping through the current queue, increment steps by 1 and replace queue with nextQueue.
The constraints state that the input graph is always connected, therefore there will always be an answer. The return statement in the BFS will always trigger, and we don't need to worry about other cases.
 */
class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) {
            return 0;
        }
        
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        boolean[][] seen = new boolean[n][endingMask];
        ArrayList<int[]> queue = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            queue.add(new int[] {i, 1 << i});
            seen[i][1 << i] = true;
        }
        
        int steps = 0;
        while (!queue.isEmpty()) {
            ArrayList<int[]> nextQueue = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                int[] currentPair = queue.get(i);
                int node = currentPair[0];
                int mask = currentPair[1];
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (nextMask == endingMask) {
                        return 1 + steps;
                    }
                    
                    if (!seen[neighbor][nextMask]) {
                        seen[neighbor][nextMask] = true;
                        nextQueue.add(new int[] {neighbor, nextMask});
                    }
                }
            }
            steps++;
            queue = nextQueue;
        }
        
        return -1;
    }
}