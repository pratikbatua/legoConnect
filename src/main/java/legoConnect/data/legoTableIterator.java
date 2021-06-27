package legoConnect.data;

import java.util.Iterator;

public class legoTableIterator implements Iterator<legoRow>
{
	private legoTable tbl;
	private int currentRow=-1;
	
	public legoTableIterator(legoTable t)
	{
		this.tbl = t;
	}
	
	@Override
	public boolean hasNext() 
	{
		return this.currentRow<this.tbl.size()-1;
	}

	@Override
	public legoRow next() 
	{			
		if(this.hasNext()) {
			currentRow++;
			return new legoRowImpl(this.tbl, currentRow);
		}
		return null;
	}

}
