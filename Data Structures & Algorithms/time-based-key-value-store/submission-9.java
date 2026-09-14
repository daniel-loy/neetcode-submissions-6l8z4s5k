class TimeMap {
        HashMap<String,ArrayList<Point>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            ArrayList<Point> arr = map.get(key);
            arr.add(new Point(timestamp,value));
        }
        else{
            ArrayList<Point> arr = new ArrayList<>();
            arr.add(new Point(timestamp,value));
            map.put(key,arr);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        ArrayList<Point> arr = map.get(key);

        if(arr.size()==0){
            return "";
        }
        Collections.sort(arr,(a,b)->Integer.compare(a.timestamp,b.timestamp));
        int left = 0;
        int right = arr.size()-1;
        int mid = 0;
        String result = "";
        while(left<=right){
            mid = left+(right-left)/2;
            if(arr.get(mid).timestamp == timestamp){
                return arr.get(mid).value;
            }

            if(arr.get(mid).timestamp < timestamp){
                            result = arr.get(mid).value;

                left=mid+1;
            }
            else{
                right = mid-1;
            }
        }
        
        return result;
    }

    class Point{
        int timestamp;
        String value;

        Point(int timestamp,String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
