class Solution {
    
    public String addStrings(String num1, String num2) {
        
        final StringBuilder sb = new StringBuilder();
        
        int i = num1.length()-1;
        int j = num2.length()-1;
        int bonus = 0;
        
        while (i >= 0 || j >= 0) {
            
            final int n1 = i >= 0? num1.charAt(i--) - 48: 0;
            final int n2 = j >= 0? num2.charAt(j--) - 48: 0;
            
            final int sum = n1 + n2 + bonus;
            
            bonus = sum / 10;
            sb.append(sum % 10);
        }
        if (bonus > 0) sb.append(bonus);
        
        return sb.reverse().toString();
    }
}