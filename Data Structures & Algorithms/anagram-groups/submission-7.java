class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> anagramsMap = new HashMap<>();
        ArrayList<String> anagramList;
        for(String str : strs) {
            String anagram = getAnagram(str);
            if(anagramsMap.get(anagram) == null) {
                anagramList = new ArrayList<>();
                anagramList.add(str);
                anagramsMap.put(anagram, anagramList);
            } else {
                anagramList = anagramsMap.get(anagram);
                anagramList.add(str);
                anagramsMap.put(anagram, anagramList);
            }
        }
        return new ArrayList<>(anagramsMap.values());
    }

    public String getAnagram(String s) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return new String(sArray);
    }
}