package day28_167;

import java.util.Arrays;

/**
 * ClassName:day28
 * Package:day28_167
 * Discription:
 *
 * @Data:2020/6/28 17:44
 */
public class day28 {
    public static int[] twoSum(int[] numbers, int target) {
        int slow=0;
        int fast;
        int[] res=new int[2];
        while (slow<=numbers.length-1){
            if (res[0]!=0)break;
            fast=slow+1;
            while (fast<=numbers.length-1){
                if (numbers[slow]+numbers[fast]==target) {
                    res[0] = slow + 1;
                    res[1]=fast+1;
                    break;
                }
                if (numbers[slow]+numbers[fast]>target)break;
                fast++;
            }
            slow++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={2, 7, 11, 15};
        int target=9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
