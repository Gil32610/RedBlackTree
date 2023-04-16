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
        Node uncle = getUncle(parent);
        Node grandparent = parent.getParent();
        if (uncle != null && !uncle.isBlack()) {
            parent.setColor(Node.BLACK_COLOR);
            uncle.setColor(Node.BLACK_COLOR);
            grandparent.setColor(Node.RED_COLOR);
            fixPostInsertion(grandparent);
        }else if(parent == parent.getParent().getRight()){

        }


    }

    private Node getUncle(Node parent) {
        Node grandparent = parent.getParent();
        if (grandparent.getLeft() == parent) {
            return grandparent.getRight();
        }
        return grandparent.getLeft();
    }

    private void rotateLeft(Node node) {
        Node parent = node.getParent();
        Node rightChild = node.getRight();

        node.setRight(rightChild.getLeft());

        if (rightChild.getLeft() != null) {
            rightChild.getLeft().setParent(node);
        }
        rightChild.setLeft(node);
        node.setParent(rightChild);
        changeReferences(parent, node, rightChild);
    }

    private void rotateRight(Node node) {
        Node parent = node.getParent();
        Node leftChild = node.getLeft();

        node.setLeft(leftChild.getRight());

        if (leftChild.getRight() != null) {
            leftChild.setParent(node);
        }
        leftChild.setRight(node);
        node.setParent(leftChild);
        changeReferences(parent, node, leftChild);

    }

    private void changeReferences(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
            this.raiz = newChild;
        } else if (oldChild == parent.getRight()) {// Verifica se o antigo filho é referenciado na subárvore direita
            parent.setRight(newChild);// Muda a referência da subárvore direita do pai para o novo nó

        } else if (oldChild == parent.getLeft()) {// Verifica se o antigo filho é referenciado na subárvore esquerda
            parent.setLeft(newChild);// Muda a referência da subárvore esquerda do pai para o novo nó

        }
        if (newChild != null) {// Caso o novo nó Não seja nulo, a referência para o pai do nó agora é o novo
                               // pai
            newChild.setParent(parent);
        }

    }
}
