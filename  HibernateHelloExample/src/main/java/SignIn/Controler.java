package SignIn;

import Admin.AdminStrategy;
import Admin.AdminView;
import Entiteti.Korisnici;
import User.UserStrategy;
import User.UserView;


public class Controler {
	
	private SajamManager sajam;
	private Prozor prozor;
	public Controler(SajamManager sajam,Prozor prozor)
	{
		this.sajam=sajam;
		this.prozor=prozor;
		
	}
	
	
	public void ActionAdmin()
	{
		AdminView av=new AdminView();
		AdminStrategy as= new AdminStrategy(this.sajam,av);
		
		av.SetControler(as);
		
	}
	public void ActionUser()
	{
		UserView uv=new UserView();
		UserStrategy us= new UserStrategy(this.sajam,uv);
		uv.SetControler(us);
	
	}
	public void UlogujSe(String username,String password)
	{
		Korisnici korisnik =this.sajam.ReadKorisnika(username, password);
		String user=korisnik.getUsername();
		String pass=korisnik.getPassword();
		System.out.print(user + " "+ pass);
		
		if(user.equals("admin") && pass.equals("admin"))
		{
			this.ActionAdmin();
		}
		else
		{
			this.ActionUser();
		}
	}

	
	

}
