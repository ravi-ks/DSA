package minIsland;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Pair<T1, T2>{
    T1 row;
    T2 col;

    public Pair(T1 row, T2 col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(row, pair.row) && Objects.equals(col, pair.col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

public class MinIsland {
    public static void main(String args[]) {
        MinIsland minIsland = new MinIsland();
        int[][] islandGrid = {
                {0, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
        };

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        int minIslandSize = Integer.MAX_VALUE;
        for(int i = 0; i < islandGrid.length; i++){
            for(int j = 0; j <  islandGrid[0].length; j++){
                int islandSizeReturned = minIsland.minIsland(islandGrid, i, j, visited);
                if(islandSizeReturned > 0) {
                    //System.out.println("visited: " + visited);
                    if(minIslandSize > islandSizeReturned)
                        minIslandSize = islandSizeReturned;
                }
            }
        }
        System.out.println(minIslandSize);

    }

    //basically traverses through an unvisited component in dfs fashion and returns true if successful
    int minIsland(int[][] islandGrid, int row, int col, Set<Pair<Integer, Integer>> visited){
        //return 0 for outOfBounds
        if(row < 0 || row >= islandGrid.length) return 0;
        if(col < 0 || col >= islandGrid[0].length) return 0;

        if(islandGrid[row][col] == 0) return 0; //if water and not land return 0

        //if loop exists, return 0
        if(visited.contains(new Pair<>(row, col))) return 0;
        //if returned false, anything below wouldn't happen

        visited.add(new Pair<>(row, col));

        int countOfNodes = 1;

        countOfNodes += minIsland(islandGrid, row - 1, col, visited); //up
        countOfNodes += minIsland(islandGrid, row, col - 1, visited); //left
        countOfNodes += minIsland(islandGrid, row , col + 1, visited); //right
        countOfNodes += minIsland(islandGrid, row + 1, col, visited); //down

        return countOfNodes;
    }
}
