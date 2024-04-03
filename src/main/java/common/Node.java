package common;

import java.util.List;

/**
 * @author Qbss
 * @date 2022/3/10
 * @desc
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }
}
