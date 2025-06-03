package model;

import java.util.UUID;

public abstract class User {

    private String id;
    private String fullName;
    private String username;
    private String email;
    private String jenisKelamin;
    private String password;
    private String role;

    public User(String fullName, String username, String email, String jenisKelamin, String password, String role) {
        if (role.equals("ADMIN")) {
            setId("AD");
        } else {
            setId();
        }
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.jenisKelamin = jenisKelamin;
        this.password = password;
        this.role = role;
    }

    private void setId() {
        String uniqID = UUID.randomUUID().toString();
        this.id = uniqID;
    }

    private void setId(String kode) {
        String uniq = UUID.randomUUID().toString();
        String adId = kode + "-" + uniq;
        this.id = adId;
    }

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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

}
