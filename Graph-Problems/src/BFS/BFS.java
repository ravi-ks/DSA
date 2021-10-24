package BFS;

import java.util.*;
//BFS - Queue
public class BFS {
    Map<Character, List<Character>> graph = new HashMap<>();

    public static void main(String args[]) {
        BFS bfs = new BFS();

        //init graph aka adjacency matrix
        bfs.graph.put('a', Arrays.asList('b'));
        bfs.graph.put('b', Arrays.asList());
        bfs.graph.put('c', Arrays.asList('a', 'd'));
        //bfs.graph.put('c', Arrays.asList('d'));
        bfs.graph.put('d', new ArrayList<>());

        bfs.bfSearchIter(bfs.graph, 'c');
    }

    void bfSearchIter(Map<Character, List<Character>> graph, char sourceNode) {
        Queue<Character> queue = new LinkedList<>();
        queue.add(sourceNode); //init queue

        while (!queue.isEmpty()) {
            char pivot = queue.poll();
            System.out.print(pivot + " ");
            for (Character neighboursOfPivot : graph.get(pivot))
                queue.add(neighboursOfPivot);
        }
    }
}
