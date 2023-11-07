package common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qbss
 * @date 2022/7/14
 * @desc
 */
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEndValue() {
        return endValue;
    }

    public void setEndValue(String endValue) {
        this.endValue = endValue;
    }

    public Map<String, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<String, TrieNode> children) {
        this.children = children;
    }
}
