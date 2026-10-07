class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List <List<String>> myOutput = new ArrayList<>();
        List <StrsTouple> strsTouple = new ArrayList<>();
        List<String> uniqueList = new ArrayList<>();

        for(int i = 0; i < strs.length; i ++) {
            strsTouple.add(new StrsTouple(sortAnagram(strs[i]), strs[i]));
        }

        strsTouple.sort(Comparator.comparing(StrsTouple::sorted));
        
        for(int i = 0; i < strsTouple.size(); i ++) {
            String initialCurrent = strsTouple.get(i).initial();
            if (uniqueList.isEmpty()) {
                uniqueList.add(strsTouple.get(i).initial());
            } else if (sortAnagram(uniqueList.get(0)).equals(sortAnagram(initialCurrent))) {
                uniqueList.add(initialCurrent);
            } else {
                myOutput.add(uniqueList);
                uniqueList = new ArrayList<>();
                uniqueList.add(initialCurrent);
            }
        }
        if (!uniqueList.isEmpty()) {
            myOutput.add(uniqueList);
        }
        return myOutput;
    }
    public String sortAnagram(String s) {
        char[] arrChar = s.toCharArray();
        Arrays.sort(arrChar);
        return new String(arrChar);
    }
}

record StrsTouple (String sorted, String initial) {}

