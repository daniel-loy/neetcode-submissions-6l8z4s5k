class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> hash = new HashMap<>();
        for(int i=0;i<tickets.size();i++){
                PriorityQueue<String> ticketslist = hash.getOrDefault(tickets.get(i).get(0),new PriorityQueue<>());
                ticketslist.add(tickets.get(i).get(1));
                hash.put(tickets.get(i).get(0),ticketslist);
        }

        List<String> list = new ArrayList<>();

        dfs(list,hash,"JFK");
        Collections.reverse(list);
        return list;

        }

        public void dfs(List<String> list,HashMap<String,PriorityQueue<String>> hash,String str){
                PriorityQueue<String> pq = hash.get(str);
                
                if(pq == null || pq.isEmpty()){
                        list.add(str);
                        return;  
                }
                while(pq != null && !pq.isEmpty()){
                dfs(list,hash,pq.poll());
                }

                list.add(str);
        }
}
