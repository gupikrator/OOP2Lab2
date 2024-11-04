package racunari;

public class ProstDeo extends RacunarskiDeo {

	public ProstDeo(String naziv, double m, double o) throws GPogresnaSpecifikacija {
		super(naziv);
		if (o > 5 || o < 1) throw new GPogresnaSpecifikacija();
		if (m <= 0) throw new GPogresnaSpecifikacija();
		this.masa = m;
		this.ocena = o;
	}
	
	@Override
	public ProstDeo clone() throws CloneNotSupportedException {
		ProstDeo p = (ProstDeo)super.clone();
		return p;
	}

}
