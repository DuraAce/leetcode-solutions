class Node {
    
    public int key;
    public int val;
    public Node prev;
    public Node next;
    
    public Node (int key, int val) {
        this.key = key;
        this.val = val;
    }
}


class DLinkedList {
    
    public Node head;
    public Node tail;
    
    public DLinkedList () {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void addNode(Node curr) {
        Node fistNode = head.next;
        head.next = curr;
        fistNode.prev = curr;
        curr.prev = head;
        curr.next = fistNode;        
    }
    
    public void moveNode(Node curr) {
        if (curr == head.next) {
            return;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        addNode(curr);
    }
    
    public int evict() {
        if (tail.prev == head) {
            return -1;
        }
        Node lastNode = tail.prev;
        tail.prev = lastNode.prev;
        lastNode.prev.next = tail;
        return lastNode.key;
    }
    
    public void printList() {
        Node curr = head.next;
        while (curr != tail) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("tail\n");
    }
}

class LRUCache {
    
    public DLinkedList ll;
    public HashMap<Integer, Node> map;
    public int capacity;

    public LRUCache(int capacity) {
        this.ll = new DLinkedList();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node currNode = map.get(key);
        ll.moveNode(currNode);
        //ll.printList();
        return currNode.val;
    }
    
    public void put(int key, int value) {
        // key exist
        if (map.containsKey(key)) {
            Node currNode = map.get(key);
            currNode.val = value;
            ll.moveNode(currNode);
            return;
        } 
        
        // new key
        if (map.size() >= capacity) {
            int keyToDelete = ll.evict();
            //System.out.println(keyToDelete);
            map.remove(keyToDelete);
        }        
        Node currNode = new Node(key, value);
        map.put(key, currNode);
        ll.addNode(currNode);       
        //ll.printList();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
