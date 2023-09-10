package pdpodev3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Koloni {
    
	//Koloni yapısı ve rastgele sembol atanması için fonksiyon
	
	public String sembol;
    public int populasyon;
    public int taktik;
    public int uretim;
    public int yemekStok;
    public int kazanma;
    public int kaybetme;
    public boolean kazanan;

    public Koloni(int populasyon) {

        this.sembol = "";
        this.populasyon = populasyon;
        this.taktik = 0;
        this.uretim = 0;
        this.yemekStok = populasyon * populasyon;
        this.kazanma=0;
        this.kaybetme=0;
        this.kazanan=false;
    }

    public static void sembolAta(ArrayList<Koloni> koloniler) {
        int minSymbolCode = 0x41;
        int maxSymbolCode = 0x5A;
        Random rand = new Random();

        Set<Integer> semboller = new HashSet<Integer>();
        while (semboller.size() < koloniler.size()) {
            int sembolKodu = rand.nextInt((maxSymbolCode - minSymbolCode) + 1) + minSymbolCode;
            semboller.add(sembolKodu);
        }

        int i = 0;
        for (Koloni koloni : koloniler) {
            int sembolKodu = (int)semboller.toArray()[i];
            koloni.setSembol(Character.toString((char)sembolKodu));
            i++;
        }
    }

    public String getSembol() {
        return sembol;
    }

    public void setSembol(String sembol) {
        this.sembol = sembol;
    }

    public int getPopulasyon() {
        return populasyon;
    }

    public void setPopulasyon(int populasyon) {
        this.populasyon = populasyon;
    }

    public int getTaktik() {
        return taktik;
    }

    public void setTaktik(int taktik) {
        this.taktik = taktik;
    }

    public int getUretim() {
        return uretim;
    }

    public void setUretim(int uretim) {
        this.uretim = uretim;
    }

    public int getYemekStok() {
        return yemekStok;
    }

    public void setYemekStok(int yemekStok) {
        this.yemekStok = yemekStok;
    }
    public int getKazanma() {
        return kazanma;
    }

    public void setKazanma(int kazanma) {
        this.kazanma = kazanma;
    }
    public int getKaybetme() {
        return kaybetme;
    }

    public void setKaybetme(int kaybetme) {
        this.kaybetme = kaybetme;
    }




}
