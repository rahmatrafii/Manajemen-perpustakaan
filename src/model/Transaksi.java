package model;

import java.util.UUID;

public class Transaksi {

    private String idTransaksi;
    private String idAnggota;
    private String namaAnggota;
    private String isbnBuku;
    private String judulBuku;
    private String tanggalPinjam;
    private String tanggalJatuhTempo;
    private String tanggalKembali;
    private String status;

    // Constructor
    public Transaksi(String idAnggota, String namaAnggota,
            String isbnBuku, String judulBuku, String tanggalPinjam,
            String tanggalJatuhTempo, String tanggalKembali, String status) {
        this.idTransaksi = UUID.randomUUID().toString();;
        this.idAnggota = idAnggota;
        this.namaAnggota = namaAnggota;
        this.isbnBuku = isbnBuku;
        this.judulBuku = judulBuku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.tanggalKembali = tanggalKembali;
        this.status = status;
    }

    // Getter methods
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public String getIsbnBuku() {
        return isbnBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public String getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String date) {
        this.tanggalKembali = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
