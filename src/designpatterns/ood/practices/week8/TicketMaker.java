package designpatterns.ood.practices.week8;

class TicketMaker {

	private static TicketMaker instance;
	private int ticket;
	
	private TicketMaker(){
		this.ticket=100;
	}

    synchronized int getNextTicketNumber() {
        return ticket++;
    }

    static TicketMaker getInstance(){
    	return instance==null?instance=new TicketMaker():instance;
    }
}
