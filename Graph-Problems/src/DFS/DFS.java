package DFS;

import java.util.*;

//DFS.DFS - stack
public class DFS {
    Map<Character, List<Character>> graph = new HashMap<>();
    public static void main(String args[]){
        DFS dfs = new DFS();

        //init graph aka adjacency matrix
        dfs.graph.put('a', Arrays.asList('b', 'c'));
        dfs.graph.put('b', Arrays.asList('d'));
        dfs.graph.put('c', Arrays.asList('e'));
        dfs.graph.put('d', Arrays.asList('f'));
        dfs.graph.put('e', new ArrayList<>());
        dfs.graph.put('f', new ArrayList<>());

        dfs.dfSearchIter(dfs.graph, 'a');
        System.out.println();
        dfs.dfSearchRecursive(dfs.graph, 'a');

    }

    void dfSearchIter(Map<Character, List<Character>> graph, char sourceNode){
        Stack<Character> stack = new Stack<>();
        stack.push(sourceNode); //init stack

        while(!stack.isEmpty()){
            char pivot = stack.pop();
            System.out.print(pivot + " ");
            for(Character neighboursOfPivot: graph.get(pivot))
                stack.push(neighboursOfPivot);
        }
    }

    void dfSearchRecursive(Map<Character, List<Character>> graph, char sourceNode){
        System.out.print(sourceNode + " ");
        for(Character neighboursOfPivot: graph.get(sourceNode)){
            dfSearchRecursive(graph, neighboursOfPivot);
        }
    }
}

