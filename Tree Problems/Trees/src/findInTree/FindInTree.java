package findInTree;

import BFS.BFS;

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

public class FindInTree {
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

        FindInTree findInTree = new FindInTree();
        System.out.println(findInTree.findInTree(a, 'p'));
    }

    //dfs traverse and find item
    boolean findInTree(Node root, char itemToFind){
        //base case first! - if empty tree, return null
        if(root == null) return false;
        if(root.value == itemToFind) return true;

        boolean foundInLeftTree = findInTree(root.leftChild, itemToFind);
        boolean foundInRightTree = findInTree(root.rightChild, itemToFind);

        return foundInLeftTree || foundInRightTree;
    }

}
