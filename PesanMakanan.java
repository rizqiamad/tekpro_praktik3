import java.util.Scanner;

public class PesanMakanan {
    private Scanner scan = new Scanner(System.in);
    private String pesanan;
    private String determ;
    private String firstLetter;
    private boolean pesananDitemukan;
    private boolean check = false;
    private int qty;
    private int id_penjualan = 0;
    private int id_produk;
    private int total_pembelian = 0;
    private byte checker = 1;
    private Produk[] produk = new Produk[10];
    private Penjualan[] penjualan = new Penjualan[5];

    public PesanMakanan() {

        for (int i = 0; i < 5; i++) {
            penjualan[i] = new Penjualan();
        }

        // mendefine menu
        produk[0] = new Produk("Pangyam", 5000, 10);
        produk[1] = new Produk("Ramen", 15000, 10);
        produk[2] = new Produk("Sosis", 10000, 10);
        produk[3] = new Produk("Mie", 14000, 10);
        produk[4] = new Produk("Pizza", 50000, 10);
        produk[5] = new Produk("Burger", 25000, 10);
        produk[6] = new Produk("Hotdog", 25000, 10);
        produk[7] = new Produk("Udon", 51000, 10);
        produk[8] = new Produk("Dimsum", 8000, 10);
        produk[9] = new Produk("Kue", 10000, 10);
    }

    public void Order() {
        System.out.println("Ingin Pesan Makanan?  Y / N");

        checkPesanMakanan();
        if (checker == 0) {
            System.out.println("Baik terimakasih telah hadir di rumah makan kami");
            System.exit(0);
        }
        menuShow();
        do {

            System.out.println("Silahkan tulis nama makanan yang ingin anda pesan");
            System.out.println("-------------------------------------------------");
            definePesanan();
            System.out.println("Berapa banyak yang ingin anda pesan?");
            System.out.println("-----------------------------------");
            askQuantity();
            System.out.println("terimakasih, pesanan anda akan kami proses");
            System.out.println("Apakah anda ingin memesan makanan lainnya? Y/N");
            System.out.println("----------------------------------------------");
            checkPesanMakanan();
            if (checker == 0) {
                System.out.println("Baik, jika begitu silahkan menunggu");
                printBill();
            }
            id_penjualan++;
        } while (checker == 1);
    }

    private void definePesanan() {
        pesananDitemukan = false;
        while (!pesananDitemukan) {
            pesanan = scan.nextLine();
            firstLetter = pesanan.substring(0, 1).toUpperCase();
            pesanan = pesanan.replace(pesanan.substring(0, 1), firstLetter);

            for (int i = 0; i < 10; i++) {
                if (pesanan.equals(produk[i].getNama_produk())) {
                    id_produk = i;
                    penjualan[id_penjualan].setNama_produk(pesanan);
                    penjualan[id_penjualan].setHarga_satuan(produk[id_produk].getHarga_produk());
                    pesananDitemukan = true;
                }
            }
            if (!pesananDitemukan) {
                System.out.println("Dimohon untuk menuliskan nama sesuai menu yang ada");
            }
        }
    }

    //Menanyakan kepada pemesan mengenai jumlah pesanan
    private void askQuantity() {
        do {

            qty = scan.nextInt();
            penjualan[id_penjualan].setQuantity(qty);
            //jika pemesan memilih lebih dari barang tersedia, maka pemesan diminta untuk mengulangi jumlah pesanan
            if (penjualan[id_penjualan].getQuantity() > produk[id_produk].getQty()) {
                System.out.println(
                        "Maaf makanan yang anda pesan tidak tersedia sebanyak itu, silahkan pesan sebanyak yang tersdia");
            } else {
                check = false;
            }
            produk[id_produk].setDecreaseQty(penjualan[id_penjualan].getQuantity());
        } while (check);
    }

    // Memberikan informasi mengenai transaksi yang sudah dilakukan
    private void printBill() {
        System.out.println("=============================================");
        System.out.println("Berikut detail pemesanan anda");
        System.out.println("=============================================");
        for (int i = 0; i <= id_penjualan; i++) {

            System.out.println("Makanan Pesanan anda \t:\t " + penjualan[i].getNama_produk());
            System.out.println("Banyaknya pembelian \t:\t " + penjualan[i].getQuantity());
            System.out.println("Total Harga \t\t:\t Rp. " + penjualan[i].getHarga_total());
            System.out.println("---------------------------------------------");
        }
        //menjumlahkan harga semua total pesanan pemesan
        for (int i = 0; i <= id_penjualan; i++) {
            total_pembelian += penjualan[i].getHarga_total();
        }
        //menulis ke sistem total pembelian
        System.out.println("total pembelian \t:\t Rp. "+total_pembelian);
        System.exit(0);
    }

    // Pemesan diberikan pilihan untuk memesan atau tidak
    private void checkPesanMakanan() {
        while (!check) {
            determ = scan.nextLine();
            if (determ.equalsIgnoreCase("Y")) {
                check = true;
                scan.close();
            } else if (determ.equalsIgnoreCase("N")) {
                check = true;
                checker = 0; // Checker mewakili apakah pemilih memilih Y atau N
            } 
            // else if(!(determ==null)){
            //     System.out.println("Pilihlah pilihan yang tersedia!!!");
            // }
        }
    }

    // Prosedur untuk menampilkan semua menu yang tersedia
    public void menuShow() {
        
        System.out.println("Daftar Menu Makanan Yang Tersedia");
        System.out.println("====================================================================");
        System.out.println("Nama\t\t\tHarga\t\t\tBarang Tersedia");
        System.out.println("--------------------------------------------------------------------");
        // for looping untuk menampilkan semua menu ke dalam sistem
        for (int i = 0; i < 10; i++) {

            System.out.println(
                    produk[i].getNama_produk() + "\t\t\t" + "Rp. " + produk[i].getHarga_produk() + "\t\t\t"
                            + produk[i].getQty());
        }
        System.out.println("--------------------------------------------------------------------");
    }
}
