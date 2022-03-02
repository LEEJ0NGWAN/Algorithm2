class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        final Map<Integer, List<String>> map = new HashMap<>();
        
        int[] freq = new int[26];
        
        for (String str: strs) {
            
            Arrays.fill(freq, 0);
            
            for (int i = 0, l = str.length(); i < l; i++) freq[str.charAt(i) - 'a']++;
            
            final int hash = Arrays.hashCode(freq);
            
            if (!map.containsKey(hash)) map.put(hash, new ArrayList<>());
            
            map.get(hash).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}