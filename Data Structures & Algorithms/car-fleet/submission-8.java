class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Float> stk = new Stack<Float>();
        int count = 0;
        Integer[] newpos = new Integer[n];
        for(int i=0;i<n;i++){
            newpos[i] = i;
        }
        Arrays.sort(newpos,(a,b)->position[a]-position[b]);

        float time = (float)(target-position[newpos[n-1]])/speed[newpos[n-1]];
        float current = time;
        System.out.println(time);
        for(int i=position.length-2;i>=0;i--){
            time = (float)(target-position[newpos[i]])/speed[newpos[i]];
            System.out.println(time);
            if(time>current){
                current = time;
                count++;
            }
        }
        return count+1;
    }
}
