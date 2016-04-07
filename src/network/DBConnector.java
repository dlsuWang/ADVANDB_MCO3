package network;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	private Connection connection;
	private CallableStatement callableStatement;
	private Statement statement;
	private ResultSet resultSet;
	public static int READ_UNCOMMITED = Connection.TRANSACTION_READ_UNCOMMITTED;
	public static int READ_COMMITED = Connection.TRANSACTION_READ_COMMITTED;
	public static int REPEATABLE_READ = Connection.TRANSACTION_REPEATABLE_READ;
	public static int SERIALIZABLE = Connection.TRANSACTION_SERIALIZABLE;
	
	public ResultSet queryDB(String query) throws Exception{
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_hpq_palawan", "root", "");
			statement = connection.createStatement();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			PreparedStatement ps = connection.prepareStatement(query);
		    resultSet = ps.executeQuery();
		    return resultSet;
		} 
		catch (Exception e){
			throw e;
		}
	}

	public void executeQuery(String query) throws Exception{
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_hpq_palawan", "root", "");
			statement = connection.createStatement();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			PreparedStatement ps = connection.prepareStatement(query);
		    ps.executeUpdate();
		} 
		catch (Exception e){
			throw e;
		}
	}
	
	public void close(){
	    try{
	    	if(statement != null){
	    		statement.close();
	    	}
	    	if(connection != null){
	    		connection.close();
	    	}
	    } 
	    catch(Exception e){}
	}
	
	public void setAutoCommit(boolean b){

		try{
			if(connection != null)
				connection.setAutoCommit(b);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void setIsolation(int isolation){
			
		try{
			if(connection != null)
			connection.setTransactionIsolation(isolation);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void rollBack(){
		
		try{
			if(connection != null)
				connection.rollback();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		try {
			DBConnector db = new DBConnector();
			
			ResultSet rs = db.queryDB("select * from hpq_mem;");
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				//System.out.println("haha");
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
}
