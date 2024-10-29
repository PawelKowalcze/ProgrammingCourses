import java.util.Arrays;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4};
        System.out.println(new Solution().hasDuplicate(num));



    }
}
