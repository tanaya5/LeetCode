// recursion dynamic programming
class Solution {
    public int numDecodings(String s) {
        return helper(s,s.length());
    }
    
    public int helper(String s, int k)
    {
        if(k == 0)
            return 1;
        if(s.charAt(s.length() - k ) == '0')
            return 0;
        int result = 0;
        result = helper(s , k-1);
        if(k >=2 && Integer.parseInt(s.substring(s.length() - k , s.length() - k+2)) <= 26)
            result += helper(s, k-2);
        
        return result;
    }
    
    
}
/* approach from leetcode
class Solution {
    // one dimensional array: 
    // dp[i]: from i to the end number of ways to decode
    // n is the length of innput string
    // dp[n] = 1;
    // dp[n-1] = 0 if s.charAt(n-1) == 0;
    // dp[n-1] = 1 if s.charAt(n-1) != 0;
    // dp[i] = 0, if s.charAt(i) == '0';
    // dp[i] = dp[i+1] + dp[i+2], if Integer.parseInt(s.substring(i, i+2)) <= 26
    // dp[i] = dp[i+1], other cases;    
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int r1 = 1, r2 = 1;

        for (int i = 1; i < s.length(); i++) {
            // zero voids ways of the last because zero cannot be used separately
            if (s.charAt(i) == '0') {
                r1 = 0;
            }

            // possible two-digit letter, so new r1 is sum of both while new r2 is the old r1
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
                r1 = r2 + r1;
                r2 = r1 - r2;
            }

            // one-digit letter, no new way added
            else {
                r2 = r1;
            }
        }

        return r1;
    }
}
*/
