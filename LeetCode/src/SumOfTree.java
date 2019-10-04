public class SumOfTree {
    static class Node{
        int key;
        Node left, right;
    }

    public Node newNode (int key){
        Node node = new Node();
        node.key = key;
        node.left = node.right = null;
        return (node);
    }

    public static int addBT(Node root){
        if(root == null) return 0;
        return (root.key + addBT(root.left) + addBT(root.right));
    }
    public static void main(String args[]){
        SumOfTree ns = new SumOfTree();
        Node root = ns.newNode(1);
        root.left = ns.newNode(2);
        root.right = ns.newNode(3);
        root.left.left = ns.newNode(4);
        root.left.right = ns.newNode(5);
        root.right.left = ns.newNode(6);
        root.right.right = ns.newNode(7);
        root.right.left.right = ns.newNode(8);

        int sum = addBT(root);
        System.out.println("Sum of all the elements is: " + sum);
    }

}
