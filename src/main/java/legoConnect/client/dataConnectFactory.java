/*
 * pratik Batua
 */
package legoConnect.client;

import java.util.HashMap;
import java.util.Map;

import legoConnect.connections.connProps;
import legoConnect.connpool.poolProps;
import legoConnect.data.legoDataConnect;

public class dataConnectFactory {
	
	private static dataConnectFactory fact =null;
	
	private Map<String,legoDataConnect> dataConnectMap = new HashMap<>();  
	
	public static dataConnectFactory getInst()
	{
		if(fact==null)
			fact = new dataConnectFactory();
		return fact;
	}
	
	public legoDataConnect getConnectObj(String connectId,connProps connp, poolProps poolp)
	{
		legoDataConnect dataConn = this.dataConnectMap.get(connectId) ;
		
		if(dataConn==null)
		{
			dataConn = new legoDataConnect(connectId, connp, poolp);
			this.dataConnectMap.put(connectId, dataConn);
		}
		
		return dataConn;
	}
	
	public legoDataConnect getConnectObj(String connectId)
	{
		return this.dataConnectMap.get(connectId) ;
	}
}
