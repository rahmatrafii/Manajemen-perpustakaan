/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

/**
 *
 * @author User
 */
public class AuthValidation extends Validation {

    public String validateRegistration(String fullName, String username, String email, String jenisKelamin, String password) {
        if (isNullOrEmpty(fullName)) {
            return "Nama lengkap tidak boleh kosong.";
        }
        if (isNullOrEmpty(username)) {
            return "Username tidak boleh kosong.";
        }
        if (isNullOrEmpty(email) || !isValidEmail(email)) {
            return "Email tidak valid.";
        }
        if (!isValidGender(jenisKelamin)) {
            return "Jenis kelamin harus 'Laki-laki' atau 'Perempuan'.";
        }
        if (!isPassword(password)) {
            return "Password minimal 6 karakter";
        }

        return null; 
    }

    @Override
    public String validateLogin(String username, String password) {
        if (isNullOrEmpty(username)) {
            return "Username tidak boleh kosong.";
        }
        if (!isPassword(password)) {
            return "Password minimal 6 karakter";
        }
        return null; 
    }
}
