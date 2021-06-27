package legoConnect.data;

import legoConnect.exceptions.legoExc;;

public interface legoDataManager {
	public legoTable getTable(Object data) throws legoExc;
}
