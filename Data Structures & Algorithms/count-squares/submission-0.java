class CountSquares {
    HashMap<Integer,HashMap<Integer,Integer>> map;
    public CountSquares() {
    map = new HashMap<>();
    }
    
    public void add(int[] point) {
        map.putIfAbsent(point[0],new HashMap<>());
        map.get(point[0]).put(point[1],map.get(point[0]).getOrDefault(point[1],0)+1);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int totalsquare = 0;
        if(!map.containsKey(x1)){
            return 0;
        }
        for(Map.Entry<Integer,Integer> list : map.get(x1).entrySet()){
            int y2 = list.getKey();
            int ycount = list.getValue();

            if(y1==y2){
                continue;
            }

            int length = Math.abs(y1-y2);

            totalsquare+=calculatesquare(y1,y2,x1+length,ycount);
            totalsquare+=calculatesquare(y1,y2,x1-length,ycount);

        }

        return totalsquare;

    }

    public int calculatesquare(int y1,int y2,int x3,int ycount){
        if(map.containsKey(x3)){
             return map.get(x3).getOrDefault(y1,0)*map.get(x3).getOrDefault(y2,0)*ycount;
        }
        return 0;
    }
}

