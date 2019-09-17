package org.eve.framework.string;

/**
 * @author jc
 * @date 2019/9/16 22:49
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(2));
        System.out.println(new CountAndSay().countAndSay(3));
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
    }

    public String countAndSay(int n) {
        String result = "1", temp = result;
        int count;
        char tempC;
        char[] chars;
        for (int i = 2; i <= n; temp = result, i++) {
            result = "";
            count = 0;
            tempC = '\u0000';
            for (int j = 0; j < (chars = temp.toCharArray()).length; j++) {
                if (chars[j] != tempC) {
                    if (count > 0) {
                        result = result + count + tempC;
                    }
                    tempC = chars[j];
                    count = 0;
                }
                count++;
            }
            if (count > 0) {
                result = result + count + tempC;
            }
        }
        return result;
    }
}
