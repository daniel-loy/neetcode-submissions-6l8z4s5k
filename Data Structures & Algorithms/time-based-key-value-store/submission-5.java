
class TimeMap {
    // Custom class to store the pair
    class Data {
        String value;
        int timestamp;
        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Data> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List<Data> list, int timestamp) {
        int left = 0;
        int right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                // This is a potential candidate, look for a "more recent" one
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                // Too far in the future, look earlier
                right = mid - 1;
            }
        }
        return res;
    }
}