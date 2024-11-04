package kafic;

public class Pice {
	
	String naziv;
	double zapremina;
	int cena;
	char oznaka;
	
	public Pice(String naziv, double zapremina, int cena) {
		super();
		this.naziv = naziv;
		this.zapremina = zapremina;
		this.cena = cena;
	}
	public String getNaziv() {
		return naziv;
	}
	public double getZapremina() {
		double scale = Math.pow(10, 1);
	    return Math.round(zapremina * scale) / scale;
	}
	public double getCena() {
		double c = cena * zapremina;
		double scale = Math.pow(10, 1);
		return Math.round(c * scale) / scale;
	}
	public char getOznaka() {
		return oznaka;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv);
		sb.append("(");
		sb.append(String.format("%.2f", zapremina));
		sb.append(" L): ");
		double ukupnaCena = zapremina * cena;
		sb.append(String.format("%.2f", ukupnaCena));
		sb.append(" RSD");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object p) {
		if(p instanceof Pice) {
			Pice p1 = (Pice) p;
			if (p1.naziv.equals(this.naziv) && p1.zapremina == this.zapremina) {
				return true;
			}
		}
		else {
			return false;
		}
		return false;
	}
		
		
}
