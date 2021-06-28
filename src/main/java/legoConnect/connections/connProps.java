/*
 * pratik Batua
 */

package legoConnect.connections;

import java.util.HashMap;
import java.util.Map;

public class connProps {	
	
	private String user,pwd,host,dataStore;
	private connType conntype;
	int port;
	
	Map<String, Object> custom = new HashMap<>();
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public void addCustomProp(String k,Object v)
	{
		this.custom.put(k, v);
	}
	
	public Object getCustomProp(String key)
	{
		return this.custom.get(key);
	}

	public connType getConnType() {
		return conntype;
	}

	public void setConnType(connType conntype) {
		this.conntype = conntype;
	}

	public String getDataStore() {
		return dataStore;
	}

	public void setDataStore(String dataStore) {
		this.dataStore = dataStore;
	}
}
