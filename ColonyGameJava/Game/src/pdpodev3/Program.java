package pdpodev3;

import java.util.ArrayList;
import java.util.Scanner;
public class Program {

    //Girilen sayıları boşluklara göre ayırıp ArrayListe atıyor
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sayilari bosluklu sekilde giriniz: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        ArrayList<Integer> sayilar = new ArrayList<>();
        
        scanner.close();

        for (String number : numbers) {
            sayilar.add(Integer.parseInt(number));
        }

        ArrayList<Koloni> koloniler = new ArrayList<>();

        for (int i=0; i < sayilar.size(); i++){
            Koloni koloni = new Koloni(sayilar.get(i));
            koloniler.add(koloni);
        }

        Koloni.sembolAta(koloniler);

        Oyun oyun = new Oyun();

        oyun.oyunBaslat(koloniler);

    }

}