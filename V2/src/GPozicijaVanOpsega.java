package racunari;

public class GPozicijaVanOpsega extends Exception {

	public GPozicijaVanOpsega(int i){
        super("Greska: indeks " + i + " je van opsega");
    }
}
