package BFS;

import DFS.DFS;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    char value;
    Node leftChild;
    Node rightChild;

    public Node(char value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node() {
    }

}

public class BFS {
    public static void main(String args[]){
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        a.leftChild = b;
        a.rightChild = c;
        b.leftChild = d;
        b.rightChild = e;
        c.rightChild = f;

        BFS bfs = new BFS();
        bfs.bfs(a);
    }

    void bfs(Node root){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node pivot = queue.poll();
            System.out.print(pivot.value + " ");

            if(pivot.leftChild != null) queue.add(pivot.leftChild);
            if(pivot.rightChild != null) queue.add(pivot.rightChild);
        }
    }

}
