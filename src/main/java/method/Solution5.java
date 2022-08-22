package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2021/8/3
 * @desc
 */
public class Solution5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("yysooos"));
    }


    public static String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            List<Character> list = checkPalindrome(i, chars);
            if (list.size() > res.size()) {
                res = list;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        res.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    private static List<Character> checkPalindrome(int index, char[] chars) {

        List<Character> list = new ArrayList<>();
        int start = index - 1;
        int end = index + 1;
        if (start >= 0 && end < chars.length) {
            if (chars[start] == chars[end]) {
                if (chars[start] == chars[index]) {
                    List<Character> list1 = new ArrayList<>();
                    List<Character> list2 = new ArrayList<>();

                    list1.add(chars[index]);
                    while (start >= 0 && end < chars.length) {
                        if (chars[start] == chars[end]) {
                            list1.add(chars[end]);
                            list1.add(0, chars[start]);
                        } else {
                            break;
                        }
                        start = start - 1;
                        end = end + 1;
                    }

                    start = index - 1;
                    end = index;

                    while (start >= 0 && end < chars.length) {
                        if (chars[start] == chars[end]) {
                            list2.add(chars[end]);
                            list2.add(0, chars[start]);
                        } else {
                            break;
                        }
                        start = start - 1;
                        end = end + 1;
                    }

                    list = list1.size() > list2.size() ? list1 : list2;

                } else {
                    list.add(chars[index]);
                    while (start >= 0 && end < chars.length) {
                        if (chars[start] == chars[end]) {
                            list.add(chars[end]);
                            list.add(0, chars[start]);
                        } else {
                            break;
                        }
                        start = start - 1;
                        end = end + 1;
                    }
                }
            } else {
                if (chars[start] == chars[index]) {
                    end = index;
                    while (start >= 0 && end < chars.length) {
                        if (chars[start] == chars[end]) {
                            list.add(chars[end]);
                            list.add(0, chars[start]);
                        } else {
                            break;
                        }
                        start = start - 1;
                        end = end + 1;
                    }
                } else if (chars[index] == chars[end]) {
                    start = index;
                    while (start >= 0 && end < chars.length) {
                        if (chars[start] == chars[end]) {
                            list.add(chars[end]);
                            list.add(0, chars[start]);
                        } else {
                            break;
                        }
                        start = start - 1;
                        end = end + 1;
                    }
                } else {
                    list.add(chars[index]);
                }
            }
        } else {
            list.add(chars[index]);
            if (start >= 0) {
                if (chars[start] == chars[index]) {
                    list.add(chars[start]);
                }
            }
            if (end < chars.length) {
                if (chars[end] == chars[index]) {
                    list.add(chars[end]);
                }
            }
        }

        return list;
    }

}
