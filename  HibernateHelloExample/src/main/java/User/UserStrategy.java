package User;
import Admin.AdminView;
import SignIn.SajamManager;

public class UserStrategy  {
	
	private SajamManager sajam;
	private UserView prozor;
	
	public UserStrategy(SajamManager sajam,UserView prozor)
	{
		this.sajam=sajam;
		this.prozor=prozor;
		StampajNaslov();
	}
		
	public String execute() {
		return "User mod!";
	}
	public void StampajNaslov()
	{
		prozor.l1.setText(this.execute());
	}
}
