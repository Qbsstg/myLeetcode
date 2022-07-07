package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Qbss
 * @date 2022/7/7
 * @desc AVL树
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BBTreeNode {

    private int value;

    private BBTreeNode leftNode;

    private BBTreeNode rightNode;

    public BBTreeNode(int value) {
        this.value = value;
    }
}
