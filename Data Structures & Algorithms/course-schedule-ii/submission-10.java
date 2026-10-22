class Solution {
    int[] status;
    HashMap<Integer,List<Integer>> map ;
    int[] result;
    int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        index = 0;
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> list = map.getOrDefault(prerequisites[i][0],new ArrayList<>());
            list.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],list);
        }

        status = new int[numCourses];

        result =  new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(status[i]==0){
                if(getOrder(i)){
                    return new int[0];
                }
            }
        }
        return result;
    }

    public boolean getOrder(int i){
        if(status[i]==1){
            return true;
        }

        if(status[i]==2){
            return false;
        }

        status[i] = 1;

        if(map.containsKey(i)){
            for(int num : map.get(i)){
                 if(getOrder(num)){
                    return true;
                 }
            }
        }
        status[i] = 2;

        result[index] = i;

        index++;

        return false;
    }

}
