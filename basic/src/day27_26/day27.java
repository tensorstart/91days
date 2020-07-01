package day27_26;

/**
 * ClassName:day27
 * Package:day27_26
 * Discription:
 *
 * @Data:2020/6/28 12:07
 */
public class day27 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length==1)return 1;
        int slow=1;
        int fast=1;
        int length=nums.length-1;
        while (fast<=length){
            if (nums[fast]!=nums[fast-1]){
                swap(nums,slow,fast);
                slow++;
            }
            fast++;
        }
        return slow;
    }
    public static void swap(int[] nums,int slow,int fast){
//        int temp=nums[fast];
        nums[slow]=nums[fast];
//        nums[slow]=temp;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
}
