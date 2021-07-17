package gamecode;
import java.util.TimerTask;
import main.Main;
public class TaxTimmer extends TimerTask {
	public gameBuilding[][] map;
	
	public TaxTimmer(gameBuilding[][] map2) {
		// TODO Auto-generated constructor stub
		map=map2;
	}

	@Override
	public void run() {

		if (map!=null) {
			// TODO Auto-generated method stub
			for (gameBuilding[] y : map) {
				for (gameBuilding x : y) {
					if(x!=null)
					{
					Main.money += x.calcTax();
					}
				}
			} 
		}
	}

}
