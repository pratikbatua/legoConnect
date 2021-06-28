/*
 * pratik Batua
 */

package legoConnect.connections.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import legoConnect.data.legoDataManager;
import legoConnect.data.legoTable;
import legoConnect.exceptions.legoExc;

public class jdbcDataManager implements legoDataManager 
{
	@Override
	public legoTable getTable(Object data) throws legoExc 
	{	
		if(ResultSet.class.isInstance(data))
		{	
			try
			{
				// Creating the meta of the table
				ResultSet r = (ResultSet) data;
				ResultSetMetaData rmeta = r.getMetaData();
				String[] colNames = new String[rmeta.getColumnCount()];
				costomArrayList[] cols = new costomArrayList[colNames.length];
				
				for (int i=0;i<colNames.length;i++) {
					colNames[i] = rmeta.getColumnName(i+1);
					cols[i] = this.getCustomArrayList(rmeta.getColumnType(i+1));
				}
				
				while (r.next())
				{
					for(int i=0;i<colNames.length;i++)
						cols[i].AddObj(r.getObject(colNames[i]));
				}
				
				return new jdbcTable(colNames, cols);
			}
			catch(SQLException ex)
			{
				
			}
		}		
		return null;
	}

	public costomArrayList getCustomArrayList(int type) {
		
		costomArrayList c = new costomArrayList<>();
		
		switch (type) 
		{
			case Types.INTEGER:
				c = new costomArrayList<Integer>();
				break;
	
			case Types.SMALLINT:
			case Types.TINYINT:
				c = new costomArrayList<Short>();
				break;
	
			case Types.BIGINT:
				c = new costomArrayList<Long>();
				break;
				
			case Types.FLOAT:
			case Types.REAL:
				c = new costomArrayList<Float>();
				break;
	
			case Types.DOUBLE:
			case Types.DECIMAL:
			case Types.NUMERIC:
				c = new costomArrayList<Double>();
				break;
				
			case Types.BOOLEAN:
				c = new costomArrayList<Boolean>();
				break;
				
			case Types.VARCHAR:
			case Types.CHAR:
			case Types.NVARCHAR:
			case Types.VARBINARY:
			case Types.BINARY:
				c = new costomArrayList<String>();
				break;
	
			case Types.TIMESTAMP:
				c = new costomArrayList<Timestamp>();
				break;
	
			case Types.TIME:
				c = new costomArrayList<Time>();
				break;
	
			case Types.DATE:
				c = new costomArrayList<Date>();
				break;
	
			default:
				break;	
		}
		
		return c;
	}

	private class costomArrayList<T> extends  ArrayList<T> {				
		public void AddObj(Object item) {
			this.add((T)item);
		}
		public T[] getArray() {
			return (T[]) this.toArray();
		}
	}
}
