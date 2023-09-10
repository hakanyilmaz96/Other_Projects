package pdpodev3;

import java.util.Random;

public class Oktaktigi extends Taktik {
    
	//Bu savaş taktiğinde 1-500 arası rastgele değer döndürülüyor
	public Oktaktigi() {
        Random random = new Random();
        this.taktikDegeri = random.nextInt(501);
    }

    public void savas(Koloni koloni) {
        koloni.setTaktik(this.taktikDegeri);

    }
}

