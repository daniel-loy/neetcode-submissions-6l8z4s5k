class Solution {
        List<String> result = new ArrayList<>();
        
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> map = new HashMap<>();

        for(List<String> str : tickets){
                if(!map.containsKey(str.get(0))){
                map.put(str.get(0), new PriorityQueue<>((a, b) -> a.compareTo(b)));   
                }             
                
                PriorityQueue pri = map.get(str.get(0));
                pri.add(str.get(1));
            }
                dfs("JFK",map);
                return result;
    }
        public void dfs(String dest,HashMap<String,PriorityQueue<String>> map){
                        while(map.get(dest)!=null && !map.get(dest).isEmpty()){
                           String str = map.get(dest).poll();
                           dfs(str,map);
                        }

                                result.addFirst(dest);

        }
}



