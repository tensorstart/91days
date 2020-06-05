package day02_75;

import java.util.Arrays;

/**
 * ClassName:day02
 * Package:day02
 * Discription:给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、
 * 蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Data:2020/6/2 10:25
 */
public class day02_1 {
    public static void sortColors(int[] nums) {
//        使用插入排序
        if (nums.length<2||nums==null) return;
        for (int i = 1; i <nums.length ; i++) {
            for (int j = i-1; j >-1 ; j--) {
//                && nums[j]>nums[j+1]
                if (nums[j]>nums[j+1]) {
                    int middle=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=middle;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
