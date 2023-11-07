package method;

import common.TrieNode;

import java.util.Map;

/**
 * @author: Qbss
 * @date: 2023/11/6
 * @desc: 421. 数组中两个数的最大异或值
 */
public class Solution421 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        //false false true true true false
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }

    public int findMaximumXOR(int[] nums) {
        return 0;
    }

    static class Trie {

        private TrieNode trieNode;

        public Trie() {
            trieNode = new TrieNode();
        }

        public void insert(String word) {
            String[] split = word.split("");
            TrieNode node = this.trieNode;
            for (String s : split) {
                Map<String, TrieNode> children = node.getChildren();
                TrieNode c = children.get(s);
                if (c != null) {
                    node = c;
                } else {
                    TrieNode value = new TrieNode(s);
                    children.put(s, value);
                    node = value;
                }
            }
            node.setEndValue(word);
        }

        public boolean search(String word) {
            TrieNode node = getTrieNode(word);
            if (node == null) return false;
            return node.getEndValue() != null && node.getEndValue().equals(word);
        }

        private TrieNode getTrieNode(String word) {
            String[] split = word.split("");
            TrieNode node = this.trieNode;
            for (String s : split) {
                Map<String, TrieNode> children = node.getChildren();
                TrieNode c = children.get(s);
                if (c == null) {
                    return null;
                } else {
                    node = c;
                }
            }
            return node;
        }

        public boolean startsWith(String prefix) {
            return getTrieNode(prefix) != null;
        }
    }


}
