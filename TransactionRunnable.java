
public class TransactionRunnable implements Runnable {

	// EACH NODE IS ONE THREAD
	
	private DBConnector connection;
	private Transaction transaction;
	
	public TransactionRunnable(String transaction) {
		this.transaction = transaction;
		
		DBConnector.queryDB(transaction.getSQL());
		// send to database
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
