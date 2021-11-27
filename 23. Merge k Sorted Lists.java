/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) 
            return null;
        ListNode[] curr = lists.clone();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        ListNode dummy =  initHeap(curr, heap);
        runHeap(curr, heap, dummy);
        return dummy.next;
    }
    
    public ListNode initHeap(ListNode[] curr, PriorityQueue<Integer> heap) {
        int min = Integer.MAX_VALUE;
        ListNode dummy = new ListNode(-1);
        for (ListNode c : curr) {
            if (c != null) {
                heap.offer(c.val);
                if (c.val <= min) {
                    min = c.val;
                    dummy.next =  c;
                }
            }
        }
        return dummy;
    }   
    
    public void runHeap(ListNode[] curr, PriorityQueue<Integer> heap, ListNode index) {
        while (!heap.isEmpty()) {
            int heapTop = heap.peek();
            for (int i = 0; i < curr.length; i++) {
                if (curr[i] != null) {
                    if (curr[i].val == heapTop) {
                        index.next = curr[i];
                        index = curr[i];
                        heap.poll();
                        curr[i] = curr[i].next;
                        if (curr[i] != null)
                            heap.offer(curr[i].val);
                        break;
                    }
                }
            }
        }
    }    
    
}
