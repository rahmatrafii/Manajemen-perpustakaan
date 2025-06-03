package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Anggota;
import utils.JsonUtil;
import validation.AuthValidation;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class AuthService {
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
        String role = "ANGGOTA";
        AuthValidation validate = new AuthValidation();
        String err;

        err = validate.validateRegistration(fullName, userName, email, jenisKelamin, password);

        if (err != null) {
            return err;
        }

        err = JsonUtil.cekUserYangSama(userName, email);
        if (err != null) {
            return err;
        }

        Anggota user = new Anggota(fullName, userName, email, jenisKelamin, role, password);

        boolean res = JsonUtil.tambahUser(user);

        if (!res) {
            return "Something went wrong!";
        }

        return null;
    }
}
