package BinaryTree;
public class Node {
    private Node left;
    private Node right;
    private Node parent;
    private Integer key;
    private boolean color;
    public static boolean RED_COLOR = false;
    public static boolean BLACK_COLOR = true;

    public Node(int key) {
        this.key = key;
        this.color = false;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public boolean isBlack() {
        return color;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node righ) {
        this.right = righ;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node key: " + this.key + " Node color: " + (this.color ? "Black" : "Red");
    }

}
