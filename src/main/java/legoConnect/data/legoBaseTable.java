/*
 * pratik Batua
 */

package legoConnect.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public abstract class legoBaseTable implements legoTable
{
	Map <String,Integer> colMap = new HashMap<>();
	
	ArrayList[] data;
	
	public legoBaseTable(String[] cols,ArrayList[] data)
	{
		for(int i=0;i<cols.length;i++)
			colMap.put(cols[i],i);
		this.data=data;
	}

	@Override
	public String[] getColNames() 
	{
		return this.colMap.keySet().toArray(new String[0]);
	}
	
	@Override
	public int getColIndex(String colName) {
		return this.colMap.get(colName);
	}
	
	@Override
	public int size() {
		return this.data[0].size();
	}

	@Override
	public <T> ArrayList<T> getCol(Class<T> type,String colName) {
		return (ArrayList<T>) this.data[this.colMap.get(colName)];
	}

	@Override
	public <T> T get(Class<T> type,int row,String col) {
		return this.getCol(type,col).get(row);
	}	
	
	@Override
	public <T> T get(Class<T> type,int row, int col) {
		return (T)this.data[col].get(row);
	}
	
	@Override
	public ArrayList getCol(String colName) {
		return (ArrayList) this.data[this.colMap.get(colName)];
	}

	@Override
	public Object get(int row,String col) {
		return this.getCol(col).get(row);
	}	
	
	@Override
	public Object get(int row, int col) {
		return this.data[col].get(row);
	}
	
	@Override
	public Iterator<legoRow> iterator()
	{
		return new legoTableIterator(this);
	}
	
	@Override
	public String getJson()
	{
		return "";
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Iterator<legoRow> itr = this.iterator();
		while(itr.hasNext())
		{
			sb.append(itr.next());
		}
		return sb.toString();
	}
}
