package transaction;

public class Transaction {
	
	private IsolationLevel level;
	private String sql; 
	private boolean readOnly;
	
	public Transaction(String sql) {
		level = IsolationLevel.NONE;
		this.sql = sql;
	}
	
	public Transaction(boolean readOnly, String sql) {
		level = IsolationLevel.NONE;
		this.readOnly = readOnly;
		this.sql = sql;
	}
	
	public Transaction(IsolationLevel level, String sql) {
		readOnly = false;
		this.level = level;
		this.sql = sql;
	}
	
	public Transaction(boolean readOnly, IsolationLevel level, String sql) {
		this.readOnly = readOnly;
		this.level = level;
		this.sql = sql;
	}
	
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	
	public void setIsolationLevel(IsolationLevel level) {
		this.level = level;
	}
	
	public void setSQL(String sql) {
		this.sql = sql;
	}
	
	public boolean getReadOnly() {
		return readOnly;
	}
	
	public IsolationLevel getIsolationLevel() {
		return level;
	}
	
	public String getSQL() {
		return sql;
	}
}