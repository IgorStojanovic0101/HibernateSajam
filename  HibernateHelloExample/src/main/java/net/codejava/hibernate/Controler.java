package net.codejava.hibernate;

public class Controler {
	private SajamManager sajam;
	private Prozor prozor;
	public Controler(SajamManager sajam,Prozor prozor)
	{
		this.sajam=sajam;
		this.prozor=prozor;
		
	}
	public void PrikaziNaslov() {
		prozor.l1.setText(sajam.read());
		
	}
	public void Unesi()
	{
		String naziv=prozor.tb1.getText();
		String mesto=prozor.tb2.getText();
		sajam.create(naziv,mesto);
	}

}
