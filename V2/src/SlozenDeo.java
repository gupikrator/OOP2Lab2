package racunari;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;

public class SlozenDeo extends RacunarskiDeo {
	
	private int brojDelova;
	private ArrayList<ProstDeo> delovi;
	
	public SlozenDeo(String naziv) {
		super(naziv);
		this.ocena = 0;
		this.masa = 0;
		this.brojDelova = 0;
		this.delovi = new ArrayList<>();
	}

	public int brojProstihDelova() {
		return brojDelova;
	}
	
	public void dodaj(ProstDeo p) throws CloneNotSupportedException{
		delovi.add(p.clone());
		brojDelova++;
		this.masa += p.masa;
		this.ocena = (this.ocena * (this.brojDelova-1) + p.dohvatiOcenuKvaliteta()) / brojDelova;
	}
	
	public boolean ukloni(ProstDeo p) {
		for (ProstDeo pt: delovi) {
			if (pt.equals(p)) {
				delovi.remove(p);
				brojDelova--;
				this.masa -= p.masa;
				this.ocena = (this.ocena * (brojDelova+1) - p.ocena) / brojDelova;
				return true;
			}
		}
		return false;
	}
	
	public boolean sadrzi(ProstDeo p){
		for (ProstDeo pt : delovi) {
			if (pt.equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public ProstDeo dohvati(int i) throws GPozicijaVanOpsega {
		if (i < 0 || i > brojDelova - 1) throw new GPozicijaVanOpsega(i);
		return delovi.get(i);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv);
		sb.append(" (");
		sb.append(String.format("%.2f", masa));
		sb.append("g) ");
		sb.append(String.format("%.1f", ocena));
		for (int i = 0; i < brojDelova; i++) {
			sb.append("\n\t");
			sb.append(delovi.get(i));
		}
		return sb.toString();
	}
	
	@Override
	public SlozenDeo clone() throws CloneNotSupportedException {
		SlozenDeo c = (SlozenDeo) super.clone();
		c.delovi = new ArrayList<>();
		for (int i = 0; i < this.brojDelova; i++) {
			c.delovi.add(this.delovi.get(i).clone());
		}
		return c;
	}

}
