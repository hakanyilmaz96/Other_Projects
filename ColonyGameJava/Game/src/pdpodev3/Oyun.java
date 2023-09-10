package pdpodev3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Oyun {

    //Kolonilere rastgele taktik belirleyip savaştırmak için fonksiyon
	public static void rastgeleTaktikleSavas(Koloni koloni1, Koloni koloni2) {

        Random random = new Random();

        int rastgeleSayi = random.nextInt(2);
        int rastgeleSayi2 = random.nextInt(2);

        Taktik taktik1;
        Taktik taktik2;

        if (rastgeleSayi == 0) {
            taktik1 = new Oktaktigi();

        } else {
            taktik1 = new Yaytaktigi();

        }

        if (rastgeleSayi2 == 0) {
            taktik2 = new Oktaktigi();

        } else {
            taktik2 = new Yaytaktigi();

        }

        taktik1.savas(koloni1);
        taktik2.savas(koloni2);
    }

    //Kolonilere rastgele üretim yöntemi belirleyip üretim yaptırmak için fonksiyon
	public static void rastgeleUretimYap(Koloni koloni1, Koloni koloni2) {

        Random random = new Random();

        int rastgeleSayi = random.nextInt(2);
        int rastgeleSayi2 = random.nextInt(2);

        Uretim uretim1;
        Uretim uretim2;

        if (rastgeleSayi == 0) {
            uretim1 = new Seriuretim();

        } else {
            uretim1 = new Yavasuretim();

        }

        if (rastgeleSayi2 == 0) {
            uretim2 = new Seriuretim();

        } else {
            uretim2 = new Yavasuretim();

        }

        uretim1.uretimYap(koloni1);
        uretim2.uretimYap(koloni2);
    }


	//Oyun ana fonk.
    public void oyunBaslat(ArrayList<Koloni> koloniler) {

        int turSayisi = 0;
        ArrayList<Koloni> tempKoloniler = new ArrayList<>();
        int koloniSayisi = koloniler.size();

        //Savaş işlemlerinin gerçekleştiği fonksiyon
        while (koloniSayisi > 1) {

            Collections.shuffle(koloniler);

            //Sona 1 koloni kalana kadar savaşları devam ettiriyor
            
            int hayattaKalanKoloniler = 0;
            for (int i = 0; i < koloniSayisi - 1; i++) {
                for (int j = i + 1; j < koloniSayisi; j++) {

                    rastgeleTaktikleSavas(koloniler.get(i), koloniler.get(j));
                    rastgeleUretimYap(koloniler.get(i),koloniler.get(j));


                    koloniler.get(i).setPopulasyon(koloniler.get(i).populasyon+((koloniler.get(i).populasyon*20)/100));
                    koloniler.get(j).setPopulasyon(koloniler.get(j).populasyon+((koloniler.get(j).populasyon*20)/100));

                    koloniler.get(i).setYemekStok(koloniler.get(i).yemekStok+(koloniler.get(i).uretim));
                    koloniler.get(j).setYemekStok(koloniler.get(j).yemekStok+(koloniler.get(j).uretim));

                    koloniler.get(i).setYemekStok(koloniler.get(i).yemekStok-(koloniler.get(i).populasyon*2));
                    koloniler.get(j).setYemekStok(koloniler.get(j).yemekStok-(koloniler.get(j).populasyon*2));



                    if (koloniler.get(i).getTaktik() > koloniler.get(j).getTaktik()) {

                        koloniler.get(j).setPopulasyon((koloniler.get(j).getPopulasyon() - ((koloniler.get(j).getPopulasyon() * (koloniler.get(i).getTaktik() - koloniler.get(j).getTaktik()))) / 1000));
                        int tempYemek = koloniler.get(j).getYemekStok();
                        koloniler.get(j).setYemekStok(koloniler.get(j).getYemekStok() - ((koloniler.get(j).getYemekStok() * (koloniler.get(i).getTaktik() - koloniler.get(j).getTaktik()))) / 1000);
                        koloniler.get(i).setYemekStok(koloniler.get(i).getYemekStok() + tempYemek - koloniler.get(j).getYemekStok());
                        koloniler.get(i).kazanma++;
                        koloniler.get(j).kaybetme++;
                    } else if (koloniler.get(i).getTaktik() < koloniler.get(j).getTaktik()) {

                        koloniler.get(i).setPopulasyon((koloniler.get(i).getPopulasyon() - ((koloniler.get(i).getPopulasyon() * (koloniler.get(j).getTaktik() - koloniler.get(i).getTaktik()))) / 1000));
                        int tempYemek = koloniler.get(i).getYemekStok();
                        koloniler.get(i).setYemekStok(koloniler.get(i).getYemekStok() - ((koloniler.get(i).getYemekStok() * (koloniler.get(j).getTaktik() - koloniler.get(i).getTaktik()))) / 1000);
                        koloniler.get(j).setYemekStok(koloniler.get(j).getYemekStok() + tempYemek - koloniler.get(i).getYemekStok());
                        koloniler.get(j).kazanma++;
                        koloniler.get(i).kaybetme++;
                    } else {
                        if (koloniler.get(i).getPopulasyon() > koloniler.get(j).getPopulasyon()) {

                            koloniler.get(j).setPopulasyon((koloniler.get(j).getPopulasyon() - (koloniler.get(j).getPopulasyon() * 2) / 100));
                            int tempYemek = koloniler.get(j).getYemekStok();
                            koloniler.get(j).setYemekStok(koloniler.get(j).getYemekStok() - (koloniler.get(j).getYemekStok() * 2) / 100);
                            koloniler.get(i).setYemekStok(koloniler.get(i).getYemekStok() + tempYemek - koloniler.get(j).getYemekStok());
                            koloniler.get(i).kazanma++;
                            koloniler.get(j).kaybetme++;
                        } else if (koloniler.get(j).getPopulasyon() > koloniler.get(i).getPopulasyon()) {


                            koloniler.get(i).setPopulasyon((koloniler.get(i).getPopulasyon() - (koloniler.get(i).getPopulasyon() * 2) / 100));
                            int tempYemek = koloniler.get(i).getYemekStok();
                            koloniler.get(i).setYemekStok(koloniler.get(i).getYemekStok() - (koloniler.get(i).getYemekStok() * 2) / 100);
                            koloniler.get(j).setYemekStok(koloniler.get(j).getYemekStok() + tempYemek - koloniler.get(i).getYemekStok());

                            koloniler.get(j).kazanma++;
                            koloniler.get(i).kaybetme++;
                        } else {
                            Random random = new Random();
                            int rastgeleSayi = random.nextInt(2);
                            if (rastgeleSayi == 0) {

                                koloniler.get(j).setPopulasyon((koloniler.get(j).getPopulasyon() - (koloniler.get(j).getPopulasyon() * 2) / 100));
                                int tempYemek = koloniler.get(j).getYemekStok();
                                koloniler.get(j).setYemekStok(koloniler.get(j).getYemekStok() - (koloniler.get(j).getYemekStok() * 2) / 100);
                                koloniler.get(i).setYemekStok(koloniler.get(i).getYemekStok() + tempYemek - koloniler.get(j).getYemekStok());
                                koloniler.get(i).kazanma++;
                                koloniler.get(j).kaybetme++;
                            } else {


                                koloniler.get(i).setPopulasyon((koloniler.get(i).getPopulasyon() - (koloniler.get(i).getPopulasyon() * 2) / 100));
                                int tempYemek = koloniler.get(i).getYemekStok();
                                koloniler.get(i).setYemekStok(koloniler.get(i).getYemekStok() - (koloniler.get(i).getYemekStok() * 2) / 100);
                                koloniler.get(j).setYemekStok(koloniler.get(j).getYemekStok() + tempYemek - koloniler.get(i).getYemekStok());
                                koloniler.get(j).kazanma++;
                                koloniler.get(i).kaybetme++;
                            }
                        }
                    }

                    if (koloniler.get(i).getPopulasyon() <= 4 || koloniler.get(i).getYemekStok() <= 4) {
                        tempKoloniler.add(koloniler.get(i));
                        koloniler.remove(i);
                        koloniSayisi--;
                        i--;
                        break;
                    }else{
                        hayattaKalanKoloniler++;
                    }


                    if (koloniler.get(j).getPopulasyon() <= 4 || koloniler.get(j).getYemekStok() <= 4) {
                        tempKoloniler.add(koloniler.get(j));
                        koloniler.remove(j);
                        koloniSayisi--;
                        j--;
                    }else {
                        hayattaKalanKoloniler++;
                    }



                }

            }

            turSayisi++;


            if (hayattaKalanKoloniler == 1) {
                break;
            }





        }
        koloniler.get(0).kazanan=true;
        
        if(koloniler.get(0).yemekStok < 0)
            koloniler.get(0).setYemekStok(koloniler.get(0).yemekStok*(-1));                                                                                                                                                                                                                                                                                                                                                                                                                            
        
        tempKoloniler.add(koloniler.get(0));

        //Çıktıları alma
       
        Collections.shuffle(tempKoloniler);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Tur Sayisi: "+turSayisi);
        System.out.println("Koloni "+"    "+"Populasyon"+"    "+"Yemek Stogu"+"      "+"Kazanma"+"      "+"Kaybetme");

        for (int i = 0; i < tempKoloniler.size(); i++) {
            if(!tempKoloniler.get(i).kazanan){
                System.out.println("   "+tempKoloniler.get(i).getSembol()+"           "  + "--" + "           " + "--" +"              "  +"--"+"            " +"--");
            }
            else {
                System.out.println("   "+tempKoloniler.get(i).getSembol()+"           "+  tempKoloniler.get(i).getPopulasyon() + "          " + tempKoloniler.get(i).getYemekStok()+"             "+tempKoloniler.get(i).getKazanma()+"            "+tempKoloniler.get(i).getKaybetme());

            }
        }
        System.out.println("------------------------------------------------------------------");


    }




}

