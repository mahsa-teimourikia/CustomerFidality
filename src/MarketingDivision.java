
public class MarketingDivision {
	private String name;
	private String headOfDivision;
	
	MarketingDivision(){
		this.name = "";
		this.headOfDivision = "";
	}
	
	MarketingDivision(String name_, String headOfDivision_)
	{
		this.name = name_;
		this.headOfDivision = headOfDivision_;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getHeadOfDivision()
	{
		return headOfDivision;
	}
	
	public void setName(String name_)
	{
		this.name = name_;
	}
	
	public void setHeadOfDivision(String headOfDivision_)
	{
		this.headOfDivision = headOfDivision_;
	}
}
