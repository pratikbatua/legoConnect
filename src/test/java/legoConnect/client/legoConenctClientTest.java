package legoConnect.client;

import legoConnect.connections.connProps;
import legoConnect.connections.connType;
import legoConnect.connpool.poolProps;
import legoConnect.data.legoTable;
import legoConnect.exceptions.legoExc;

public class legoConenctClientTest 
{
	public static void main(String[] args)
	{
		legoConnectClient client = new  legoConnectClient();		
		client.AddDataConenct("tim", getConnProps(), new poolProps());
		
		try {
			legoTable t = (legoTable) client.exec("tim", "select * from test2");
			System.out.println(t.toString());
		} catch (legoExc e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static connProps getConnProps()
	{
		connProps cp = new connProps();
		cp.setConnType(connType.MSSQL);
		cp.setHost("localhost");
		cp.setPort(1433);
		cp.setUser("pratik");
		cp.setPwd("Pratik@1806");
		cp.setDataStore("InvestorsMart");
		
		return cp;
	}
}
