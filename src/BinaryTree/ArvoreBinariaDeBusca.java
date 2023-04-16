package BinaryTree;

public class ArvoreBinariaDeBusca {
    public Node raiz;

    public void put(int number) {
        raiz = put(null, raiz, number);
    }

    Node put(Node parent, Node node, Integer number) {
        if (node == null) {
            node = new Node(number);
            node.setParent(parent);
            return node;
        } else if (number < node.getKey()) {
            parent = node;
            node.setLeft(put(parent, node.getLeft(), number));
        } else if (number > node.getKey()) {
            node.setRight(put(parent, node.getRight(), number));
        } else {
            System.out.println("Repeated");
        }
        return node;
    }

    public void inOrder() {
        inOrder(raiz);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root);
        inOrder(root.getRight());
    }

    public void deletar(int number) {
        if (raiz != null) {
            raiz = deletar(raiz, number);
        } else
            System.out.println("Empty!");
    }

    Node deletar(Node node, Integer number) {
        if (node != null) {
            if (node.getKey() == number) {
                if (node.getLeft() == null && node.getRight() == null)
                    node = null;
                else if (node.getLeft() == null)
                    node = node.getRight();
                else if (node.getRight() == null)
                    node = node.getLeft();
                else {
                    Node sucessor = maximo(node.getLeft());
                    node.setKey(sucessor.getKey());
                    node.setLeft(deletar(sucessor, sucessor.getKey()));

                }
            } else if (node.getKey() > number) {
                node.setLeft(deletar(node.getLeft(), number));
            } else
                node.setRight(deletar(node.getRight(), number));
        }
        return node;
    }

    private Node minimo(Node no) {
        if (no.getLeft() == null) {
            return no;
        }
        return minimo(no.getLeft());
    }

    private Node maximo(Node no) {
        if (no.getRight() == null)
            return no;
        return maximo(no.getRight());
    }

    public Node getRaiz() {
        return raiz;
    }

    public void preOrder() {
        inOrder(raiz);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root);
        inOrder(root.getLeft());
        inOrder(root.getRight());
    }

}
