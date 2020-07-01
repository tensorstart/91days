package day28_167;

/**
 * ClassName:real_res
 * Package:day28_167
 * Discription:
 *
 * @Data:2020/6/28 17:56
 */
public class real_res {
    public static int[] twoSum1(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        int[] res=new int[2];
        while (l<r){
            if (numbers[l]+numbers[r]>target)
                r--;
            else if (numbers[l]+numbers[r]<target)
                l++;
            else {
                res[0]=l+1;
                res[1]=r+1;
            }
            if (res[0]!=0)
                break;

        }
        return res;
    }
}
