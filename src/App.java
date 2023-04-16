import BinaryTree.*;

public class App {
    public static void main(String[] args) throws Exception {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.put(12);
        redBlackTree.put(10);
        System.out.println(redBlackTree.getRaiz());
        System.out.println(redBlackTree.getRaiz().getLeft());
        System.out.println(redBlackTree.getUncle(redBlackTree.getRaiz()));
    }
}
