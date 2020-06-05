package day02_75;

import java.util.Arrays;

/**
 * ClassName:day02_2
 * Package:day02
 * Discription:
 *
 * @Data:2020/6/2 21:05
 */
public class day02_2 {
    public static void sortColors(int[] nums) {
        if (nums==null||nums.length<2)return;
        int middle=1;
        int l=0;
        int r=nums.length-1;
        int cur=0;
        while (cur<=r){
            if (nums[cur]<middle){
                swap(nums,cur,l);
                cur++;
                l++;
            }
            else if (nums[cur]>middle){
                swap(nums,cur,r);
                r--;
            }
            else cur++;
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void main(String[] args) {
        int[] nums={2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
