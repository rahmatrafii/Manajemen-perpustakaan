package utils;

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

public class UserAksi {

    public static void cariBukuDariDatabase(String keyword) {
        try {
            String file = "src/data/book.json";
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Book> data = gson.fromJson(fr, new TypeToken<List<Book>>() {
            }.getType());
            List<Book> newData = new ArrayList<>();
            if (data != null) {
                for (Book book : data) {
                    if (book.getJudul().toLowerCase().contains(keyword)) {
                        newData.add(book);
                    }
                }
            }

            for (Book book : newData) {
                System.out.println(book.getJudul());
            }
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

    }

    public static boolean tambahBuku(Book book) {
        try {
            String file = "src/data/book.json";
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Book> data = gson.fromJson(fr, new TypeToken<List<Book>>() {
            }.getType());
            data.add(book);
            FileWriter fw = new FileWriter(file);
            gson.toJson(data, fw);
            fw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean hapusBuku(String isbn) {
        try {
            String file = "src/data/book.json";
            Gson gson = new Gson();
            Reader fr = new FileReader(file);
            List<Book> data = gson.fromJson(fr, new TypeToken<List<Book>>() {
            }.getType());

            boolean status = data.removeIf(book -> book.getISBN().equals(isbn));

            if (!status) {
                return false;
            }

            FileWriter fw = new FileWriter(file);
            gson.toJson(data, fw);
            fw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String pinjamBuku(String username, String isbn) {
        try {
            String fileBuku = "src/data/book.json";
            String fileUser = "src/data/users.json";
            String fileTransaksi = "src/data/transaction.json";
            Gson gson = new Gson();
            Reader frBuku = new FileReader(fileBuku);

            List<Book> dataBuku = gson.fromJson(frBuku, new TypeToken<List<Book>>() {
            }.getType());

            String err = null;

            Book buku = null;
            for (Book book : dataBuku) {
                if (book.getISBN().contains(isbn) && book.isTersedia()) {
                    book.setTersedia(false);
                    buku = book;
                    break;
                } else if (book.getISBN().contains(isbn) && !book.isTersedia()) {
                    err = "Buku Sedang dipinjam!";
                    break;
                } else {
                    err = "Buku tidak tersedia";
                    break;
                }
            }

            if (err != null) {
                return err;
            }

            Reader frAnggota = new FileReader(fileUser);
            Reader frTransaksi = new FileReader(fileTransaksi);
            List<Anggota> dataAnggota = gson.fromJson(frAnggota, new TypeToken<List<Anggota>>() {
            }.getType());
            List<Transaksi> dataTransaksi = gson.fromJson(frTransaksi, new TypeToken<List<Transaksi>>() {
            }.getType());

            FileWriter fwBuku = new FileWriter(fileBuku);
            gson.toJson(dataBuku, fwBuku);
            fwBuku.close();

            Anggota anggota = null;
            for (Anggota member : dataAnggota) {
                if (member.getUsername().contains(username)) {
                    anggota = member;
                    break;
                }
            }

            LocalDate tanggalSekarang = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String stringTanggalSekarang = tanggalSekarang.format(formatter);

            LocalDate tujuhHariLagi = tanggalSekarang.plusDays(7);
            String stringTujuHariLagi = tujuhHariLagi.format(formatter);

            Transaksi newTransaksi = new Transaksi(anggota.getId(), anggota.getFullName(), buku.getISBN(), buku.getJudul(), stringTanggalSekarang, stringTujuHariLagi, "", "dipinjam");

            dataTransaksi.add(newTransaksi);
            FileWriter fwTransaksi = new FileWriter(fileTransaksi);
            gson.toJson(dataTransaksi, fwTransaksi);
            fwTransaksi.close();

            return null;
        } catch (Exception e) {
            System.out.println(e);
        }

        return "Something went wrong!";
    }
}
