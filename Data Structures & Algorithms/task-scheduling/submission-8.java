class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }
        PriorityQueue<Integer> pri = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        HashMap<Character,Integer> map = new HashMap<>();

        for(Character c : tasks){
            int num = map.getOrDefault(c,0);
            map.put(c,num+1);
        }

        for(int num : map.values()){
            pri.add(num);
        }
        int first = pri.peek();
        int total = (pri.peek()-1)*n;
        int result = pri.poll()+total;
        while(!pri.isEmpty()){
            if(total <= 0){
                result = result+pri.peek();
            }
            else if(pri.peek()==first){
                result++;
                total = total-first+1;
            }
            else if(pri.peek()>total){
                result = result+(pri.peek()-total);
                total = 0;
            }
            else{
                total = total - pri.peek();
            }
            pri.poll();
            
        }

        return result;
    }

}
