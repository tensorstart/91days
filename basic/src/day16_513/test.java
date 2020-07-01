package day16_513;

import java.util.ArrayList;

/**
 * ClassName:test
 * Package:day16_513
 * Discription:
 *
 * @Data:2020/6/16 21:16
 */
public class test {
    public static void main(String[] args) {
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        ArrayList<Integer> list2=new ArrayList<>();
        Object clone = list1.clone();
        System.out.println(clone);
        list1.add(4);
        System.out.println(list1);
    }
}
