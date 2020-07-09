package day29_42;

import java.util.Map;

/**
 * ClassName:day29
 * Package:day29_42
 * Discription:
 *
 * @Data:2020/7/8 22:11
 */
public class day29 {
    public static int trap(int[] height) {
        if (height.length <= 2) return 0;
        int leftmax = 0;
        int rightmax = height.length - 1;
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > height[leftmax])
                    leftmax = j;
            }
            for (int j = i+1; j <= height.length-1; j++) {
                if (height[j] > height[rightmax])
                    rightmax = j;
            }
            int side = Math.min(height[leftmax], height[rightmax]);
            if (side <= height[i])
                res += 0;
            else res += (side - height[i]);
            leftmax=0;
            rightmax=height.length-1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(nums);
        System.out.println(trap);
    }
}
