import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *A linked list is given such that each node contains an additional random pointer which could
 * point to any node in the list or null.
 *
 * Return a deep copy of the list.

 *O(n) time complexity
 *
 * The problem's statement is that there is a linked list that looks like a simple linked list,
 * except that each node has second piece of information that references a random node somewhere
 * in the list. The random one could already exist, in which case, fine, you can just point to it.
 * Or it might not exist yet, which makes it difficult to refer to. You want to be able to refer
 * to a node as soon as you see it. If you only use the next pointers, the random pointer wouldn't
 * refer to a real node, which would lead to errors. You're saying something exists and it doesn't.
 *
 * --------------------
 * <deep copy vs shallow copy>
 * Shallow copies duplicate as little as possible. A shallow copy of a collection is a copy of the collection
 * structure, not the elements. With a shallow copy, two collections now share the individual elements.
 *
 * Deep copies duplicate everything. A deep copy of a collection is two collections with all of the elements
 * in the original collection duplicated.
 *
 */
public class Solution138 {
    // Definition for a Node.
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int _val) {
            val = _val;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<Node, Node>();

        // loop 1. copy all the nodes
        Node node = head;
        //iterate the original linkedList
        while (node != null) {
            map.put(node, new Node(node.val)); //key is the node, and deep copy a node into the hashMap
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        //iterate the original linkedList again
        while (node != null) {
            map.get(node).next = map.get(node.next); //connect the nodes in HashMap
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
    public static void main(String[]args){
        Solution138 ns =new Solution138();
        Node head = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        head.next = node2;
        head.random = node3;
        node2.next = node3;
        node2.random = node2;
        node3. next = null;
        node3.random = head;
        System.out.println(ns.copyRandomList(head).val);
    }
}
