class Solution {
    
    public boolean isPalindrome(String s) {
        
        int l = 0, r = s.length()-1;
        
        while (l < r) {
            
            if (Character.toLowerCase(s.charAt(l)) == 
                Character.toLowerCase(s.charAt(r))) { l++; r--; }
            else if (!Character.isLetterOrDigit(s.charAt(l))) l++;
            else if (!Character.isLetterOrDigit(s.charAt(r))) r--;
            else return false;
        }
        
        return true;
    }
}