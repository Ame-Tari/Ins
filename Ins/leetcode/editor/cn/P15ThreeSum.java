//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2748 👎 0

package editor.cn;

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 */
//java:三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            int left = 0, right = nums.length - 1;
            for (int i = 1; i < nums.length - 1 ; i++) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0) {
                    left++;
                }
                if (sum == 0) {

                } else {
                    right--;
                }
                if (right == left) {
                    break;
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}