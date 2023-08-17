/**
 * HuffmanCodeBook class file.
 * Written by Hydreesia
 */

public class HuffmanCodeBook {

    /**
     * Node class for HuffmanCodeBook.
     */
    private static class Node {
        private char c;
        private BinarySequence seq;
        private Node next;

        /**
         * Constructor for Node with next input.
         */
        public Node(char c, BinarySequence seq, Node next) {
            this.c = c;
            this.seq = seq;
            this.next = next;
        }

        /**
         * Constructor for Node without next input.
         */
        public Node(char c, BinarySequence seq) {
            this.c = c;
            this.seq = seq;
            this.next = null;
        }

        public char getC() {
            return c;
        }

        public BinarySequence getSeq() {
            return seq;
        }

        public Node getNext() {
            return next;
        }

        public void setC(char c) {
            this.c = c;
        }

        public void setSeq(BinarySequence seq) {
            this.seq = seq;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    /**
     * Constructor for an empty HuffmanCodeBook.
     */
    public HuffmanCodeBook() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Adds a sequence to the HuffmanCodeBook.
     */
    public void addSequence(char c, BinarySequence seq) {
        Node newNode = new Node(c, seq);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else if (tail.getC() == c && tail.getSeq().equals(seq)) {
            //If there is an update to the codebook? Maybe not necessary?
            tail.setC(c);
            tail.setSeq(seq);
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    /**
     * Returns true if the HuffmanCodeBook contains the given letter.
     */
    public boolean contains(char letter) {
        Node cur = head;
        while (cur != null) {
            if (cur.getC() == letter) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    /**
     * Returns true if the HuffmanCodeBook contains all the given letters.
     */
    public boolean containsAll(String letters) {
        for (int i = 0; i < letters.length(); i++) {
            if (!contains(letters.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the BinarySequence associated with the given letter.
     */
    public BinarySequence getSequence(char c) {
        Node cur = head;
        while (cur != null) {
            if (cur.getC() == c) {
                return cur.getSeq();
            }
            cur = cur.getNext();
        }
        return null;
    }

    /**
     * Returns a string of all characters in the HuffmanCodeBook.
     */
    public String getAllChars() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.getC());
            cur = cur.getNext();
        }
        return sb.toString();
    }

    /**
     * Encodes a string into a BinarySequence.
     */
    public BinarySequence encode(String s) {
        BinarySequence newSeq = new BinarySequence();
        for (int i = 0; i < s.length(); i++) {
            newSeq.append(getSequence(s.charAt(i)));
        }
        return newSeq;
    }
}
