package Admin;
import net.codejava.hibernate.Entiteti.*;

import java.util.List;

import net.codejava.hibernate.ControlorStrategy;
import net.codejava.hibernate.Prozor;
import net.codejava.hibernate.SajamManager;

public class AdminStrategy implements ControlorStrategy {
	private SajamManager sajam;
	private AdminView prozor;
	
	public AdminStrategy(SajamManager sajam,AdminView prozor)
	{
		this.sajam=sajam;
		this.prozor=prozor;
		this.StampajNaslov();
		
		
	}
	public String execute() {
		return "Admin mod!";
	}
	public void StampajNaslov()
	{
		prozor.l2.setText(this.execute());
	}

	public void InsertAuto(String naziv,String marka,
	String boja,
	String poreklo,
	int konji,
	int broj_sedista,
	int cena)
	{
		
		this.sajam.InsertAuto(naziv, marka, boja, poreklo, konji, broj_sedista, cena);
	}
	public void OneToManyInsert() {
		sajam.OneToMany();
		
	}
	public void RealAllSajam()
	{
		sajam.readAll();
	}
	public List<Sajam_automobila> getSajams()
	{
		return this.sajam.ListSajma();
	}
	public int getVelicinaSajma()
	{
		return this.sajam.VelicinaSajma();
	}
	public void InsertSajam(String naziv, String mesto)
	{
		this.sajam.InsertSajam(naziv,mesto);
	}
	public void UpdateSajam(int id,String naziv,String mesto)
	{
		this.sajam.UpdateSajam(id,naziv,mesto);
	}
	public void DeleteSajam(int id)
	{
		this.sajam.DeleteSajam(id);
	}
	
	
}
