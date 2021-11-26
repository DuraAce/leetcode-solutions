class MedianFinder {
    
    PriorityQueue<Integer> before;
    PriorityQueue<Integer> after;    

    public MedianFinder() {
        this.before = new PriorityQueue<>(10, Collections.reverseOrder());
        this.after = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // queue is empty
        if (before.size() == 0) {
            before.offer(num);
            return;
        }            
        int maxInBefore = before.peek();
        if (num > maxInBefore) {
            after.offer(num);
        } else {
            before.offer(num);
        }
        balance();
    }
    
    public double findMedian() {
        if ((before.size() + after.size()) % 2 == 1)
            return (double) before.peek();
        else 
            return (double) (before.peek() + after.peek()) / 2;
    }
    
    void balance() {
        //before.size() = after.size() + 1
        if (before.size() > after.size() + 1) {
            while (before.size() > after.size() + 1) {
                int tmp = before.poll();
                after.offer(tmp);
            }
            return;
        }
        if (after.size() > before.size()) {
            while (after.size() > before.size()) {
                int tmp = after.poll();
                before.offer(tmp);
            }
            return;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
