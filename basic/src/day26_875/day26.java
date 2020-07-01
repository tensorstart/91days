package day26_875;

import java.util.Arrays;

/**
 * ClassName:day26
 * Package:day26_875
 * Discription:
 *
 * @Data:2020/6/28 8:40
 */
public class day26 {
    public static int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];
        while (l <=r) {
            int mid = l + (r - l) / 2;
            if (eatall(piles, mid, H))
                r = mid - 1;//说明速度还是快
            else
                l = mid + 1;
        }

        return r+1;
    }

    public static boolean eatall(int[] piles, int speed, int H) {
        int h = 0;
        for (int pile : piles) {
            int eh = pile % speed;
            int add;
            if (eh == 0)
                add = pile / speed;
            else
                add = (pile / speed) + 1;
            h += add;
        }
        return h <= H;
    }

    public static void main(String[] args) {
        int[] arr = {30,11,23,4,20};
        int H =  6;
        int i = minEatingSpeed(arr, H);
        System.out.println(i);
    }
}
