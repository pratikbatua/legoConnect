/*
 * Pratik Batua
 */

package legoConnect.client;

import legoConnect.connections.connProps;
import legoConnect.connpool.poolProps;
import legoConnect.data.baseDataObj;
import legoConnect.data.legoDataConnect;
import legoConnect.exceptions.legoExc;

public class legoConnectClient 
{	
	public void AddDataConenct(String connectId,connProps connp , poolProps poolp)
	{
		dataConnectFactory.getInst().getConnectObj(connectId, connp, poolp);
	}
	
	public baseDataObj exec(String connectId,String query) throws legoExc
	{
		legoDataConnect dConn = dataConnectFactory.getInst().getConnectObj(connectId);
		return dConn.exec(query);
	}
	
	public baseDataObj exec(String connectId,String query,Object[] params) throws legoExc
	{
		legoDataConnect dConn = dataConnectFactory.getInst().getConnectObj(connectId);
		return dConn.exec(query,params);
	}
}
