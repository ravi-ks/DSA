package countConnectedComponents;

import java.util.*;

public class CountComponents {
    public static void main(String args[]) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(3, Arrays.asList());
        graph.put(4, Arrays.asList(6));
        graph.put(6, Arrays.asList(4,5,7,8));
        graph.put(8, Arrays.asList(6));
        graph.put(7, Arrays.asList(6));
        graph.put(5, Arrays.asList(6));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(1));


        CountComponents countComponents = new CountComponents();
        System.out.println(countComponents.countComponents(graph));
    }

    int countComponents(Map<Integer, List<Integer>> graph){
        Set<Integer> visited = new HashSet<>();
        int componentsCount = 0;
        int maxComponentSIze = 0;
        for(Integer node: graph.keySet()){
           if(explore(graph, node, visited)) {
               componentsCount++;
           }
        }
        return componentsCount;
    }

    //do dfs
    boolean explore(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visited){
        if(visited.contains(node)) return false; //if loop found or node already visited

        visited.add(node);
        for(Integer neighboursOfNode: graph.get(node)){
            explore(graph, neighboursOfNode, visited);
        }
        return true;
    }
}
