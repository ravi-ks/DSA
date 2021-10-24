package MaxRootToLeafPathSum;

import java.util.Stack;

class Node{
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node() {
    }

}
public class MaxRootToLeafPathSum {
    public static void main(String args[]) {
        Node a = new Node(5);
        Node b = new Node(11);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(2);
        Node f = new Node(1);

        a.leftChild = b;
        a.rightChild = c;
        b.leftChild = d;
        b.rightChild = e;
        c.rightChild = f;


        MaxRootToLeafPathSum maxRootToLeafPathSum = new MaxRootToLeafPathSum();
        System.out.println(
                maxRootToLeafPathSum.findMaxRootToLeafPathSum(a)
                );
    }

    //wrong in following test case
    /*

    5
     \
      3
       \
        -1

     expected: 7
     answer we get: 8
     Because left child of 3 is null and hence returns 0; so max(0, -1) is 0
     SO the path it signifies is 5 -> 3, but 3 is not a leaf node!!!!

     Solution: Handle leaf nodes as a base case
     */
    int findMaxRootToLeafPathSum1(Node root){
        if(root == null) return Integer.MIN_VALUE;

        return root.value +
        Math.max(findMaxRootToLeafPathSum1(root.leftChild), findMaxRootToLeafPathSum1(root.rightChild));
    }

    int findMaxRootToLeafPathSum(Node root){
        if(root == null) return Integer.MIN_VALUE;

        //if node is leaf, return self's value
        if(root.leftChild == null && root.rightChild == null) return root.value;

        return root.value +
                Math.max(findMaxRootToLeafPathSum(root.leftChild), findMaxRootToLeafPathSum(root.rightChild));
    }

}
