
/*
 * Ad Soyad: Yusuf Aslan
 * Ogrenci No: 250541068
 * Tarih: 06.11.2025
 * Aciklama: Gorev 3 - Maas Hesap
 *
 * Bu program kullanicidan ad soyad,aylık büret maaş,haftalık çalışma saati ve mesai saatini alir ve
 * MAAS BADROSU'nu çıkartır
 */


import java.util.Scanner;

public class MaasBordrosu {

    public static void main(String[] args) {
        // Sabit oranlar
        final double SGK_ORANI = 0.14;
        final double GELIR_VERGISI_ORANI = 0.15;
        final double DAMGA_VERGISI_ORANI = 0.00759;
        
        // Kullanıcıdan verileri almak için Scanner
        Scanner scanner = new Scanner(System.in);
        
        // Kullanıcıdan giriş verilerini almak
        System.out.print("Çalışan Adı Soyadı: ");
        String calisanAdiSoyadi = scanner.nextLine();
        
        System.out.print("Aylık Brüt Maaş (TL): ");
        double brutMaas = scanner.nextDouble();
        
        System.out.print("Haftalık Çalışma Saati: ");
        int haftalikCalismaSaati = scanner.nextInt();
        
        System.out.print("Mesai Saati Sayısı: ");
        int mesaiSaati = scanner.nextInt();
        
        // Hesaplamalar
        // Mesai ücreti
        double mesaiUcreti = (brutMaas / 160) * mesaiSaati * 1.5;
        
        // Toplam gelir
        double toplamGelir = brutMaas + mesaiUcreti;
        
        // Kesintiler
        double sgkKesintisi = toplamGelir * SGK_ORANI;
        double gelirVergisi = toplamGelir * GELIR_VERGISI_ORANI;
        double damgaVergisi = toplamGelir * DAMGA_VERGISI_ORANI;
        
        // Toplam kesinti
        double toplamKesinti = sgkKesintisi + gelirVergisi + damgaVergisi;
        
        // Net maaş
        double netMaas = toplamGelir - toplamKesinti;
        
        // İstatistikler
        double kesintiOrani = (toplamKesinti / toplamGelir) * 100;
        double saatlikNetKazanc = netMaas / 176; // 22 gün * 8 saat = 176 saat
        double gunlukNetKazanc = netMaas / 22; // 22 gün
        
        // Çıktıyı formatlı şekilde yazdırma
        System.out.println("\n====================================");
        System.out.println("MAAS BORDROSU");
        System.out.println("====================================");
        System.out.println("Çalışan: " + calisanAdiSoyadi);
        
        System.out.println("\nGELIRLER:");
        System.out.printf("Brüt Maaş : %.2f TL\n", brutMaas);
        System.out.printf("Mesai Ücreti (%d saat) : %.2f TL\n", mesaiSaati, mesaiUcreti);
        System.out.println("-----------------------------");
        System.out.printf("TOPLAM GELİR : %.2f TL\n", toplamGelir);
        
        System.out.println("\nKESINTİLER:");
        System.out.printf("SGK Kesintisi (%.1f%%) : %.2f TL\n", SGK_ORANI * 100, sgkKesintisi);
        System.out.printf("Gelir Vergisi (%.1f%%) : %.2f TL\n", GELIR_VERGISI_ORANI * 100, gelirVergisi);
        System.out.printf("Damga Vergisi (%.1f%%) : %.2f TL\n", DAMGA_VERGISI_ORANI * 100, damgaVergisi);
        System.out.println("-----------------------------");
        System.out.printf("TOPLAM KESİNTİ : %.2f TL\n", toplamKesinti);
        
        System.out.printf("\nNET MAAŞ : %.2f TL\n", netMaas);
        System.out.println("====================================");
        
        // İstatistikler
        System.out.println("\nİSTATİSTİKLER:");
        System.out.printf("Kesinti Oranı : %.1f%%\n", kesintiOrani);
        System.out.printf("Saatlik Net Kazanç : %.2f TL\n", saatlikNetKazanc);
        System.out.printf("Günlük Net Kazanç : %.2f TL\n", gunlukNetKazanc);
        System.out.println("====================================");
        
        scanner.close();
    }
}

