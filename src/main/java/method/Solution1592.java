package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/9/7
 * @desc
 */
public class Solution1592 {


    public static void main(String[] args) {
        String s1 = "  this   is  a sentence ";
        String s2 = " practice   makes   perfect";
        String s3 = "hello   world";
        String s4 = "  walks  udp package   into  bar a";
        String s5 = "a";
        String s6 = " a";
        //System.out.println("[" + reorderSpaces(s1) + "]");
        //System.out.println("[" + reorderSpaces(s2) + "]");
        //System.out.println("[" + reorderSpaces(s3) + "]");
        //System.out.println("[" + reorderSpaces(s4) + "]");
        //System.out.println("[" + reorderSpaces(s5) + "]");
        System.out.println("[" + reorderSpaces(s6) + "]");

    }


    public static String reorderSpaces(String text) {

        char[] chars = text.toCharArray();
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 32) {
                count++;
            } else {
                int j = i + 1;
                if (j < chars.length) {
                    for (; j < chars.length; j++) {
                        char c = chars[j];
                        if (c == 32) {
                            list.add(text.substring(i, j));
                            i = j - 1;
                            break;
                        }
                        if (j == chars.length - 1) {
                            list.add(text.substring(i, chars.length));
                            i = j;

                        }
                    }
                } else {
                    list.add(text.substring(i, i + 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = list.size();
        if (size == 1) {
            if (count == 0) {
                return text;
            } else {
                return list.get(0) + " ".repeat(count);
            }
        }
        int l = count / (size - 1);
        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(Math.max(0, l)));
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i == list.size() - 1) {
                sb.append(" ".repeat(Math.max(0, count)));
            } else {
                sb.append(space);
                count -= l;
            }
        }


        return sb.toString();
    }

}
