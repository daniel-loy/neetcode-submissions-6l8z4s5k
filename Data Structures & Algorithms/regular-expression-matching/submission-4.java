class Solution {
    /**
     * Solves the Regular Expression Matching problem using Dynamic Programming.
     * dp[i][j] is true if the first 'i' characters of 's' match the first 'j' characters of 'p'.
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] will be true if s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: An empty string matches an empty pattern.
        dp[0][0] = true;

        // Initialize the first row (dp[0][j]): 
        // Matching an empty string 's' with a non-empty pattern 'p'.
        // Only possible if the pattern is like "a*", "a*b*", etc.
        for (int j = 2; j <= n; j++) {
            // p.charAt(j-1) is the current character in pattern
            // If the current character is '*', it matches the zero-repetition case of the preceding element.
            if (p.charAt(j - 1) == '*') {
                // If the pattern up to j-2 (e.g., "a*") matched the empty string, 
                // then the pattern up to j ("a*") also matches the empty string.
                dp[0][j] = dp[0][j - 2]; 
            }
        }

        // Fill the rest of the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1); // Current char in s
                char pChar = p.charAt(j - 1); // Current char in p

                // Case 1: The characters match, or the pattern character is '.'
                if (pChar == sChar || pChar == '.') {
                    // If they match, the result depends on whether the preceding substrings matched.
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                
                // Case 2: The pattern character is '*'
                else if (pChar == '*') {
                    char prevPChar = p.charAt(j - 2); // The character immediately preceding '*'

                    // Option A: The '*' represents ZERO occurrences of the preceding element.
                    // (e.g., s="a", p="b*a". We ignore "b*" by looking at dp[i][j-2])
                    // We check if the pattern matches without the 'x*' term.
                    dp[i][j] = dp[i][j - 2]; 

                    // Option B: The '*' represents ONE or MORE occurrences.
                    // This is only possible if the preceding character (p[j-2]) matches the current s[i-1].
                    if (prevPChar == sChar || prevPChar == '.') {
                        // If it matches, we can transition from the previous state s[i-1] matching p[j].
                        // dp[i-1][j] means s[i-1] was consumed, and we look to see if the rest of 's' matched 'p' 
                        // (leaving the 'x*' term available for more matches).
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; 
                    }
                }
                // Case 3: Simple Mismatch (e.g., s="a", p="b")
                // If none of the above conditions met, dp[i][j] remains false (initialized default).
            }
        }

        return dp[m][n];
    }
}