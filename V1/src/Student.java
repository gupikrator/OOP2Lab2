package fakultet;

public class Student implements Uporediv {
	
	private String ime;
	private int godinaUpisa;
	private int brojIndeksa;

	public Student(String ime, int godinaUpisa, int brojIndeksa) throws GPogresanIndeks {
		super();
		if (godinaUpisa > 2024 || godinaUpisa < 1970) throw new GPogresanIndeks(godinaUpisa);
		if (brojIndeksa > 799 || brojIndeksa < 1) throw new GPogresanIndeks(brojIndeksa);
		this.ime = ime;
		this.godinaUpisa = godinaUpisa;
		this.brojIndeksa = brojIndeksa;
		}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ime);
		sb.append(" ");
		sb.append(godinaUpisa);
		sb.append("/");
		if (brojIndeksa < 10) {
			sb.append("00");
		}
		else {
			if (brojIndeksa < 100) {
				sb.append("0");
			}
		}
		sb.append("0");
		sb.append(brojIndeksa);
		return sb.toString();
	}
	
	@Override
	public int uporedi(Uporediv u) throws GRazlicitiTipovi {
		if (!(u instanceof Student)) throw new GRazlicitiTipovi();
		Student s = (Student) u;
		if (s.godinaUpisa < this.godinaUpisa) {
			return 1;
		}
		else {
			if (s.godinaUpisa == this.godinaUpisa) {
				if (s.brojIndeksa < this.brojIndeksa) {
					return 1;
				}
				else {
					if (s.brojIndeksa == this.brojIndeksa) {return 0;}
					return -1;
				}
			}
			return -1;
		}
	}
	
}
 