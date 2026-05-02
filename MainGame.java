// 1. Class: Template atau blueprint untuk membuat objek.
// 2. Object: Instansiasi nyata dari sebuah class.
// 3. Encapsulation: Menyembunyikan detail data dengan modifier private dan menyediakan getter/setter.
// 4. Inheritance: Pewarisan sifat dari superclass ke subclass.
// 5. Polymorphism: Kemampuan objek untuk mengambil berbagai bentuk (method overriding/overloading).
// 6. Abstraction: Menyembunyikan detail implementasi, hanya menampilkan fungsionalitas esensial.

// Abstraction (Poin 6): Menggunakan abstract class
abstract class KarakterGame {
    // Encapsulation (Poin 3): Menggunakan access modifier private untuk variabel
    private String nama;
    private int level;
    private int healthPoint;

    // Constructor
    public KarakterGame(String nama, int level, int healthPoint) {
        this.nama = nama;
        this.level = level;
        this.healthPoint = healthPoint;
    }

    // Encapsulation: Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getLevel() {
        return level;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    // Abstraction: Abstract method yang detailnya disembunyikan dan harus diimplementasikan oleh subclass
    public abstract void serang();

    // Method umum
    public void infoKarakter() {
        System.out.println("Nama: " + nama + " | Level: " + level + " | HP: " + healthPoint);
    }
}

// Inheritance (Poin 4): Class Ksatria mewarisi class KarakterGame (Poin 1: Class)
class Ksatria extends KarakterGame {
    private int kekuatanPedang;

    public Ksatria(String nama, int level, int healthPoint, int kekuatanPedang) {
        super(nama, level, healthPoint);
        this.kekuatanPedang = kekuatanPedang;
    }

    // Polymorphism (Poin 5): Method Overriding (menimpa method abstrak dari superclass)
    @Override
    public void serang() {
        System.out.println(getNama() + " menyerang dengan pedang! Damage: " + kekuatanPedang);
    }

    // Polymorphism: Method Overloading (nama method sama, parameter berbeda)
    public void serang(KarakterGame musuh) {
        System.out.println(getNama() + " menebas " + musuh.getNama() + " dengan pedang ganda!");
    }
}

// Inheritance (Poin 4): Class Penyihir mewarisi class KarakterGame
class Penyihir extends KarakterGame {
    private int kekuatanSihir;

    public Penyihir(String nama, int level, int healthPoint, int kekuatanSihir) {
        super(nama, level, healthPoint);
        this.kekuatanSihir = kekuatanSihir;
    }

    // Polymorphism (Poin 5): Method Overriding
    @Override
    public void serang() {
        System.out.println(getNama() + " menembakkan bola api! Damage: " + kekuatanSihir);
    }
    
    // Polymorphism: Method Overloading (Tambahan aksi unik)
    public void sembuhkan(KarakterGame target) {
        int heal = kekuatanSihir / 2;
        target.setHealthPoint(target.getHealthPoint() + heal);
        System.out.println(getNama() + " menyembuhkan " + target.getNama() + " sebesar " + heal + " HP.");
    }
}

// Class Utama
public class MainGame {
    public static void main(String[] args) {
        System.out.println("=== Simulasi Karakter Game OOP ===\n");

        // Object (Poin 2): Membuat instance dari class Ksatria dan Penyihir
        Ksatria arthur = new Ksatria("Arthur", 10, 500, 75);
        Penyihir merlin = new Penyihir("Merlin", 12, 300, 100);

        // Menampilkan Info
        System.out.println("-- Info Karakter Awal --");
        arthur.infoKarakter();
        merlin.infoKarakter();

        // Menggunakan method hasil Polymorphism (Overriding)
        System.out.println("\n-- Aksi Serangan --");
        arthur.serang();
        merlin.serang();

        // Menggunakan method hasil Polymorphism (Overloading)
        System.out.println("\n-- Aksi Khusus --");
        arthur.serang(merlin);
        merlin.sembuhkan(arthur);

        // Menampilkan Info setelah aksi
        System.out.println("\n-- Info Karakter Akhir --");
        arthur.infoKarakter();
        merlin.infoKarakter();
    }
}
