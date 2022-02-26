class Solution {
    
    public boolean rotateString(String s, String goal) {
        
        return s.length() == goal.length() && 
            new StringBuilder().append(s).append(s).toString().contains(goal);
    }
}