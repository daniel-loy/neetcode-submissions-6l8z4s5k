class MedianFinder {

    PriorityQueue<Integer> first;

    PriorityQueue<Integer> second;
    public MedianFinder() {
        first = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        second = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        first.offer(num);
        second.offer(first.poll());

        if(first.size()<second.size()){
            first.offer(second.poll());
        }

    }
    
    public double findMedian() {
        if(first.size() == second.size()){
            return ((double)first.peek()+second.peek())/2;
        }
        else{
            return first.peek();
        }
    }
}
