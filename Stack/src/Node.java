/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Node {

    Student info;
    Node next;

    public Node() {

    }

    public Node(Student info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Student info) {
        this(info, null);
    }
}
