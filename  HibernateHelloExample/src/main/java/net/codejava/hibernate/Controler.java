package net.codejava.hibernate;

import Admin.AdminStrategy;
import Admin.AdminView;
import User.UserStrategy;
import User.UserView;


public class Controler {
	private ControlorStrategy strategy;
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
		
	}
	public void ActionAdmin()
	{
		AdminView av=new AdminView();
		AdminStrategy as= new AdminStrategy(this.sajam,av);
		changeStrategy(as);
		av.SetControler(as);
		prozor.izabrano.setText(strategy.execute());
		
	}
	public void ActionUser()
	{
		UserView uv=new UserView();
		changeStrategy(new UserStrategy(this.sajam,uv));
		prozor.izabrano.setText(strategy.execute());
		
		
		
	}
	public void changeStrategy(ControlorStrategy strategy) {
		this.strategy = strategy;
	}
	
	
	

}
