package TreeSum;

import findInTree.FindInTree;


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

public class TreeSum {
    public static void main(String args[]){
        Node a = new Node(3);
        Node b = new Node(11);
        Node c = new Node(4);
        Node d = new Node(4);
        Node e = new Node(2);
        Node f = new Node(1);

        a.leftChild = b;
        a.rightChild = c;
        b.leftChild = d;
        b.rightChild = e;
        c.rightChild = f;

        TreeSum treeSum = new TreeSum();
        System.out.println(treeSum.treeSum(a));
    }

    //dfs traverse and find sum
    int treeSum(Node root){
      if(root == null) return 0;

      int sumToReturn = root.value;

      sumToReturn += treeSum(root.leftChild);
      sumToReturn += treeSum(root.rightChild);

      return sumToReturn;
    }
}
