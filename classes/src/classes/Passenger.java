package classes;

public class Passenger {
	public boolean ticket;
	public int money;
	public int cunning;
	public Passenger() {
		// TODO Auto-generated constructor stub
		this.ticket=false;
		this.money=100;
		this.cunning=0;
	}
	public boolean payTicket(){
		if(this.money<30&this.cunning<5){
			return false;
		}
		else{
			this.cunning+=2;
			this.money-=30;
			this.ticket=true;
			return true;
		}
	}

}
