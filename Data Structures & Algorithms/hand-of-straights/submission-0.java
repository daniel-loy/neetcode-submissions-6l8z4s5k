class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            int mapvalue = map.getOrDefault(hand[i],0);
            map.put(hand[i],mapvalue+1);
        }
        
        while(map.size()!=0){
            int firstkey = map.firstKey();
            for(int i=0;i<groupSize;i++){
                int nextnum = firstkey+i;
                if(!map.containsKey(nextnum)){
                    return false;
                }
                if(map.get(nextnum)==1){
                    map.remove(nextnum);
                }
                else{
                    map.put(nextnum,map.get(nextnum)-1);
                }
            }
        }
        return true;
        
    }
}
