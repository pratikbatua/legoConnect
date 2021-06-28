/*
 * pratik Batua
 */

package legoConnect.data;

public class legoRowImpl implements legoRow
{
	private legoTable tbl;	
	private int row ;
	
	public legoRowImpl(legoTable t,int rowId)
	{
		this.tbl=t;
		this.row=rowId;
	}

	@Override
	public <T> T get(Class<T> type, String col) {
		return this.tbl.get(type, this.row, col);
	}

	@Override
	public <T> T get(Class<T> type, int col) {
		return this.tbl.get(type, this.row, col);
	}
	
	@Override
	public Object get(String col) {
		return this.tbl.get(this.row, col);
	}

	@Override
	public Object get(int col) {
		return this.tbl.get(this.row, col);
	}

	@Override
	public String[] getColNames() {
		return this.tbl.getColNames();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String[] cols = this.tbl.getColNames();
		sb.append("<Row-" +this.row);
		for(String col :cols)
		{
			sb.append("|"+col+"="+this.get(col));
		}
		sb.append(">\n");
		return sb.toString();
	}
}
