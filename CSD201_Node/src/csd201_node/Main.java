/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csd201_node;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        MyList my = new MyList();
        my.addLast(5);
        my.addLast(4);
        my.addLast(6);
        my.addLast(3);
        my.addLast(2);
        my.addLast(9);
        Node p = my.getIndex(1);
        Node q = my.getIndex(4);
        my.selectionSort(p, q);
        my.display();
    }
}
