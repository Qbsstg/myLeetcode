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
        int[] nums = {3, 10, 5, 25, 2, 8};
    }

    public int findMaximumXOR(int[] nums) {
        return 0;
    }

    class Trie {

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
                    children.put(s, new TrieNode(s));
                }
            }
            node.setEndValue(word);
        }

        public boolean search(String word) {
            String[] split = word.split("");
            return false;
        }

        public boolean startsWith(String prefix) {
            return false;
        }
    }

}
