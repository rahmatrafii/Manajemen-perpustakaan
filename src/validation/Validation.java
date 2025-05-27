package validation;

public abstract class Validation {

    // Validasi input umum (digunakan oleh form lain juga)
    protected boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    protected boolean isValidEmail(String email) {
        // Pola email sederhana
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }

    protected boolean isPassword(String password) {
        // Minimal 6 karakter, huruf & angka
        return password != null && password.length() >= 6;
    }

    protected boolean isValidGender(String gender) {
        return gender != null && (gender.equalsIgnoreCase("Laki-laki") || gender.equalsIgnoreCase("Perempuan"));
    }

    // Method abstract yang wajib diimplementasikan di subclass
    public abstract String validateRegistration(
            String fullName,
            String username,
            String email,
            String jenisKelamin,
            String password
    );

    public abstract String validateLogin(String username, String password);
}
