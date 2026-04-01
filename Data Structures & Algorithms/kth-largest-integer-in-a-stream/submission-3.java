class KthLargest {
    PriorityQueue<Integer> pri;
    int size = 0;
    public KthLargest(int k, int[] nums) {
        pri = new PriorityQueue<Integer>();
        size = k;
        for(int val : nums){
            if(pri.size() == size){
                if( val>=pri.peek()){
                    pri.poll();
                    pri.add(val);  
                }
            }
            else{
            pri.add(val);    
            }
        }
    }
    
    public int add(int val) {
        System.out.println(pri.size() + " "+size);
            if(pri.size() == size){
                if( val>=pri.peek()){
                    pri.poll();
                    pri.add(val);  
                }
            }
            else{
            pri.add(val);    
            }
            return pri.peek();
            }
}
