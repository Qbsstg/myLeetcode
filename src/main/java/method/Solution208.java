package method;

import common.TrieNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qbss
 * @date 2022/7/14
 * @desc
 */
public class Solution208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert1("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert1("app");
        System.out.println(trie.search("app"));
    }


    static class Trie {

        private TrieNode trieNode;

        public Trie() {
            this.trieNode = new TrieNode();
        }

        public void insert(String word) {
            insertTrie(word.split(""), 0, this.trieNode);
        }

        public void insert1(String word) {
            String[] split = word.split("");
            TrieNode node = this.trieNode;
            for (String s : split) {
                if (node.getChildren().containsKey(s)) {
                    node = node.getChildren().get(s);
                } else {
                    node.getChildren().put(s, new TrieNode(s));
                }
            }
            node.setEndValue(word);
        }

        public boolean search(String word) {
            TrieNode trieNode1 = getTrieNode(word.split(""), trieNode);
            return trieNode1.getEndValue() != null && trieNode1.getEndValue().equals(word);
        }

        public boolean startsWith(String prefix) {
            Set<Boolean> checkTemp = new HashSet<>();
            startsWithTrie(prefix.split(""), 0, this.trieNode, checkTemp);
            return !checkTemp.contains(Boolean.FALSE);
        }

        private void insertTrie(String[] split, int index, TrieNode trieNode) {
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
                insertTrie(split, index, trieNode.getChildren().get(key));
            } else if (index == split.length) {
                trieNode.setEndValue(String.join("", split));
            }
        }

        private void startsWithTrie(String[] split, int index, TrieNode trieNode,
                                    Set<Boolean> checkTemp) {
            if (index < split.length) {
                String key = split[index];
                if (trieNode.getChildren().containsKey(key)) {
                    index++;
                    startsWithTrie(split, index, trieNode.getChildren().get(key), checkTemp);
                } else {
                    checkTemp.add(false);
                }
            }
            checkTemp.add(true);
        }

        private TrieNode getTrieNode(String[] split, TrieNode trieNode) {
            for (String s : split) {
                if (trieNode.getChildren().containsKey(s)) {
                    trieNode = trieNode.getChildren().get(s);
                } else {
                    return trieNode;
                }
            }
            return trieNode;
        }
    }

}
