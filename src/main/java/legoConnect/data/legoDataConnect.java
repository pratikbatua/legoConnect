/*
 * pratik Batua
 */

package legoConnect.data;

import legoConnect.connections.connFactory;
import legoConnect.connections.connProps;
import legoConnect.connections.connType;
import legoConnect.connections.connection;
import legoConnect.connections.dataManagerFactory;
import legoConnect.connpool.poolProps;
import legoConnect.exceptions.legoExc;

public class legoDataConnect
{
	private String connectId ;	
	private connection conn;
	private connType connType;
	private legoDataManager dataManager;
	
	public legoDataConnect (String connectId,connProps connp , poolProps poolp)
	{		
		this.connectId=connectId;
		this.connType = connp.getConnType();
		this.conn = connFactory.getInst().getConnection(connp);
		this.conn.connect();
		this.dataManager = dataManagerFactory.getDataManager(this.connType);
	}

	public String getConnectId() {
		return this.connectId;
	}
	
	public baseDataObj exec(String query) throws legoExc
	{	
		Object data = this.conn.exec(query);
		return this.dataManager.getTable(data);		
	}
	
	public baseDataObj exec(String query,Object[] params) throws legoExc
	{	
		Object data = this.conn.exec(query,params);
		return this.dataManager.getTable(data);		
	}

	public connType getConnType() {
		return connType;
	}		
}
