package User;
import Admin.AdminView;
import net.codejava.hibernate.ControlorStrategy;
import net.codejava.hibernate.SajamManager;

public class UserStrategy implements ControlorStrategy {
	
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
