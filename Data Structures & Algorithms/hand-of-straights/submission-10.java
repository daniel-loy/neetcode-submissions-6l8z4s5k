class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : hand){
            int value = map.getOrDefault(num,0);
            map.put(num,value+1);
        }

        for(int i=0;i<hand.length;i++){
            int groupno = map.get(hand[i]);
            if(groupno==0){
                continue;
            }
            
            for(int j=0;j<groupSize;j++){
                int currenthand = hand[i]+j;

                if(map.containsKey(currenthand) && map.get(currenthand)>=groupno){
                    map.put(currenthand,map.get(currenthand)-groupno);
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }
}
