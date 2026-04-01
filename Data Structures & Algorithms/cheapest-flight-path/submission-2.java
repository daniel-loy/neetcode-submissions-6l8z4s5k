class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            HashMap<Integer,List<Pair<Integer,Integer>>> map = new HashMap<>();
            int path=-1;
            for(int[] arr : flights){
                map.computeIfAbsent(arr[0],j -> new ArrayList<>()).add(new Pair<>(arr[1],arr[2]));
                
            }
            PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a,b)->a.get(1)-b.get(1));
            queue.offer(Arrays.asList(src,0,0));
            while(!queue.isEmpty()){

                List<Integer> list = queue.poll();
                 if(list.get(0)==dst){
                    path=list.get(1);
                    break;
                }
                if(list.get(2)>k){
                    continue;
                }

                if (map.containsKey(list.get(0))) {
                for(Pair<Integer,Integer> pr : map.get(list.get(0))){
                    queue.offer(Arrays.asList(pr.getKey(),pr.getValue()+list.get(1),list.get(2)+1));
                }
                }
            }
            return path;
    }
}
