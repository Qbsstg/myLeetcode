package method;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qbss
 * @date 2022/8/5
 * @desc
 */
public class Solution36 {

    public static void main(String[] args) {
        System.out.println((int) '.');
        char[][] borad = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},

                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},

                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        char[][] borad1 = {
                {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},

                {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},

                {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '5', '2', '.', '.'}
        };
        System.out.println(isValidSudoku(borad));
    }

    public static boolean isValidSudoku(char[][] board) {

        //横向的对比
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            Set<Character> characters = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char aChar = board[i][j];
                char bChar = board[j][i];
                if (aChar != 46) {
                    if (!set.add(aChar)) {
                        return false;
                    }
                }
                if (bChar != 46) {
                    if (!characters.add(bChar)) {
                        return false;
                    }
                }
            }
        }

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i][j];
                if (c != 46) {
                    if (!set1.add(c)) {
                        return false;
                    }
                }
            }
            for (int j = 3; j < 6; j++) {
                char c = board[i][j];
                if (c != 46) {
                    if (!set2.add(c)) {
                        return false;
                    }
                }
            }
            for (int j = 6; j < 9; j++) {
                char c = board[i][j];
                if (c != 46) {
                    if (!set3.add(c)) {
                        return false;
                    }
                }
            }
        }

        set1.clear();;
        set2.clear();;
        set3.clear();;

        for (int i = 3; i < 6; i++) {

            for (int j = 0; j < 3; j++) {
                char c = board[i][j];
                if (c != 46) {
                    if (!set1.add(c)) {
                        return false;
                    }
                }
            }
            for (int j = 3; j < 6; j++) {
                char c = board[i][j];
                if (c != 46) {
                    if (!set2.add(c)) {
                        return false;
                    }
                }
            }
            for (int j = 6; j < 9; j++) {
                char c = board[i][j];
                if (c != 46) {
                    if (!set3.add(c)) {
                        return false;
                    }
                }
            }
        }

        set1.clear();;
        set2.clear();;
        set3.clear();;
        for (int i = 6; i < 9; i++) {

            for (int j = 0; j < 3; j++) {
                char c = board[i][j];
                if (c != 46) {
                    if (!set1.add(c)) {
                        return false;
                    }
                }
            }
            for (int j = 3; j < 6; j++) {
                char c = board[i][j];
                if (c != 46) {
                    if (!set2.add(c)) {
                        return false;
                    }
                }
            }
            for (int j = 6; j < 9; j++) {
                char c = board[i][j];
                if (c != 46) {
                    if (!set3.add(c)) {
                        return false;
                    }
                }
            }
        }


        return true;
    }


}
