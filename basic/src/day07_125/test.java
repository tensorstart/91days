package day07_125;

/**
 * ClassName:test
 * Package:day07_125
 * Discription:
 *
 * @Data:2020/6/7 11:49
 */
public class test {
    public static void main(String[] args) {
        String s="aAA21";
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i,i+1).matches("[a-z A-Z 0-9]"))
                System.out.println(true);
        }
    }
}
