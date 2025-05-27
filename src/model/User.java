package model;

import java.util.UUID;

public abstract class User {

    protected String id;
    protected String fullName;
    protected String username;
    protected String email;
    protected String jenisKelamin;
    protected String password;
    protected String role;

    public User(String fullName, String username, String email, String jenisKelamin, String password, String role) {
        this.id = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.jenisKelamin = jenisKelamin;
        this.password = password;
        this.role = role;
    }

    // Enkapsulasi
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }
    public String getJenisKelamin () {
        return jenisKelamin;
    }
    public  String getId() {
        return id;
    }
}
