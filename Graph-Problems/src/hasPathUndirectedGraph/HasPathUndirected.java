package hasPathUndirectedGraph;


import java.util.*;

class Pair{
    Character node1;
    Character node2;

    public Pair(Character node1, Character node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}

//cyclic graph handled!
public class HasPathUndirected {
    public static void main(String args[]) {
        List<Pair> undirectedGraph = new ArrayList<>();

        HasPathUndirected hasPathUndirected = new HasPathUndirected();

        undirectedGraph.add(new Pair('i', 'j'));
        undirectedGraph.add(new Pair('k', 'i'));
        undirectedGraph.add(new Pair('m', 'k'));
        undirectedGraph.add(new Pair('k', 'l'));
        undirectedGraph.add(new Pair('o', 'n'));

        Map<Character, List<Character>> directedGraph = new HashMap<>();
        directedGraph = hasPathUndirected.getDirectedGraph(undirectedGraph);

        System.out.println(hasPathUndirected.hasPath(directedGraph, 'o', 'j', new HashSet<Character>()));
    }

    boolean hasPath(Map<Character, List<Character>> graph, char src, char dest, Set<Character> visited){
        if(src == dest) return true;
        if(visited.contains(src)) return false; //loop found

        visited.add(src);

        for(char neighbour: graph.get(src)){
            if(hasPath(graph, neighbour, dest, visited)) return true;
        }
        return false;
    }

    Map<Character, List<Character>> getDirectedGraph(List<Pair> undirectedGraph){
        Map<Character, List<Character>> graphToReturn = new HashMap<>();

        for(Pair nodes: undirectedGraph){
            if(!graphToReturn.containsKey(nodes.node1))
                graphToReturn.put(nodes.node1, new ArrayList<>());
            if(!graphToReturn.containsKey(nodes.node2))
                graphToReturn.put(nodes.node2, new ArrayList<>());

            graphToReturn.get(nodes.node1).add(nodes.node2);
            graphToReturn.get(nodes.node2).add(nodes.node1);
        }

    return graphToReturn;
    }
}
