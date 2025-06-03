package session;

import model.User;

public class Session {

    private static User currentUser;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isLogin() {
        return currentUser != null;
    }

    public static void logout() {
        currentUser = null;
    }
}
