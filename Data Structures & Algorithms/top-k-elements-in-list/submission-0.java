class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
                map.put(num,map.getOrDefault(num,0)+1);
        }
    
        PriorityQueue<Integer> pr = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));

        int[] arr = new int[k];
        for(int num : map.keySet()){
            pr.add(num);
            if(pr.size()>k){
                pr.poll();
            }
        }

        for(int i=0;i<k;i++){
            arr[i]=pr.poll();
        }
        return arr;  
    }
}
