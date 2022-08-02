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

