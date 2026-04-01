class MedianFinder {
    PriorityQueue<Integer> firstqueue;
    PriorityQueue<Integer> secondqueue;
    public MedianFinder() {
        firstqueue = new PriorityQueue<>((a,b)->b-a);
	secondqueue = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        firstqueue.add(num);
	secondqueue.add(firstqueue.poll());
	if(secondqueue.size() > firstqueue.size()){
		firstqueue.add(secondqueue.poll());
	}
    }
    
    public double findMedian() {
        if(firstqueue.size() == secondqueue.size()){
		return ((double)firstqueue.peek()+secondqueue.peek())/2;
	}
	else{
		return firstqueue.peek();
	}
    }
}
