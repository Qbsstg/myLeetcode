package common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qbss
 * @date 2022/7/14
 * @desc
 */
@Data
public class TrieNode {

    private String value;

    private String endValue;

    private Map<String, TrieNode> children;

    public TrieNode() {
        this.value = null;
        this.endValue = null;
        this.children = new HashMap<>();
    }

    public TrieNode(String value) {
        this.endValue = null;
        this.value = value;
        this.children = new HashMap<>();
    }

    public TrieNode(String value, String endValue) {
        this.endValue = endValue;
        this.value = value;
        this.children = new HashMap<>();
    }


}
