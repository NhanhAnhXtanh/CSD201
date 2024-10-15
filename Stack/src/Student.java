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
        return "Student[" + "sid=" + sid + ",   name=" + name + ",   mark=" + mark + ']';
    }
}
