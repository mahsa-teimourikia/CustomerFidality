
public class LoyaltyProgram {
	private String type;
	private String condition;
	
	LoyaltyProgram(){
		this.type = "";
		this.condition = "";
	}
	
	LoyaltyProgram(String type_, String condition_)
	{
		this.type = type_;
		this.condition = condition_;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getCondition()
	{
		return condition;
	}
	
	public void setType(String type_)
	{
		this.type = type_;
	}
	
	public void setCondition(String condition_)
	{
		this.condition = condition_;
	}
}
