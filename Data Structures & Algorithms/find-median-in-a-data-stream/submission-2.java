class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    public MedianFinder() {
        low = new PriorityQueue<>();
        high = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {

    high.offer(num);
    
    low.offer(high.poll());
    
    if (low.size() > high.size()) {
        high.offer(low.poll());
    }
    }
    
    public double findMedian() {
        if(low.size() == high.size()){
            return (double)(low.peek()+high.peek())/2;
        }
        else{
            return high.peek();
        }
    }
}
