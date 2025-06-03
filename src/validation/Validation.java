package validation;

public abstract class Validation implements LoginValidation, RegisterValidation {

    public boolean isValidUsername(String username) {
        return username.length() >= 3;
    }

    public boolean isValidFullName(String fullName) {
        return fullName == null || fullName.trim().isEmpty();
    }

    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public boolean isValidGender(String gender) {
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
