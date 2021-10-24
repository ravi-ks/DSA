package shortestPath;

import java.util.*;

class Pair<T1, T2>{
    T1 node;
    T2 distance;

    public Pair(T1 node, T2 distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "shortestPath.Pair{" +
                "node=" + node +
                ", distance=" + distance +
                '}';
    }
}

public class ShortestPath {
    public static void main(String args[]) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('w', Arrays.asList('x', 'v'));
        graph.put('x', Arrays.asList('w', 'y'));
        graph.put('y', Arrays.asList('x', 'z'));
        graph.put('z', Arrays.asList('y', 'v'));
        graph.put('v', Arrays.asList('w', 'z'));

        ShortestPath shortestPath = new ShortestPath();
        Set<Character> visited = new HashSet<>();
        System.out.println(shortestPath.findShortestPath(graph, 'w', 'z', visited));
    }

    //bfs is better than dfs in finding the shortest path as it uniformly ripples its search space around the src
    private int findShortestPath(Map<Character, List<Character>> graph, char src, char dest, Set<Character> visited) {
        Queue<Pair<Character, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(src, 0));
        visited.add(src);
        //bfs traversal
        while (!queue.isEmpty()) {
            Pair<Character, Integer> pivot = queue.poll();

            if(pivot.node == dest) return pivot.distance; //dest found

            for (Character neighbours : graph.get(pivot.node)) {
                if(!visited.contains(neighbours)) {
                    queue.add(new Pair<>(neighbours, pivot.distance + 1));
                    visited.add(neighbours);
                }
            }
        }
        return -1; //control never gets here (hopefully)
    }
}
