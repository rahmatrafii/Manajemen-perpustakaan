package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import model.Anggota;
import validation.AuthValidation;

public class JsonUtil {

    public static String Login(String username, String password) {
        String file = "src/data/users.json";
        AuthValidation validation = new AuthValidation();
        String err;

        err = validation.validateLogin(username, password);

        if (err != null) {
            return err;
        }
        
        try {
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Anggota> data = gson.fromJson(fr, new TypeToken<List<Anggota>>() {
            }.getType());

            if (data != null) {
                for (Anggota anggota : data) {
                    if (username.equals(anggota.getUsername()) && password.equals(anggota.getPassword())) {
                        return null;
                    }
                }
            }

            return "username atau password tidak valid!";
        } catch (Exception e) {
            return "something went wrong";
        }
    }

    public static String register(String fullName, String userName, String email, String jenisKelamin, String password) {
        AuthValidation validate = new AuthValidation();
        String err;

        err = validate.validateRegistration(fullName, userName, email, jenisKelamin, password);

        if (err != null) {
            return err;
        }

        err = sameUserCheck(userName, email);
        if (err != null) {
            return err;
        }

        Anggota user = new Anggota(fullName, userName, email, jenisKelamin, password);

        boolean res = JsonUtil.addUser(user);

        if (!res) {
            return "Something went wrong!";
        }

        return null;
    }

    public static boolean addUser(Anggota anggota) {
        try {
            String file = "src/data/users.json";
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Anggota> data = gson.fromJson(fr, new TypeToken<List<Anggota>>() {
            }.getType());

            data.add(anggota);
            FileWriter fw = new FileWriter(file);
            gson.toJson(data, fw);
            fw.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String sameUserCheck(String username, String email) {
        String file = "src/data/users.json";
        try {
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Anggota> data = gson.fromJson(fr, new TypeToken<List<Anggota>>() {
            }.getType());

            if (data != null) {
                for (Anggota anggota : data) {
                    if (username.equals(anggota.getUsername())) {
                        return "username already used by someone else";
                    } else if (email.equals(anggota.getEmail())) {
                        return "email already in use ";
                    } else {
                        return null;
                    }
                }
            }

            return null;
        } catch (Exception e) {
            return "something is wrong";
        }
    }
}
