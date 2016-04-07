
public class TransactionRunnable implements Runnable {

	// EACH NODE IS ONE THREAD
	
	private String transaction;
	
	public TransactionRunnable(String transaction) {
		this.transaction = transaction;
		// send to database
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
