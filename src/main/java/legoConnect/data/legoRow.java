/*
 * Pratik Batua
 */
package legoConnect.data;

public interface legoRow
{
	String[] getColNames();
	<T> T get(Class<T> type,String col);
	<T> T get(Class<T> type,int col);
}
