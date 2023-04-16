import BinaryTree.*;

public class App {
    public static void main(String[] args) throws Exception {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.put(12);
        redBlackTree.put(10);
        redBlackTree.put(30);
        redBlackTree.put(90);
        redBlackTree.put(4);
        redBlackTree.put(28);
        
        redBlackTree.preOrder();
        System.out.println(redBlackTree.getRaiz());

    }
}
