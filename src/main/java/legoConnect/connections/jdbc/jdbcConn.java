/*
 * pratik Batua
 */

package legoConnect.connections.jdbc;


import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import legoConnect.connections.connection;
import legoConnect.connections.jdbc.msSQLConn;
import legoConnect.data.legoRow;
import legoConnect.data.legoTable;
import legoConnect.exceptions.legoConnExc;
import legoConnect.exceptions.legoConnExc.legoConnExcCode;

public abstract class jdbcConn implements connection
{	
	public abstract String getConnStr();
	public abstract void loadDriver();
	public abstract java.sql.Connection getConn() throws SQLException;
	
	protected String user,pwd,host,dbName;
	protected int port;
	
	private java.sql.Connection conn;
	
	public jdbcConn(String host,int port,String dbName,String user,String pwd)
	{
		this.host  =host;
		this.port = port;
		this.dbName = dbName;
		this.user =  user;
		this.pwd = pwd;
	}
	
	public void connect() 
	{		
		try 
		{			
			this.loadDriver();			
			this.conn = this.getConn();		
			 if (conn != null) 
			 {
	             DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	             System.out.println("Driver name: " + dm.getDriverName());
	             System.out.println("Driver version: " + dm.getDriverVersion());
	             System.out.println("Product name: " + dm.getDatabaseProductName());
	             System.out.println("Product version: " + dm.getDatabaseProductVersion());
	         }
		} 
		catch (Exception ex)
		{
            ex.printStackTrace();
        }
	}	
	
	public Object exec(String query) throws legoConnExc
	{	
		try
		{
			PreparedStatement s =  this.conn.prepareStatement(query);
			return  s.executeQuery();
		}
		catch(SQLException ex)
		{
			throw new legoConnExc().setChildExc("unbale to execute query. " + query, ex, legoConnExcCode.SQL);
		}
	}
	
	
	public Object exec(String query,Object[] params) throws legoConnExc  { 
		try
		{
			PreparedStatement s =  this.conn.prepareStatement(query);
			for(int i=0;i<params.length;i++)
			{
				s.setObject(i+1, params[i]);
			}
			return s.executeQuery();
		}
		catch(SQLException ex)
		{
			throw new legoConnExc().setChildExc("unbale to execute query. " + query, ex, legoConnExcCode.SQL);
		}
	}
	
	public void execAsync(String query) throws legoConnExc
	{			
	}
	
	public void execAsync(String query,Object[] params) throws legoConnExc { 
	}
	
	public static void main(String[] args) 
	{
		try 
		{
			msSQLConn sqlConn = new msSQLConn("localhost", 1433, "InvestorsMart", "Pratik", "Pratik@1806");
			sqlConn.connect();
			Object data = sqlConn.exec("select * from test2 where id =? or id = ? ", new Object[] {1,2});
			
			legoTable t =  new jdbcDataManager().getTable(data);
			
			
			System.out.println(t.get(Integer.class, 0, 0));
			System.out.println(t.get(String.class, 0, 1));
			System.out.println(t.get(String.class, 0, 2));
			
			Iterator<legoRow> itr =  t.iterator();
			
			while(itr.hasNext())
			{
				legoRow r= itr.next();
				
				System.out.println(r.get(Integer.class, "id"));
				System.out.println(r.get(String.class, "name"));
				System.out.println(r.get(String.class,"addr"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}	
}