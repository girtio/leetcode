import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * 三数之和
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int j = i + 1; // left pointer
            int k = nums.length - 1; // right pointer
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> currList = new ArrayList<>();
                    currList.add(nums[i]);
                    currList.add(nums[j]);
                    currList.add(nums[k]);
                    result.add(currList);
                    j++;
                    k--;
                    while (j < nums.length - 1 && nums[j] == nums[j - 1]) j++;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = ThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

}
