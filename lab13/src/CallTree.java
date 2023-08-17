public class CallTree {
    CallTreeNode root;

    public CallTree(String name) {
        root = new CallTreeNode(name);
    }

    private CallTreeNode find(String name, CallTreeNode node) {
        if (node == null) {
            return null;
        } else if (node.getName().equals(name)) {
            return node;
        } else {
            CallTreeNode result = find(name, node.getFirst());
            if (result == null) {
                result = find(name, node.getSecond());
            }
            return result;
        }
    }

    private CallTreeNode find(String name) {
        return find(name, root);
    }

    public boolean inCallTree(String person) {
        if (find(person) == null) {
            return false;
        } else {
            return find(person).getName().equals(person);
        }
    }

    public boolean shouldCall(String person, String first, String second) {
        if (!inCallTree(person)) {
            return false;
        } else if (find(person).getFirst() != null || find(person).getSecond() != null) {
            return false;
        } else if (find(first) != null || find(second) != null) {
            return false;
        } else {
            CallTreeNode node = find(person);
            node.setFirst(new CallTreeNode(first));
            node.setSecond(new CallTreeNode(second));
            return true;
        }
    }

    public String getFirstCall(String name) {
        if (inCallTree(name)) {
            if (find(name).getFirst() == null) {
                return null;
            } else {
                return find(name).getFirst().getName();
            }
        }
        return null;
    }

    public String getSecondCall(String name) {
        if (inCallTree(name)) {
            if (find(name).getSecond() == null) {
                return null;
            } else {
                return find(name).getSecond().getName();
            }
        }
        return null;
    }

    public int getCallCount() {
        return getHeight(root);
    }

    private int getHeight(CallTreeNode node) {
        if (node.getFirst() == null && node.getSecond() == null) {
            return 0;
        } else if (node.getFirst() == null) {
            return 1 + getHeight(node.getSecond());
        } else if (node.getSecond() == null) {
            return 1 + getHeight(node.getFirst());
        } else {
            return 1 + Math.max(getHeight(node.getFirst()), getHeight(node.getSecond()));
        }
    }

    public int terminalContactCount() {
        return terminalContactCountHelper(root);
    }

    private int terminalContactCountHelper(CallTreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.getFirst() == null && node.getSecond() == null) {
            return 1;
        } else {
            int count = 0;
            if (node.getFirst() != null) {
                count += terminalContactCountHelper(node.getFirst());
            }
            if (node.getSecond() != null) {
                count += terminalContactCountHelper(node.getSecond());
            }
            return count;
        }
    }
}
