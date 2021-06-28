/*
 * Pratik Batua
 */

package legoConnect.connections;

import legoConnect.connections.jdbc.jdbcDataManager;
import legoConnect.data.legoDataManager;

public class dataManagerFactory 
{
	public static legoDataManager getDataManager(connType t)
	{
		legoDataManager dm = null;
		switch(t)
		{
			case MSSQL:
			case SYBASE:
			case MYSQL:
			case ORACLE:
				dm = new jdbcDataManager();
		}		
		return dm;
	}
}
