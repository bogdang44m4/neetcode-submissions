class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> anagramsMap = new HashMap<>();
        ArrayList<String> anagramList;
        for(String str : strs) {
            char[] anagram = str.toCharArray();
            Arrays.sort(anagram);
            anagramsMap.putIfAbsent(new String(anagram), new ArrayList<String>());
            anagramsMap.get(new String(anagram)).add(str);
        }
        return new ArrayList<>(anagramsMap.values());
    }

    public String getAnagram(String s) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return new String(sArray);
    }
}