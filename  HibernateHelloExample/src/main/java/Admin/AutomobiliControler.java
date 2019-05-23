package Admin;
import java.io.File;
import java.util.List;

import Entiteti.*;
import SignIn.Prozor;
import SignIn.SajamManager;

public class AutomobiliControler extends AdminStrategy {
		private SajamManager sajam;
		private AutomobiliView view;
		
		public AutomobiliControler(SajamManager sajam,AutomobiliView prozor)
		{
			super(sajam);
			this.sajam=sajam;
			this.view=prozor;
			this.StampajNaslov();
		
		}
		
		public void StampajNaslov()
		{
			this.view.automobili_naslov.setText("Automobli");
		}
		public void InsertAuto(String naziv, String marka, String boja, String poreklo, int konji, int broj_sedista,
				int cena,byte[] bFile) {
			this.sajam.InsertAuto(naziv, marka, boja, poreklo, konji, broj_sedista, cena,bFile);
			
		}
		public void DodajUSajam(int id_sajma,Auto auto)
		{
			this.sajam.DodajAutoUsajam(id_sajma,auto);
		}
		
		

}
