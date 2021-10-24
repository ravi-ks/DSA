package hasPath;

import java.util.*;

//see if a path exists in an acyclic graph
public class HasPath {
    Map<Character, List<Character>> graph = new HashMap<>();

    public static void main(String args[]){
        HasPath hasPath = new HasPath();

        hasPath.graph.put('f', Arrays.asList('g', 'i'));
        hasPath.graph.put('g', Arrays.asList('h'));
        hasPath.graph.put('h', Arrays.asList());
        hasPath.graph.put('i', Arrays.asList('g', 'k'));
        hasPath.graph.put('j', Arrays.asList('i'));
        hasPath.graph.put('k', new ArrayList<>());

        System.out.println(hasPath.hasPath(hasPath.graph, 'f', 'k'));
    }

    //hasPath using DFS
    /*
    boolean hasPath(Map<Character, List<Character>> graph, char src, char dest){
        if(src == dest) return true;

        for(char neighbour: graph.get(src)){
            if(hasPath(graph, neighbour, dest)) return true;
        }
        return false;
    }
    */


    //hasPath using BFS
    boolean hasPath(Map<Character, List<Character>> graph, char src, char dest){
        Queue<Character> queue = new LinkedList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            Character pivot = queue.poll();

            if(pivot == dest) return true;

            for(char neighbour: graph.get(pivot)){
                queue.add(neighbour);
            }
        }
        return false;
    }
}
