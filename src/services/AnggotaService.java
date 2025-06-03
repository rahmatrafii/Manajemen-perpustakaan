package services;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Book;
import model.Transaksi;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class AnggotaService extends UserService {
    public static List<Transaksi> cekRiwayat(String id) {
       try {
           String file = "src/data/transaction.json";
           Gson gson = new Gson();

           Reader fr = new FileReader(file);
           List<Transaksi> data = gson.fromJson(fr, new TypeToken<List<Transaksi>>() {
           }.getType());
           List<Transaksi> newData = new ArrayList<>();
           if (data != null) {
               for (Transaksi transaksi : data) {
                   if (transaksi.getIdAnggota().equals(id)) {
                       newData.add(transaksi);
                   }
               }
           }

           return newData;
       } catch (Exception e) {
           System.out.println(e);
       }

       return null;
    }
}