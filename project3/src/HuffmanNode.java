/**
 * HuffmanNode class file.
 * Written by Hydreesia
 */

public class HuffmanNode {
    private HuffmanNode zero;
    private HuffmanNode one;
    private Character data;

    /**
     * Constructor for HuffmanNode where the node is not a leaf.
     */
    public HuffmanNode(HuffmanNode zero, HuffmanNode one) {
        this.zero = zero;
        this.one = one;
        data = null;
    }

    /**
     * Constructor for HuffmanNode where the node is a leaf.
     */
    public HuffmanNode(char data) {
        zero = null;
        one = null;
        this.data = data;
    }

    public HuffmanNode getZero() {
        return zero;
    }

    public void setZero(HuffmanNode zero) {
        this.zero = zero;
    }

    public HuffmanNode getOne() {
        return one;
    }

    public void setOne(HuffmanNode one) {
        this.one = one;
    }

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return (zero == null && one == null && data != null);
    }

    /**
     * Checks if the node is valid.
     *
     * @return true if the node is valid, false otherwise.
     */
    public boolean isValidNode() {
        if (isLeaf()) {
            return true;
        } else {
            return (zero != null && one != null);
        }
    }

    /**
     * Checks if the tree is valid.
     *
     * @return true if the tree is valid, false otherwise.
     */
    public boolean isValidTree() {
        if (!isValidNode()) {
            return false;
        }
        if (isLeaf()) {
            return true;
        }
        return zero.isValidTree() && one.isValidTree();
    }
}
