
public class Transaction {
	
	private IsolationLevel level
	private String sql; 
	
	public Transaction(String sql) {
		level = NONE;
		this.sql = sql;
	}
	
	public Transaction(IsolationLevel level, String sql) {
		this.level = level;
		this.sql = sql;
	}
	
	public IsolationLevel getIsolationLevel() {
		return level;
	}
	
	public String getSQL() {
		return sql;
	}
}