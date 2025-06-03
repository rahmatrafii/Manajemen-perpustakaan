package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Anggota;
import model.Book;
import model.Transaksi;

public class BukuService {
    public static List<Transaksi> bukuTerlambatDiKembalikan() {
        try {
            String fileTransaksi = "src/data/transaction.json";
            Gson gson = new Gson();
            Reader frTransaksi = new FileReader(fileTransaksi);
            List<Transaksi> dataTransaksi = gson.fromJson(frTransaksi, new TypeToken<List<Transaksi>>() {
            }.getType());

            List<Transaksi> bukuTerlambat = new ArrayList<>();

            LocalDate tanggalSekarang = LocalDate.now();
            for (Transaksi transaksi : dataTransaksi) {
                LocalDate jatuhTempo = LocalDate.parse(transaksi.getTanggalJatuhTempo());
                if (transaksi.getTanggalKembali().isEmpty() && tanggalSekarang.isAfter(jatuhTempo)) {
                    bukuTerlambat.add(transaksi);
                }
            }

            return bukuTerlambat;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
