package penjualan.entity;

public class pelangganEntity {
    private int id_pelanggan;
    private String nama_pelanggan;
    private String jenis_kelamin;
    private String alamat;
    private String no_telepon;
    private String idpel = String.valueOf(id_pelanggan);

    public String getIdpelanggan() {
        return idpel;
    }
    public void setIdpelanggan(String idpel) {
        this.idpel = idpel;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }
    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telepon() {
        return no_telepon;
    }
    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }
}