
public class Transaction {
	
	private IsolationLevel level
	private String sql; 
	private boolean readOnly;
	
	public Transaction(String sql) {
		level = NONE;
		this.sql = sql;
	}
	
	public Transaction(boolean readOnly, String sql) {
		level = NONE;
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
	
	pulic void setIsolationLevel(IsolationLevel isolation) {
		this.isolation = isolation;
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