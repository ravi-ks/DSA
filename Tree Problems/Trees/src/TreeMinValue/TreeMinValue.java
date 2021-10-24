package TreeMinValue;


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
public class TreeMinValue {
    public static void main(String args[]) {
        Node a = new Node(3);
        Node b = new Node(11);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(15);
        Node f = new Node(12);

        a.leftChild = b;
        a.rightChild = c;
        b.leftChild = d;
        b.rightChild = e;
        c.rightChild = f;

        TreeMinValue treeMinValue = new TreeMinValue();
        System.out.println(treeMinValue.findMinValue(a));
    }

    int findMinValue(Node root){
        if(root == null) return Integer.MAX_VALUE;
        return
                Math.min(root.value, Math.min(findMinValue(root.leftChild), findMinValue(root.rightChild)));
    }
}
