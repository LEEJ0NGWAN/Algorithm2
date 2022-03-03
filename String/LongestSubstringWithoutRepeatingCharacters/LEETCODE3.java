import java.util.Arrays;

class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        
        final int len = s.length();
        final int[] index = new int[128];
        
        Arrays.fill(index, -1);
        
        int max = 0;
        
        for (int l = -1, r = 0; r < len; index[s.charAt(r)] = r++) {
            
            l = Math.max(l, index[s.charAt(r)]);
            max = Math.max(max, r - l);
        }
        
        return max;
    }
}