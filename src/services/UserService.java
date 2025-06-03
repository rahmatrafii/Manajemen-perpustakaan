package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Book;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public static List<Book> ambilSemuaBuku() {
        try {
            String file = "src/data/book.json";
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Book> data = gson.fromJson(fr, new TypeToken<List<Book>>() {
            }.getType());

            return data;
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        return null;
    }

    public static List<Book> cariBuku(String keyword) {
        try {
            String file = "src/data/book.json";
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Book> data = gson.fromJson(fr, new TypeToken<List<Book>>() {
            }.getType());

            if (keyword.isBlank()) {
                return ambilSemuaBuku();
            }

            List<Book> newData = new ArrayList<>();
            if (data != null) {
                for (Book book : data) {

                    if (book.getJudul().toLowerCase().contains(keyword)) {
                        newData.add(book);
                    }
                }
            }

            return newData;
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        return null;
    }
}
