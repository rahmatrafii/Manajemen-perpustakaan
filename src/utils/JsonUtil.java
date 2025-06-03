package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

import model.Admin;
import model.Anggota;
import model.User;
import validation.AuthValidation;

public class JsonUtil {

    public static boolean tambahUser(Anggota anggota) {
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

    public static boolean tambahUser(Admin admin) {
        try {
            String file = "src/data/users.json";
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Admin> data = gson.fromJson(fr, new TypeToken<List<Admin>>() {
            }.getType());

            data.add(admin);
            FileWriter fw = new FileWriter(file);
            gson.toJson(data, fw);
            fw.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String cekUserYangSama(String username, String email) {
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

    public static User getUser(String username) {
        String file = "src/data/users.json";
        try {
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Anggota> data = gson.fromJson(fr, new TypeToken<List<Anggota>>() {
            }.getType());

            if (data != null) {
                for (Anggota anggota : data) {
                    if (username.equals(anggota.getUsername())) {
                        return anggota;
                    }
                }
            }

            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
