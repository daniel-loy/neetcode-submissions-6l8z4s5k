class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {

            int groupno = map.get(num);

            if (groupno == 0) continue;

            for (int j = 0; j < groupSize; j++) {

                int curr = num + j;

                if (map.getOrDefault(curr, 0) < groupno) {
                    return false;
                }

                map.put(curr, map.get(curr) - groupno);
            }
        }

        return true;
    }
}