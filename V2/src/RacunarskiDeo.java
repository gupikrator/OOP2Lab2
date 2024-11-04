package racunari;

import java.text.DecimalFormat;



public class RacunarskiDeo implements Cloneable{
	
	String naziv;
	double ocena;
	double masa;
	
	public RacunarskiDeo(String naziv) {
		super();
		this.naziv = naziv;
	}

	public double dohvatiOcenuKvaliteta() {
		return ocena;
	}

	public double dohvatiMasu() {
		return masa;
	}
	
	@Override
	  public boolean equals(Object p) {
		if(p instanceof ProstDeo) {
			ProstDeo p1 = (ProstDeo) p;
			if(p1.naziv.equals(this.naziv) && p1.masa == this.masa && p1.ocena == this.ocena) {
				return true;
			}
			else {
				return false;
			}
		  }
		return false;
	}
	 

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv);
		sb.append(" (");
		sb.append(String.format("%.2f", masa));
		sb.append("g) ");
		sb.append(String.format("%.1f", ocena));
		return sb.toString();
	}
	
	@Override
	public RacunarskiDeo clone() throws CloneNotSupportedException {
		RacunarskiDeo p = (RacunarskiDeo)super.clone();
		return p;
	}

}
