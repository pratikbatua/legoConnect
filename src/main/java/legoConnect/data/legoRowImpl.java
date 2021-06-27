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
	public String[] getColNames() {
		return this.tbl.getColNames();
	}
}
