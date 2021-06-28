/*
 * pratik Batua
 */

package legoConnect.data;

import java.util.ArrayList;

public interface legoTable extends baseDataObj , Iterable<legoRow>
{
	String[] getColNames();
	int getColIndex(String colName);
	int size();
	<T> ArrayList<T> getCol(Class<T> type,String colName);
	<T> T get(Class<T> type,int row,String col);
	<T> T get(Class<T> type,int row,int col);
}
