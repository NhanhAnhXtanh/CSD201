/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csd201_node;

public class Node {

    Student info;
    Node next;

    public Node() {

    }

    public Node(Student x ) {
        this.info = x;
        next = null;
    }

    public Node(Student x, Node next) {
        this.info = x;
        this.next = next;
    }

}
