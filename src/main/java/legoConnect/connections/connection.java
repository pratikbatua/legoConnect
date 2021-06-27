package legoConnect.connections;

import legoConnect.exceptions.legoConnExc;;

public interface connection 
{
	public void connect();
	public Object exec(String query) throws legoConnExc;
	public Object exec(String query,Object[] params) throws legoConnExc;
	public void execAsync(String query) throws legoConnExc;
	public void execAsync(String query,Object[] params) throws legoConnExc;
}
