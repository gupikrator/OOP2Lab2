package kafic;

public class Pivo extends Pice {
	
	int kolicinaAlkohola;

	public Pivo(String naziv, double zapremina, int cena, int alk) {
		super(naziv, zapremina, cena);
		this.kolicinaAlkohola = alk;
		this.oznaka = 'P';
	}
	
	

}
