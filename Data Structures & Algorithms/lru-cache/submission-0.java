class LRUCache {

    class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    HashMap<Integer, Node> mp;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Remove node from current position
    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node just before tail (MRU position)
    void insert(Node node) {
        Node last = tail.prev;

        last.next = node;
        node.prev = last;

        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }

        Node node = mp.get(key);

        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            remove(node);
            node.val = value;
            insert(node);
        } 
        else {
            if (mp.size() == capacity) {
                Node lru = head.next;
                remove(lru);
                mp.remove(lru.key);
            }

            Node node = new Node(key, value);
            mp.put(key, node);
            insert(node);
        }
    }
}