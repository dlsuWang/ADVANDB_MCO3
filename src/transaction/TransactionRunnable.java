package transaction;

import java.sql.ResultSet;

import network.DBConnector;

public class TransactionRunnable implements Runnable {

	// EACH NODE IS ONE THREAD
	
	private Transaction transaction;
	private String statement;
	private IsolationLevel isolation;
	private ResultSet result;
	private DBConnector connector;
	
	public TransactionRunnable(Transaction transaction) {
		connector = new DBConnector();
		this.transaction = transaction;
		this.statement = transaction.getSQL();
		this.isolation = transaction.getIsolationLevel();
	}
	
	public String getIsolationStatement(IsolationLevel isolation) {
		String isolationStatement = "SET TRANSACTION LEVEL ";
		switch (isolation) {
			case READ_UNCOMMITTED: isolationStatement.concat("READ UNCOMMITTED; "); break; 
			case READ_COMMITTED: ; isolationStatement.concat("READ COMMITTED; "); break;
			case READ_REPEATABLE: isolationStatement.concat("REPEATABLE READ; "); break;
			case SERIALIZABLE: isolationStatement.concat("SERIALIZABLE; "); break;
		}
		return isolationStatement;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (isolation != IsolationLevel.NONE) {
			 statement = getIsolationStatement(isolation).concat(statement);
		}
		try {
			result = connector.queryDB(statement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
