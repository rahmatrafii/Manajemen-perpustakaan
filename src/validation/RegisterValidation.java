package validation;

public interface RegisterValidation {
    public boolean isValidUsername(String username);
    public boolean isValidPassword(String password);
    public boolean isValidEmail(String email);
    public boolean isValidGender(String gender);
    public boolean isValidFullName(String fullName);
}
