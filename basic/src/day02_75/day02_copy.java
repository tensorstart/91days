package day02_75;

/**
 * ClassName:day02_3
 * Package:day02
 * Discription:
 *
 * @Data:2020/6/2 16:10
 */
public class day02_copy {
    //Time:O(n)  Space:O(1)

        // 这个题目有点像快速排序，找中间值，然后把数组分成小于中间值的一部分、等于中间值的一部分，大于中间值的一部分
        public void sortColors(int[] nums) {
            int mid = 1;
            int l = 0;
            int r = nums.length - 1;

            int curr = 0;
            while (curr <= r) {
                if (nums[curr] > mid) {
                    //大于时，右边--; curr位置不变
                    swap(nums, curr, r);
                    r--;
                } else if (nums[curr] < mid){
                    //小于时，左边l++
                    swap(nums, curr, l);
                    curr++;
                    l ++;
                } else {
                    //相等时直接遍历下一个
                    curr ++;
                }
            }

        }
        private void swap(int[] nums,int i,int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

}
