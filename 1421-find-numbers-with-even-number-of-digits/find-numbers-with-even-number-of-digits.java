class Solution {
    static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)){
                count++;
            }
        }
        return count;
    }
     static boolean even(int num) {

        int numberOfDigits = digit(num);
        if (numberOfDigits % 2 == 0){
            return true;
        }
        return false;
    }
    static int digit(int num) {

        int count =0;
        while (num>0){
            count++;
            num=num/10;
        }
        return count;
   }
}