class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket : tickets){
            PriorityQueue<String> queue = map.getOrDefault(ticket.get(0),new PriorityQueue<>((a,b)->a.compareTo(b)));
            queue.offer(ticket.get(1));
            map.put(ticket.get(0),queue);
       }
        LinkedList<String> list = new LinkedList<>();
        dfs("JFK",list,map);
        
        return list;
    }

    public void dfs(String currentNode,LinkedList<String> list,HashMap<String,PriorityQueue<String>> map){
        
        PriorityQueue<String> pri = map.get(currentNode);
        if(pri!=null && !pri.isEmpty()){
        while(!pri.isEmpty()){
            String poped = pri.poll();
            dfs(poped,list,map);
        }
        }
        list.addFirst(currentNode);
    }
}


