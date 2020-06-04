package day01;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:day01
 * Package:PACKAGE_NAME
 * Discription:
 *给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Data:2020/6/1 10:35
 */
public class day01_1 {
    public static int[] plusOne(int[] digits) {
        String s = "";
        for (int i = 0; i < digits.length; i++) {
            s+=Integer.toString(digits[i]);
        }

        long num = Long.parseLong(s);
        long add_num=num+1;
        List<Long> list =new LinkedList<>();
        while (add_num>0){
            long ss=add_num%10;
            list.add(ss);
            add_num/=10;
        }
        Collections.reverse(list);
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            long aa=list.get(i);
            res[i]=(int) aa;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] ss={9,8,7,6,5,4,3,2,1,0};
        int[] ints = plusOne(ss);
        System.out.println(Arrays.toString(ints));
    }
}