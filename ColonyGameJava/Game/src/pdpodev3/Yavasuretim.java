package pdpodev3;

import java.util.Random;

public class Yavasuretim extends Uretim {
    
	//Bu üretim taktiğinde 5-10 arası bir üretim yapılıyor
	public Yavasuretim() {
        Random random = new Random();
        this.uretimDegeri = random.nextInt(6) + 5; 

    }

    public void uretimYap(Koloni koloni) {
        koloni.setUretim(this.uretimDegeri);

    }
}

