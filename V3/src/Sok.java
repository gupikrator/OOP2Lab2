package kafic;

public class Sok extends Pice {
	
	public enum Vrsta {
		GAZIRAN,
		NEGAZIRAN
	}
	
	private Vrsta v;

	public Sok(String naziv, double zapremina, int cena, Sok.Vrsta vrsta) {
		super(naziv, zapremina, cena);
		this.v = vrsta;
		if (v == Vrsta.GAZIRAN) {
			this.oznaka = 'G';
		}
		else {
			this.oznaka = 'N';
		}
	}

	public Vrsta getVrsta() {
		return this.v;
	}
	

}
