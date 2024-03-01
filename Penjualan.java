public class Penjualan {
    private String nama_produk;
    private int quantity;
    private int harga_total;
    private int harga_satuan;

    public void setHarga_satuan(int harga_satuan) {
        this.harga_satuan = harga_satuan;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getHarga_total() {
        harga_total = harga_satuan*quantity;
        return harga_total;
    }
}
