package kafic;

import java.util.ArrayList;

public class KartaPica {
	
	ArrayList<Pice> pica;
	int brojPica;
	
	public KartaPica() {
		this.pica = new ArrayList<>();
		this.brojPica = 0;
	}
	
	public void dodajPice(Pice p) throws GPostoji {
		for (Pice pice : pica) {
			if (p.equals(pice)) throw new GPostoji(p);
		}
		pica.add(p);
		brojPica++;
	}
	
	public int getBrojPica() {
		return brojPica;
	}
	
	public void dohvatiSvaPica() {
		for (Pice p : pica) {
			System.out.println(p.toString());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("GAZIRANI SOKOVI \n");
		for (int i = 0; i < brojPica; i++) {
			if (pica.get(i).getOznaka() ==  'G') {
//				sb.append(pica.get(i).getNaziv());
				sb.append(pica.get(i));
				sb.append("\n");
				
			}
		}
		sb.append("NEGAZIRANI SOKOVI \n");
		for (int i = 0; i < brojPica; i++) {
			if (pica.get(i).getOznaka() ==  'N') {
//				sb.append(pica.get(i).getNaziv());
				sb.append(pica.get(i));
				sb.append("\n");
				
			}
		}
		
		sb.append("PIVA \n");
		for (int i = 0; i < brojPica; i++) {
			if (pica.get(i).getOznaka() ==  'P') {
				sb.append(pica.get(i));
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
