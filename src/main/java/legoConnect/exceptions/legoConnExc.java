/*
 * pratik Batua
 */

package legoConnect.exceptions;

public class legoConnExc extends legoExc
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private legoConnExcCode exCode;
	
	public legoConnExc() {
		
	}
	
	public legoConnExc(String erroMsg , Exception ex , legoConnExcCode code)
	{
		super(erroMsg,ex);
		this.exCode=code;
	}
	
	public legoConnExc setChildExc(String erroMsg , Exception ex , legoConnExcCode code)
	{
		this.setChildExc(erroMsg, ex);
		this.exCode = code;		
		return this;
	}
	
	public legoConnExcCode getExcCode() {
		return this.exCode;
	}
	
	public enum legoConnExcCode 
	{
		SQL,
	}
}
