class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] resultsArray = new int[nums.length];
        int zeros = 0;
        int prod = 1;
        int lastZeroIndex = -1;
        System.out.println("initial = " + nums.length + "  nou = "+resultsArray.length);
        for(int i = 0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeros ++;
                lastZeroIndex=i;
            } else {
                prod *=nums[i];
            }
        }

        if(zeros > 1) {
            return resultsArray;
        } else if (zeros == 1) {
            resultsArray[lastZeroIndex] = prod;
            return resultsArray;
        }

        for(int i = 0; i < nums.length; i++) {
            resultsArray[i] = prod / nums[i];
        }
        return resultsArray;
    }
}

