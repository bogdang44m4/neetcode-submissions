class Solution {
    public int longestConsecutive(int[] nums) {
        // Arrays.sort(nums);
        Set<Integer> numSet = new HashSet<>();
        if(nums.length==0) {
            return 0;
        }
        for(int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for(int num : numSet) {
            if(!numSet.contains(num-1)) {
                int len = 1;
                while (numSet.contains(num + len)) {
                    len++;
                }
                longest = Math.max(longest, len);
 
            }
        }

        return longest;
    }
}