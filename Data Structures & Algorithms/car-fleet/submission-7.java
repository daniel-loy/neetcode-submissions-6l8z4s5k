class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Float> stk = new Stack<Float>();
        int count = 0;
        Integer[] newpos = new Integer[position.length];
        for(int i=0;i<position.length;i++){
            newpos[i] = i;
        }
        Arrays.sort(newpos,(a,b)->position[a]-position[b]);
        for(int i=position.length-1;i>=0;i--){
            float time = (float)(target-position[newpos[i]])/speed[newpos[i]];
            if(!stk.isEmpty() && stk.peek()<time){
                while(!stk.isEmpty()){
                    stk.pop();
                }
                stk.push(time);
                count++;
            }
            if(stk.isEmpty()){
                stk.push(time);
            }

        }
        if(!stk.isEmpty()){
            return count+1;
        }
        else{
            return count;
        }
    }
}
