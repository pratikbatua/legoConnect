/*
 * pratik Batua
 */

package legoConnect.exceptions;

public class legoExc extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg; 
	private Exception childEx;
	
	
	public legoExc () {}
	
	public legoExc(String erroMsg,Exception ex)
	{		
		this.msg = erroMsg;
		this.childEx = ex;
	}
	
	public legoExc setChildExc(String erroMsg , Exception ex)
	{
		this.msg = erroMsg;
		this.childEx=ex;
		
		return this;
	}
	
	public String getMsg() {
		return this.msg + "\n" + this.childEx.getMessage();
	}
	
	public Exception getChildExc() {
		return this.childEx;
	}
	
}
