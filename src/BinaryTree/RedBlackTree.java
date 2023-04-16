package BinaryTree;

public class RedBlackTree extends ArvoreBinariaDeBusca {

    @Override
    Node put(Node parent, Node node, Integer key) {
        node = super.put(parent, node, key);
        fixPostInsertion(node);
        return node;
    }

    private void fixPostInsertion(Node node) {
        Node parent = node.getParent();
        if (parent == null) {
            node.setColor(Node.BLACK_COLOR);
            return;
        }
        if (parent.isBlack()) {
            return;
        }
        Node uncle = getUncle(node);

    }

    private Node getUncle(Node parent) {
        Node grandparent = parent.getParent();
        if (grandparent.getLeft() == parent) {
            return grandparent.getRight();
        }
        return grandparent.getLeft();
    }

}
