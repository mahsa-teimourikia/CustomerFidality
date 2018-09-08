
public class Supplier {
	private String name;
	private String location;
	
	Supplier(){
		this.name = "";
		this.location = "";
	}
	
	Supplier(String name_, String location_)
	{
		this.name = name_;
		this.location = location_;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setName(String name_)
	{
		this.name = name_;
	}
	
	public void setLocation(String location_)
	{
		this.location = location_;
	}
}
