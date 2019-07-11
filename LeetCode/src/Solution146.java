import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2  capacity );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * -------------------------
 * Least recently used (LRU)
 * Discards the least recently used items first. This algorithm requires keeping track of what was used when, which is
 * expensive if one wants to make sure the algorithm always discards the least recently used item.
 */
public class Solution146 {
    /**
     * The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list.
     * One interesting property about double linked list is that the node can remove itself without other reference.
     * In addition, it takes constant time to add and remove nodes from the head or tail.
     *
     * Nodes in a doubly-linked LL can be removed with only references to themselves.
     * In a singly-linked LL, you would also need a reference to the node before the one you wanted to remove.
     *
     * Therefore, if you were using a singly-linked LL, you wouldn't be able to remove nodes you retrieved from the
     * Hashtable in O(1) time, because you don't have a reference to the one before it.
     *
     * By using a doubly-linked LL, you can retrieve nodes from the Hashtable in O(1), and then remove the node itself
     * from the LL in O(1), giving the entire operation O(1) running time.
     *
     * remove the head and append new node after the tail
     */
    public class LRUCache {
        private Map<Integer, DLinkNode> cache;
        DLinkNode tail = null;
        DLinkNode head = null;
        int capacity;

        public LRUCache(int capacity) {
            cache = new HashMap<Integer, DLinkNode>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                DLinkNode target = cache.get(key);
                int value = target.value;
                target.update();
                return value;
            } else return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                DLinkNode target = cache.get(key);
                target.value = value;
                target.update();
            } else {
                if (capacity == 0) return;
                if (cache.size() == capacity) {
                    cache.remove(head.key);
                    head.removeFromHead();
                }
                DLinkNode newNode = new DLinkNode(key, value);
                newNode.append();
                cache.put(key, newNode);
            }
        }

        class DLinkNode {
            int key;
            int value;
            DLinkNode left = null;
            DLinkNode right = null;
            public DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
            // remove head from list and update head reference.
            private void removeFromHead() {
                // if 'this' is the only node, set both head and tail to null.
                if (tail == this) {
                    head = null;
                    tail = null;
                } else {
                    head = this.right;
                    head.left = null;
                }
            }
            private void update() {
                // no need to update if accessing the most recently used value.
                if (tail == this) return;
                else {
                    // remove from current position and update nodes (if any) on both sides.
                    if (this != head) {
                        this.left.right = this.right;
                    } else {
                        head = this.right;
                    }
                    this.right.left = this.left;
                    // append to tail.
                    this.append();
                }
            }
            private void append() {
                // inserting the first node.
                if (tail == null) {
                    head = this;
                    tail = this;
                    // append as tail and update tail reference.
                } else {
                    this.right = null;
                    this.left = tail;
                    tail.right =this;
                    tail = this;
                }
            }
        }
    }

}
