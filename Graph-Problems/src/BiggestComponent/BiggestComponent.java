package BiggestComponent;

import java.util.*;

public class BiggestComponent {
    public static void main(String args[]) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(3, Arrays.asList());
        graph.put(4, Arrays.asList(6));
        graph.put(6, Arrays.asList(4, 5, 7, 8));
        graph.put(8, Arrays.asList(6));
        graph.put(7, Arrays.asList(6));
        graph.put(5, Arrays.asList(6));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(1));

        BiggestComponent biggestComponent = new BiggestComponent();
        System.out.println(biggestComponent.biggestComponent(graph));

    }

    int biggestComponent(Map<Integer, List<Integer>> graph){
        Set<Integer> visited = new HashSet<>();
        int maxComponentSize = 0;
        for(Integer node: graph.keySet()){
            int returnedComponentSize = explore(graph, node, visited);
            if(returnedComponentSize > maxComponentSize) {
                maxComponentSize = returnedComponentSize;
            }
        }
        return maxComponentSize;
    }

    //does dfs and concurrently counts no of nodes in an unexplored component
    int explore(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited){
        if(visited.contains(node)) return 0; //if loop found, don't count it again

        visited.add(node);
        int count = 1;

        for(Integer neighbours: graph.get(node)){
            count += explore(graph, neighbours, visited);
        }

        return count;
    }
}
