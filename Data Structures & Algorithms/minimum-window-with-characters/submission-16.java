class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] have = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int count = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            have[c]++;

            // We only increase count if this character
            // was actually needed.
            if (need[c] > 0 && have[c] <= need[c]) {
                count++;
            }

            // We have found a valid window
            while (count == t.length()) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                have[leftChar]--;

                // Removing this character makes the
                // window invalid
                if (need[leftChar] > 0 &&
                    have[leftChar] < need[leftChar]) {
                    count--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}