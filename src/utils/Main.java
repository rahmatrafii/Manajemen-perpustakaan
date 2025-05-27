/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import model.Book;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {
        Book book = new Book("123", "rafi", "rafi", "rafi", 2004, true, 1, "12-juli-2002", "hibah");
        
        UserAksi.tambahBuku(book);
    }

}
