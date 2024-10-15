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
        my.addLast(new Student("HE180002", "Xuan Trien", 10));
        my.addLast(new Student("HE180005", "Nhat Nhu", 8));
        my.addLast(new Student("HE180008", "Duc Anh", 6));
        my.addLast(new Student("HE180011", "Quang Anh", 7));
        my.addIndex(new Student("HE180000", "Nhat Anh", 9), 2);
        my.display();
        System.out.println(my.searchByMark(7).info);
//        my.sortByMark();
        my.sortByName();
        my.display();

    }
}
