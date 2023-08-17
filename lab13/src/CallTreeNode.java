public class CallTreeNode {
    private String name;
    private CallTreeNode second;
    private CallTreeNode first;

    public CallTreeNode(String name, CallTreeNode first, CallTreeNode second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }

    public CallTreeNode(String name) {
        first = null;
        second = null;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CallTreeNode getFirst() {
        return first;
    }

    public CallTreeNode getSecond() {
        return second;
    }

    public void setFirst(CallTreeNode first) {
        this.first = first;
    }

    public void setSecond(CallTreeNode second) {
        this.second = second;
    }

    public boolean isCaller() {
        return first != null;
    }
}