package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class DFS {
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

        DFS dfs = new DFS();
        System.out.println(dfs.dfs(a));
    }

    //iterative
    /*
    void dfs(Node root){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node pivot = stack.pop();
            System.out.print(pivot.value + " ");

            if(pivot.rightChild != null) stack.push(pivot.rightChild);
            if(pivot.leftChild != null) stack.push(pivot.leftChild);
        }
    }
     */

    //recursive
    List<Character> dfs(Node root){
        List<Character> listToReturn = new ArrayList<>();
        if(root == null) return listToReturn;

        listToReturn.add(root.value);

        listToReturn.addAll(dfs(root.leftChild));
        listToReturn.addAll(dfs(root.rightChild));
        return  listToReturn;
    }
}
