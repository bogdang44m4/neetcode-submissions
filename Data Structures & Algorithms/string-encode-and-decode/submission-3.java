class Solution {
    public final static String SEPARATOR = "π";
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
       
        for(String str : strs) {
            sb.append(str.length()+SEPARATOR+str+SEPARATOR);
        }
        System.out.println(sb.toString());
        return sb.toString();   
    }

    public List<String> decode(String str) {
        List<String> sList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split(SEPARATOR);
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        for(int i=0; i< strs.length; i+=2) {
            if(strs[i].equals("0")) {
                sList.add("");
            } else {
                sList.add(strs[i+1]);
            }
        }
        return sList;
    }
}