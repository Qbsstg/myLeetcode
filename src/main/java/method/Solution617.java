package method;

import common.BBTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution617 {

    public BBTreeNode mergeTrees(BBTreeNode root1, BBTreeNode root2) {

        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        BBTreeNode bbTreeNode = new BBTreeNode(root1.getValue() + root2.getValue());
        bbTreeNode.setLeftNode(mergeTrees(root1.getLeftNode(), root2.getLeftNode()));
        bbTreeNode.setRightNode(mergeTrees(root1.getRightNode(), root2.getRightNode()));

        return bbTreeNode;
    }


    public BBTreeNode bfs(BBTreeNode root1, BBTreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        BBTreeNode bbTreeNode = new BBTreeNode(root1.getValue() + root2.getValue());

        Queue<BBTreeNode> queue1 = new LinkedList<>();
        Queue<BBTreeNode> queue2 = new LinkedList<>();
        Queue<BBTreeNode> queue3 = new LinkedList<>();

        queue1.offer(root1);
        queue2.offer(root2);
        queue3.offer(bbTreeNode);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            BBTreeNode poll1 = queue1.poll();
            BBTreeNode poll2 = queue2.poll();
            BBTreeNode poll3 = queue3.poll();

            BBTreeNode leftNode1 = poll1.getLeftNode();
            BBTreeNode rightNode1 = poll1.getRightNode();

            BBTreeNode leftNode2 = poll2.getLeftNode();
            BBTreeNode rightNode2 = poll2.getRightNode();

            if (leftNode1 != null || leftNode2 != null) {
                if (leftNode1 != null && leftNode2 != null) {
                    BBTreeNode bbTreeNode1 = new BBTreeNode(leftNode1.getValue() + leftNode2.getValue());
                    poll3.setLeftNode(bbTreeNode1);
                    queue1.offer(leftNode1);
                    queue2.offer(leftNode2);
                    queue3.offer(bbTreeNode1);
                } else if (leftNode1 != null) {
                    poll3.setLeftNode(leftNode1);
                } else {
                    poll3.setLeftNode(leftNode2);
                }
            }

            if (rightNode1 != null || rightNode2 != null) {
                if (rightNode1 != null && rightNode2 != null) {
                    BBTreeNode bbTreeNode1 = new BBTreeNode(rightNode1.getValue() + rightNode2.getValue());
                    poll3.setRightNode(bbTreeNode1);
                    queue1.offer(rightNode1);
                    queue2.offer(rightNode2);
                    queue3.offer(bbTreeNode1);
                } else if (rightNode1 != null) {
                    poll3.setRightNode(rightNode1);
                } else {
                    poll3.setRightNode(rightNode2);
                }
            }

        }
        return bbTreeNode;
    }


}
