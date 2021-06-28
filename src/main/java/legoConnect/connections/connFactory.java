/*
 * pratik Batua
 */

package legoConnect.connections;

import legoConnect.connections.jdbc.msSQLConn;

public class connFactory 
{
	private static connFactory fact=null;
	
	private connFactory()
	{		
	}
	
	public static connFactory getInst()
	{
		if(fact==null)
			fact = new connFactory();
		
		return fact;
	}
	
	public connection getConnection(connProps props)
	{
		connection conn = null;
		
		switch (props.getConnType())
		{
			case MSSQL:
					conn =  new msSQLConn(props);
				break;
			case SYBASE:
				break;
			case ORACLE:
				break;
			case MYSQL:
				break;
			default:
				break;			
		}
		return conn;
	}
}
