package model;

public class Admin extends User {

    public Admin(String fullName, String username, String email, String jenisKelamin, String password) {
        super(fullName, username, email, jenisKelamin, password, "ADMIN");
    }
}
