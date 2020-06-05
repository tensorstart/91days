package day01_66;

import java.util.Arrays;

/**
 * ClassName:day01_2
 * Package:day01
 * Discription:
 *
 * @Data:2020/6/1 12:01
 */
public class day01_2 {
    public static int[] plusOne(int[] digits) {
        int j=digits.length-1;
        int add=0;
        digits[digits.length-1]=digits[digits.length-1]+1;
        int[] digits_new=new int[digits.length+1];
        for (int i = j; i >=0 ; i--) {
            int middle=add+digits[i];
            digits_new[i+1]=(middle)%10;
            add=middle/10;
            digits_new[0]=add;
        }
        if (digits_new[0]==0){
            for (int i = 1; i <digits_new.length ; i++) {
                digits[i-1]=digits_new[i];
            }
            return digits;
        }
        return digits_new;
    }
    public static void main(String[] args) {
        int[] ss={9,8,9,9};
        int[] ints = plusOne(ss);
        System.out.println(Arrays.toString(ints));
    }
}
