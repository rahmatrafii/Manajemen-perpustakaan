package model;

public class Book {

    private String isbn;
    private String judul;
    private String penulis;
    private String penerbit;
    private int tahunTerbit;
    private boolean tersedia;
    private Integer jumlahPeminjaman;
    private String tanggalDitambahkan;
    private String sumber;

    public Book(String isbn, String judul, String penulis, String penerbit, Integer tahunTerbit, boolean tersedia, Integer jumlahPeminjaman, String tanggalDitambahkan, String sumber) {
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.tersedia = tersedia;
        this.jumlahPeminjaman = jumlahPeminjaman;
        this.tanggalDitambahkan = tanggalDitambahkan;
        this.sumber = sumber;
    }

    public String getJudul() {
        return judul;
    }
    public boolean isTersedia () {
        return tersedia;
    }
    public void setTersedia(boolean kondisi) {
        this.tersedia = kondisi;
    }

    public String getISBN() {
        return isbn;

    }
}
