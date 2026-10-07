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
            // System.out.println(strsTouple.get(i).sorted() + " : " + strsTouple.get(i).initial());
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


        // int[] usedArray = new int[strs.length];
        // for(int i = 0; i < strs.length - 1; i ++) {
        //     List <String> myLocalOutput = new ArrayList<>();
        //     if (usedArray[i] == 1) continue;
        //     usedArray[i] = 1;
        //     myLocalOutput.add(strs[i]);
        //     for (int j = i + 1; j <  strs.length; j++) {
        //         if (isAnagram(strs[i], strs[j]) && usedArray[j] == 0) {
        //             usedArray[j] = 1;
        //             myLocalOutput.add(strs[j]);

        //         }
        //     }
        //     myOutput.add(myLocalOutput);
        // }
        return myOutput;
    }
    public String sortAnagram(String s) {
        char[] arrChar = s.toCharArray();
        Arrays.sort(arrChar);
        return new String(arrChar);
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray(); 
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}

record StrsTouple (String sorted, String initial) {}


// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List <List<String>> myOutput = new ArrayList<>();
//         int[] usedArray = new int[strs.length];
//         for(int i = 0; i < strs.length; i ++) {
//             List <String> myLocalOutput = new ArrayList<>();
//             if (usedArray[i] == 1) continue;
//             usedArray[i] = 1;
//             myLocalOutput.add(strs[i]);
//             for (int j = i + 1; j <  strs.length; j++) {
//                 if (isAnagram(strs[i], strs[j]) && usedArray[j] == 0) {
//                     usedArray[j] = 1;
//                     myLocalOutput.add(strs[j]);

//                 }
//             }
//             myOutput.add(myLocalOutput);
//         }
//         return myOutput;
//     }

//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length()) {
//             return false;
//         }
//         char[] sArray = s.toCharArray(); 
//         char[] tArray = t.toCharArray();
//         Arrays.sort(sArray);
//         Arrays.sort(tArray);
//         return Arrays.equals(sArray, tArray);
//     }
// }
