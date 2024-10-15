package treedemo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MyBSTree bstree = new MyBSTree();
        int[] b = {25, 20, 36, 10, 22, 30, 40, 5, 12, 28,38,  48, 1, 8, 15, 45, 50};
        bstree.insertMany(b);
        int value  = 22;
        Node node = bstree.searchFirstBothChildByBreadth(value); // node thay doi
        
        bstree.rotateRight(node);
        bstree.breadth();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        int[] a = {10, 6, 15, 4, 8, 12, 19, 2, 5, 7, 9, 11, 14, 17, 20, 1, 3, 13, 16, 18, 21, 0, 22};
//        System.out.println("PreOrder (NLR) BSTree");
//        bstree.preOrder(bstree.root);
//        System.out.println();
//        System.out.println("InOrder (LNR) BSTree");
//        bstree.inOrder(bstree.root);
//        System.out.println();
//        System.out.println("PostOrder (LRN) BSTree");  3 7 2 20 15 10 4
//        bstree.postOrder(bstree.root);
//        System.out.println();
//        bstree.breadth();
//        System.out.println();
//        System.out.println("--------------Array before start---------------");
//        bstree.breadth();
//        System.out.println();
//
//        
//        System.out.println("Delete by merging: leaf node 3");
//        bstree.deleteByMerging(3);
//        bstree.breadth();
//        System.out.println();
//        
//        
//        System.out.println("Delete by merging: leaf node 7");
//        bstree.deleteByMerging(7);
//        bstree.breadth();
//        System.out.println();
//        
//        
//        System.out.println("Delete by merging: node has only one left child 2");
//        bstree.deleteByMerging(2);
//        bstree.breadth();
//        System.out.println();
//        
//        
//        System.out.println("Delete by merging: node has only one right child 20");
//        bstree.deleteByMerging(20);
//        bstree.breadth();
//        System.out.println();
//        
//        
//        System.out.println("Delete by merging: node has both left and right child 15");
//        bstree.deleteByMerging(15);
//        bstree.breadth();
//        System.out.println();
//        
//        
//        System.out.println("Delete by merging: node has both left and right child 10(root)");
//        bstree.deleteByMerging(10);
//        bstree.breadth();
//        System.out.println();
//        
//        
//        System.out.println("Delete by merging: node has both left and right child 4");
//        bstree.deleteByMerging(4);
//        bstree.breadth();
//        System.out.println();
////        
//        System.out.println();
//        System.out.println("---------------Array before start------------------");
//        bstree.breadth();
//        System.out.println();
//
//        System.out.println("Delete by copying: leaf node 3");
//        bstree.deleteByCopying(3);
//        bstree.breadth();
//        System.out.println();
//
//        System.out.println("Delete by copying: leaf node 7");
//        bstree.deleteByCopying(7);
//        bstree.breadth();
//        System.out.println();
//
//        System.out.println("Delete by copying: node has only one left child 2");
//        bstree.deleteByCopying(2);
//        bstree.breadth();
//        System.out.println();
//
//        System.out.println("Delete by copying: node has only one right child 20");
//        bstree.deleteByCopying(20);
//        bstree.breadth();
//        System.out.println();
//
//        System.out.println("Delete by copying: node has both left and right child 15");
//        bstree.deleteByCopying(15);
//        bstree.breadth();
//        System.out.println();
//
//        System.out.println("Delete by copying: node has both left and right child 10(root)");
//        bstree.deleteByCopying(10);
//        bstree.breadth();
//        System.out.println();
//
//        System.out.println("Delete by merging: node has both left and right child 4");
//        bstree.deleteByCopying(4);
//        bstree.breadth();
//        System.out.println();
//        int a[] = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
//        bstree.insertMany(a);
//
//        bstree.balance();
//        bstree.breadth();
//        System.out.println("");
    }
}
