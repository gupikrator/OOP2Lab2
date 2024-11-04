package kafic;

public class GPostoji extends Exception {
	
	public GPostoji(Pice p){
        super("Pice " + p.getNaziv() + " vec postoji u karti.");
    }

}
