/**
 * HuffmanCodeTree class file.
 * Written by Hydreesia
 */

public class HuffmanCodeTree {
    private HuffmanNode root;

    /**
     * Constructor for the root of a HuffmanCodeTree.
     */
    public HuffmanCodeTree(HuffmanNode root) {
        this.root = root;
    }

    /**
     * Constructor for a HuffmanCodeTree given a HuffmanCodeBook.
     */
    public HuffmanCodeTree(HuffmanCodeBook codebook) {
        root = new HuffmanNode(null, null);
        String letters = codebook.getAllChars();
        for (int i = 0; i < letters.length(); i++) {
            BinarySequence seq = codebook.getSequence(letters.charAt(i));
            put(seq, letters.charAt(i));
        }
    }

    /**
     * Returns true if the tree is valid, false otherwise.
     */
    public boolean isValid() {
        return root.isValidTree();
    }

    /**
     * Adds a new node to the tree given a BinarySequence and a letter.
     */
    public void put(BinarySequence seq, char letter) {
        HuffmanNode current = root;
        for (boolean bit : seq) {
            if (bit) {
                if (current.getOne() == null) {
                    current.setOne(new HuffmanNode(null, null));
                }
                current = current.getOne();
            } else {
                if (current.getZero() == null) {
                    current.setZero(new HuffmanNode(null, null));
                }
                current = current.getZero();
            }
        }
        current.setData(letter);
    }

    /**
     * Decodes a BinarySequence into a String.
     */
    public String decode(BinarySequence s) {
        StringBuilder sb = new StringBuilder();
        HuffmanNode node = root;
        for (boolean b : s) {
            if (b) {
                node = node.getOne();
            } else {
                node = node.getZero();
            }
            if (node.isLeaf()) {
                sb.append(node.getData());
                node = root;
            }
        }
        return sb.toString();
    }
}
