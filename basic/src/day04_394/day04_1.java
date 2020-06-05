package day04_394;

import java.util.Stack;

/**
 * ClassName:day04_1
 * Package:day04
 * Discription:给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Data:2020/6/4 9:55
 */
public class day04_1 {
    public static String decodeString(String s) {
        String res = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String middle = s.substring(i, i + 1);
            if (middle.matches("[0-9]")) {
                String num = middle;
                while (i + 1 < s.length() && s.substring(i + 1, i + 2).matches("[0-9]")) {//判断是不是个连续的数
                    num += s.substring(i + 1, i + 2);
                    i++;
                }
                stack.add(num);

            } else if (middle.matches("[a-z]") || middle.equals("[") || middle.matches("[A-Z]")) {//使用正则表达式
                if (middle.equals("["))
                    stack.add(middle);
                else {
                    String ele = middle;
                    while (i + 1 < s.length() && s.substring(i + 1, i + 2).matches("[a-z]") ||
                            i + 1 < s.length() && s.substring(i + 1, i + 2).matches("[A-Z]")) {//判断是不是个连续的数
                        ele += s.substring(i + 1, i + 2);
                        i++;
                    }
                    stack.add(ele);
                }

            } else if (middle.equals("]")) {
                String temp = "";//中间变量
                while (!stack.peek().equals("["))
                    temp = stack.pop()+temp;
                stack.pop();
                int count = Integer.parseInt(stack.pop());
                String mid = temp;
                for (int j = 0; j < count - 1; j++) {
                    temp += mid;
                }
                stack.add(temp);

            }
        }
        while (!stack.empty()) { //最后把栈里的东西倒出来
            String middle2 = "";
            middle2 = stack.pop() + middle2;
            res = middle2 + res;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        String s1 = decodeString(s);
        System.out.println(s1);
    }
}
