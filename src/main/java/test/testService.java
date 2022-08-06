package test;

import common.TrieNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Qbss
 * @date 2022/7/14
 * @desc
 */
public class testService {

    private static void insertTrie(String[] split, int index, TrieNode trieNode) {
        if (index < split.length) {
            String key = split[index];
            trieNode.getChildren().put(key, new TrieNode(key));
            index++;
            insertTrie(split, index, trieNode.getChildren().get(key));
        }
    }

    private static void insertTrie1(String[] split, Integer index, TrieNode trieNode) {
        if (index < split.length) {
            String key = split[index];
            if (!trieNode.getChildren().containsKey(key)) {
                if (index == split.length - 1) {
                    trieNode.getChildren().put(key, new TrieNode(key, String.join("", split)));
                } else {
                    trieNode.getChildren().put(key, new TrieNode(key));
                }
            }
            index++;
            insertTrie1(split, index, trieNode.getChildren().get(key));
        }
    }

    private static boolean startsWith(String[] split, int index, TrieNode trieNode) {
        if (index < split.length) {
            String key = split[index];
            if (trieNode.getChildren().containsKey(key)) {
                index++;
                startsWith(split, index, trieNode.getChildren().get(key));
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean search1(String[] split, Integer index, TrieNode trieNode) {
        if (index < split.length) {
            String key = split[index];
            if (trieNode.getChildren().containsKey(key)) {
                index++;
                search1(split, index, trieNode.getChildren().get(key));
            } else {
                return false;
            }
        }
        return true;
    }

    private static void search2(String[] split, Integer index, TrieNode trieNode,
                                Set<Boolean> checkTemp) {
        if (index < split.length) {
            String key = split[index];
            if (trieNode.getChildren().containsKey(key)) {
                index++;
                search2(split, index, trieNode.getChildren().get(key), checkTemp);
            } else {
                checkTemp.add(false);
            }
        }
        checkTemp.add(true);
    }

    private static TrieNode getTrieNode(String[] split, TrieNode trieNode) {
        for (String s : split) {
            if (trieNode.getChildren().containsKey(s)) {
                trieNode = trieNode.getChildren().get(s);
            } else {
                return trieNode;
            }
        }
        return trieNode;
    }


    public List<String> stringMatching(String[] words) {

        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (!used[i]) {
                for (int j = 0; j < words.length; j++) {
                    if (j == i) {
                        continue;
                    } else {
                        if (!used[j]) {
                            if (words[i].contains(words[j])) {
                                used[j] = true;
                                res.add(words[j]);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        String[] split = {"g", "o", "e"};
        String[] split1 = {"g", "o", "e", "f"};


        TrieNode trieNode = new TrieNode();
        Integer index = 0;
        insertTrie1(split, index, trieNode);

        TrieNode trieNode1 = getTrieNode(split1, trieNode);
        System.out.println(trieNode);
        System.out.println(trieNode1);

    }

}
