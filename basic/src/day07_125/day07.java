package day07_125;

/**
 * ClassName:day07
 * Package:day07_125
 * Discription:
 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 *
 * @Data:2020/6/7 11:42
 */
public class day07 {
    public static boolean isPalindrome(String s) {
        if (s==null)return true;
        String new_s="";
        for (int i = 0; i < s.length(); i++) {
            String middle=s.substring(i,i+1);
            if (middle.matches("[a-z0-9]"))
                new_s+=middle;
            else if (middle.matches("[A-Z]")){//Character.isLetterOrDigit()这是个啥
                String lower = middle.toLowerCase();
                new_s+=lower;
            }
        }
        if (new_s.length()==0)return true;
        int l=0,r=new_s.length()-1;
        while (l<r){
            if (new_s.charAt(l)==new_s.charAt(r)){
                l++;
                r--;
            }
            else
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        String s="race a car";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }
}
