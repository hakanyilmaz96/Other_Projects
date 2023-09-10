package pdpodev3;

import java.util.Random;

public class Yaytaktigi extends Taktik {
    
	//Bu savaş taktiğinde 500-1000 arası rastgele değer döndürülüyor
	public Yaytaktigi() {
        Random random = new Random();
        this.taktikDegeri = random.nextInt(501) + 500;

    }

    public void savas(Koloni koloni) {
        koloni.setTaktik(this.taktikDegeri);

    }
}
