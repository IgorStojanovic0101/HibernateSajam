package Admin;
import java.util.List;

import Entiteti.*;
import SignIn.Prozor;
import SignIn.SajamManager;

public class AdminStrategy  {
	public SajamManager sajam;
	private AdminView prozor;
	
	public AdminStrategy(SajamManager sajam,AdminView prozor)
	{
		this.sajam=sajam;
		this.prozor=prozor;
		this.StampajNaslov();
		
	
	}
	public AdminStrategy(SajamManager sajam)
	{
		this.sajam=sajam;
	
	}
	
	public SajamManager getSajam()
	{
		return this.sajam;
	}
	public String execute() {
		return "Admin mod!";
	}
	public void StampajNaslov()
	{
		prozor.l2.setText(this.execute());
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
	public List<Auto>getAutos()
	{
		return this.sajam.ListAuto();
	}
	public List<Auto> getOdredjeniAutomobili(int id_sajma)
	{
		return this.sajam.ListaAutomobilaNaSajmu(id_sajma);
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
