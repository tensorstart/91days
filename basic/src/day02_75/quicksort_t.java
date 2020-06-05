package day02_75;

import java.util.Arrays;

/**
 * ClassName:day02_2
 * Package:day02
 * Discription:
 *
 * @Data:2020/6/2 15:44
 */
public class quicksort_t {
//    使用快速排序
    public static void sortColors(int[] nums){
        int low=0;
        int high=nums.length-1;
        quicksort(nums,low,high);

    }
    public static void quicksort(int[] nums,int l,int r){
        if (l>r)return;//递归出口
        int i,j,base;
        i=l;
        j=r;
        base=nums[i];
        while (i<j){
            while (i<j&&nums[j]>=base)//先找右边（必须），从右边找一个比基准大的
                j--;
            while (i<j&&nums[i]<=base)//再找左边，从左边找一个比基准小的
                i++;

            if (i<j){//如果满足左指针小于右指针，交换
                int middle=nums[i];
                nums[i]=nums[j];
                nums[j]=middle;
            }
        }
        int temp=nums[i];//基准数与i（j）所在的值交换，此时基准数左边比它小，右边比它大
        nums[i]=base;
        nums[l]=temp;

        quicksort(nums,l,j-1);//左递归

        quicksort(nums,j+1,r);//右递归


    }

    public static void main(String[] args) {
        int[] nums={4,1,2,5,6,3};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
