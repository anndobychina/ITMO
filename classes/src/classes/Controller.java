package classes;

public class Controller {

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	public boolean checkTicket(Passenger p){
		if(!p.ticket){
			return false;
		}
		else{
			return true;
		}
	}

}
