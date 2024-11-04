package fakultet;

import java.util.ArrayList;
import java.util.Collections;

public class Predmet implements Uporediv{
	
	private String naziv;
	private int brojPrijavljenih;
	private ArrayList<Student> prijavlejniStudenti;
	
	public Predmet(String naziv) {
		this.naziv = naziv;
		this.brojPrijavljenih = 0;
		this.prijavlejniStudenti = new ArrayList<>();
	}
	
	public Predmet(String naziv,int broj) {
		this.naziv = naziv;
		this.brojPrijavljenih = broj;
		this.prijavlejniStudenti = new ArrayList<>();
	}
	
	public String dohvatiNaziv() {
		return naziv;
	}
	public int brojPrijavljenih() {
		return brojPrijavljenih;
	}
	
	public void prijavi(Student s) throws GStudentVecPostoji {
		if (this.prati(s)) throw new GStudentVecPostoji();
		prijavlejniStudenti.add(s);
		brojPrijavljenih++;
	}
	
	public boolean prati(Student s) {
		for (Student st : prijavlejniStudenti) {
			if (st == s) {
				return true;
			}
		}
		return false;
	}
	
	public boolean odjavi(Student s) {
		for (Student st : prijavlejniStudenti) {
			if (s == st) {
				prijavlejniStudenti.remove(s);
				brojPrijavljenih--;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv);
		sb.append("\n");
		Collections.sort(this.prijavlejniStudenti,(s1,s2)->{
			try {
				return s1.uporedi(s2);
			} catch (GRazlicitiTipovi e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return brojPrijavljenih;
		});
		for (int i = 0; i < brojPrijavljenih; i++) {
		sb.append(prijavlejniStudenti.get(i));
		sb.append("\n");
		}		
		return sb.toString();
	}

	@Override
	public int uporedi(Uporediv u) throws GRazlicitiTipovi {
		if (!(u instanceof Predmet)) throw new GRazlicitiTipovi();
		Predmet p = (Predmet) u;
		return this.naziv.compareTo(p.naziv);
	}
	

}