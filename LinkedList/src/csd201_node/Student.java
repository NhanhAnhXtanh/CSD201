package csd201_node;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class Student {

    String sid;
    String name;
    double mark;

    public Student(String sid, String name, double mark) {
        this.sid = sid;
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student" + " ID = " + sid + "     Name = " + name + "     Mark = " + mark + ']';
    }

    public String toString2() {
        return String.format("%-10s%-15%s%-15f\n", sid, name, mark);
    }
}
