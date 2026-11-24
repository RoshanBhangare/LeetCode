class Solution {
    public void moveZeroes(int[] nums) {
        int inser = 0;

        // 1. Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[inser] = nums[i];
                inser++;
            }
        }

        // 2. Fill the remaining positions with zeroes
        while (inser < nums.length) {
            nums[inser] = 0;
            inser++;
        }
    }
}