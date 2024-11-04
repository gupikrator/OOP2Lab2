package fakultet;

public class GPogresanIndeks extends Exception {

	public GPogresanIndeks(int broj) {
		super("Indeks" + broj + " je nemoguc");
		
	}

}
