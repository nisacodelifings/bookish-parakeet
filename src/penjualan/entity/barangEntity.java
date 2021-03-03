package penjualan.entity;

public class barangEntity {
    private String kd_barang;
    private String nama_barang;
    private int stok_barang;
    private double harga_barang;
    private String jml = String.valueOf(stok_barang);
    private String hrg = String.valueOf(harga_barang);

    public String getKd_barang() {
        return kd_barang;
    }
    public void setKd_barang(String kd_barang) {
        this.kd_barang = kd_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }
    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getJumlah() {
        return jml;
    }
    public void setJumlah(String jml) {
        this.jml = jml;
    }

    public String getHarga() {
        return hrg;
    }
    public void setHarga(String hrg) {
        this.hrg = hrg;
    }
}