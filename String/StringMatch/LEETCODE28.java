class Solution {
    
    public int strStr(String h, String n) {
        
        if (n.length() == 0) return 0;
        
        final int[] hFreq = new int[26];
        final int[] nFreq = new int[26];
        
        for (int i = 0, l = n.length(); i < l; i++) nFreq[n.charAt(i) - 'a']++;
        
        loop:
        for (int i = 0, l = h.length(), count = 0, pivot = 0; i < l; i++) {
            
            hFreq[h.charAt(i) - 'a']++;
            count++;
            
            if (count >= n.length()) {
                
                for (int j = 0; j < 26; j++) if (nFreq[j] != hFreq[j]) {
                    
                    hFreq[h.charAt(pivot++) - 'a']--; continue loop;
                }
                
                for (int j = 0, nl = n.length(); j < nl; j++)
                if (n.charAt(j) != h.charAt(j+pivot)) {
                    
                    hFreq[h.charAt(pivot++) - 'a']--; continue loop;
                }
                    
                return pivot;
            }
        }
        
        return -1;
    }
}