
public class AmountPerDay {
	private double amount;
	private String date;
	private String productGroup;
	private int day;
	private int month;
	
	AmountPerDay(){
		this.amount = 0.0;
		this.date = "";
		this.productGroup = "";
		this.day = 0;
		this.month = 0;
	}
	
	AmountPerDay(double amount_, String date_, String productGroup_, int day_, int month_)
	{
		this.amount = amount_;
		this.date = date_;
		this.productGroup = productGroup_;
		this.day = day_;
		this.month = month_;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getProductGroup()
	{
		return productGroup;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public void setAmount(double amount_)
	{
		this.amount = amount_;
	}
	
	public void setDate(String date_)
	{
		this.date = date_;
	}
	
	public void setProductGroup(String productGroup_)
	{
		this.productGroup = productGroup_;
	}
	
	public void setDay(int day_)
	{
		this.day = day_;
	}
	
	public void setMonth(int month_)
	{
		this.month = month_;
	}
}
