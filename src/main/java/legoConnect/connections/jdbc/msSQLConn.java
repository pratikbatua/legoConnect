package legoConnect.connections.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import legoConnect.connections.connProps;
import legoConnect.connections.jdbc.jdbcConn;;

public class msSQLConn extends jdbcConn
{	
	public msSQLConn(String host,int port,String dbName,String user,String pwd)
	{
		super(host,port,dbName, user, pwd);
	}
	
	public msSQLConn(connProps props)
	{
		this(props.getHost(),props.getPort(),props.getDataObj(), props.getUser(), props.getPwd());
	}
	
	public void loadDriver() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {			
		}
	}

	
	public String getConnStr() {
		//String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=InvestorsMart;user=pratik;password=*****";		
		return 
				"jdbc:sqlserver://" + this.host + ":" + this.port + ";databaseName="+
								this.dbName+";user=" + this.user +";password=" + this.pwd;
	}
	@Override
	public Connection getConn() throws SQLException
	{	
		return DriverManager.getConnection(this.getConnStr());
	}

}
