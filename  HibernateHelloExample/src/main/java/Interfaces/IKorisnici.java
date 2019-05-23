package Interfaces;
import java.util.List;

import Entiteti.Korisnici;


public interface IKorisnici {
		public String payNow(Korisnici korisnik); 
		public List<Korisnici> getTransactionInfo(String lista);
}
