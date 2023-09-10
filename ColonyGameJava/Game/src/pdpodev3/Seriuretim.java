package pdpodev3;

import java.util.Random;

public class Seriuretim extends Uretim {

    //Bu üretim taktiğinde 1-5 arası bir üretim yapılıyor
	public Seriuretim() {
        Random random = new Random();
        this.uretimDegeri = random.nextInt(6); 

    }

    public void uretimYap(Koloni koloni) {
        koloni.setUretim(this.uretimDegeri);

    }

}
