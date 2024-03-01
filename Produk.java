public class Produk {
    private String nama_produk;
    private int harga_produk;
    private int qty;

    public void setDecreaseQty(int qty) {
        this.qty -= qty;
    }

    public Produk(String nama, int harga, int qty){
        this.nama_produk = nama;
        this.harga_produk = harga;
        this.qty = qty;
    }

    public String getNama_produk() {
        return this.nama_produk;
    }

    public int getHarga_produk() {
        return this.harga_produk;
    }

    public int getQty() {
        return this.qty;
    }
}
